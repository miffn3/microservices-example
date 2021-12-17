package com.example.service.cashback.api.controller;

import com.example.service.cashback.api.dto.CashbackDto;
import com.example.service.cashback.service.CashbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v3/cashback")
public class CashbackController {

    private final CashbackService cashbackService;

    @GetMapping("/{id}")
    public ResponseEntity<CashbackDto> getClientsCashback(@PathVariable Long id) {
        return Optional.ofNullable(cashbackService.getCashbackByClientId(id))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }
}
