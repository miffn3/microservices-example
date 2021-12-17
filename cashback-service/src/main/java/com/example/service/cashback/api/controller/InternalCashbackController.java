package com.example.service.cashback.api.controller;

import com.example.service.cashback.api.dto.CashbackDto;
import com.example.service.cashback.service.CashbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cashback")
public class InternalCashbackController {

    private final CashbackService cashbackService;

    @GetMapping("/{id}")
    public CashbackDto getClientsCashback(@PathVariable Long id) {
        return cashbackService.getCashbackByClientId(id);
    }

    @PostMapping("/{id}")
    public CashbackDto updateClientsCashback(Long id, @RequestBody CashbackDto cashbackRequestDto) {
        return cashbackService.saveClientsCashBack(id, cashbackRequestDto);
    }
}
