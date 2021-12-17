package com.example.service.cashback.service;

import com.example.service.cashback.api.dto.CashbackDto;

public interface CashbackService {

    CashbackDto getCashbackByClientId(Long id);

    CashbackDto saveClientsCashBack(Long id, CashbackDto cashbackRequestDto);
}
