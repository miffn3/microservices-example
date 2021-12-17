package com.example.service.payment.mapper;

import com.example.service.payment.api.dto.PayerDto;
import com.example.service.payment.api.dto.PaymentRequestDto;
import com.example.service.payment.api.dto.PaymentResponseDto;
import com.example.service.payment.entity.Payer;
import com.example.service.payment.entity.Payment;
import com.example.service.payment.service.feign.dto.CashbackDto;
import com.example.service.payment.service.feign.dto.ClientDto;
import com.example.service.payment.service.feign.dto.DepositDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PaymentMapper {

    PaymentResponseDto mapPaymentResponse(Payment payment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "amount", source = "paymentRequestDto.amount")
    @Mapping(target = "payer", source = "clientDto")
    Payment mapPayment(ClientDto clientDto, DepositDto depositDto, CashbackDto cashbackDto, PaymentRequestDto paymentRequestDto);

    Payer mapPayer(ClientDto clientDto);

    PayerDto mapPayerDto(Payer payer);
}
