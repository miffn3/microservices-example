package com.example.service.client.api.controller;

import com.example.service.client.api.dto.DepositDto;
import com.example.service.client.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v3/deposit")
@RequiredArgsConstructor
public class DepositController {

    private final DepositService depositService;

    @GetMapping("/{id}")
    public ResponseEntity<DepositDto> getDepositInfo(@PathVariable Long id) {
        return Optional.ofNullable(depositService.getDepositById(id))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<DepositDto> createDepositByClientId(@PathVariable Long id, @RequestBody DepositDto depositDto) {
        return Optional.ofNullable(depositService.createDepositByClientId(id, depositDto))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }
}

