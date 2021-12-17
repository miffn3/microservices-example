package com.example.service.cashback.service.impl;

import com.example.service.cashback.api.dto.CashbackDto;
import com.example.service.cashback.entity.Cashback;
import com.example.service.cashback.mapper.CashbackMapper;
import com.example.service.cashback.repository.CashbackRepository;
import com.example.service.cashback.service.CashbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CashbackServiceImpl implements CashbackService {

    private final CashbackRepository cashbackRepository;
    private final CashbackMapper cashbackMapper;

    @Override
    public CashbackDto getCashbackByClientId(Long id) {
        return cashbackRepository.findById(id)
                .map(cashbackMapper::mapCashbackDto)
                .orElseGet(this::buildZeroCashback);
    }

    private CashbackDto buildZeroCashback() {
        CashbackDto cashbackDto = new CashbackDto();
        cashbackDto.setAmount(BigDecimal.ZERO);
        return cashbackDto;
    }

    @Override
    public CashbackDto saveClientsCashBack(Long id, CashbackDto cashbackRequestDto) {
        Cashback cashback = cashbackMapper.mapCashback(id, cashbackRequestDto);
        return cashbackMapper.mapCashbackDto(cashbackRepository.save(cashback));
    }
}
