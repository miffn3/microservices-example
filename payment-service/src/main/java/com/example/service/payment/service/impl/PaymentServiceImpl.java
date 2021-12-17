package com.example.service.payment.service.impl;

import com.example.service.payment.api.dto.PaymentRequestDto;
import com.example.service.payment.api.dto.PaymentResponseDto;
import com.example.service.payment.entity.Payment;
import com.example.service.payment.mapper.PaymentMapper;
import com.example.service.payment.repository.PaymentRepository;
import com.example.service.payment.service.PaymentService;
import com.example.service.payment.service.feign.CashbackService;
import com.example.service.payment.service.feign.ClientService;
import com.example.service.payment.service.feign.dto.CashbackDto;
import com.example.service.payment.service.feign.dto.ClientDto;
import com.example.service.payment.service.feign.dto.DepositDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    public static final double CASHBACK_COEFFICIENT = 1.1;

    private final ClientService clientService;
    private final CashbackService cashbackService;

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponseDto payByClientId(Long id, PaymentRequestDto paymentRequest) {
        ClientDto clientDto = clientService.getClientById(id);
        return clientService.getDepositsByClientId(id)
                .stream()
                .filter(this::checkDepositAmount)
                .findFirst()
                .map(deposit -> payWithDeposit(deposit, clientDto, id, paymentRequest))
                .map(paymentMapper::mapPaymentResponse)
                .orElse(null);
    }

    private boolean checkDepositAmount(DepositDto deposit) {
        BigDecimal amount = deposit.getAmount();
        return amount != null
                && BigDecimal.ZERO.compareTo(amount) <= 0;
    }

    private Payment payWithDeposit(DepositDto deposit, ClientDto clientDto, Long clientId, PaymentRequestDto paymentRequest) {
        BigDecimal depositAmount = deposit.getAmount();
        BigDecimal paymentAmount = paymentRequest.getAmount();
        BigDecimal newAmount = depositAmount.subtract(paymentAmount);

        deposit.setAmount(newAmount);

        CashbackDto cashbackDto = cashbackService.getClientsCashBack(clientId);
        cashbackDto.setAmount(calculateCashback(newAmount, cashbackDto));

        Payment payment = paymentRepository.save(paymentMapper.mapPayment(clientDto, deposit, cashbackDto, paymentRequest));

        Long depositId = deposit.getId();
        try {
            clientService.updateDepositInfo(depositId, deposit);
            try {
                cashbackService.updateClientsCashback(clientId, cashbackDto);
            } catch (Exception ex) {
                deposit.setAmount(depositAmount);
                clientService.updateDepositInfo(depositId, deposit);
                throw ex;
            }
        } catch (Exception ex) {
            log.error("Rollback payment cause error occurred.", ex);
            paymentRepository.delete(payment);
            throw ex;
        }

        return payment;
    }

    private BigDecimal calculateCashback(BigDecimal newAmount, CashbackDto cashbackDto) {
        return cashbackDto.getAmount().add(newAmount.multiply(BigDecimal.valueOf(CASHBACK_COEFFICIENT)));
    }
}
