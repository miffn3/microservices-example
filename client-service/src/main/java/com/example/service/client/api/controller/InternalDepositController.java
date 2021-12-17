package com.example.service.client.api.controller;

import com.example.service.client.api.dto.DepositDto;
import com.example.service.client.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/deposit")
@RequiredArgsConstructor
public class InternalDepositController {

    private final DepositService depositService;

    @GetMapping("/{id}")
    public DepositDto getDepositInfo(@PathVariable Long id) {
        return depositService.getDepositById(id);
    }

    @GetMapping("/all/{id}")
    public List<DepositDto> getDepositsByClientId(@PathVariable Long id) {
        return depositService.getDepositsByClientId(id);
    }

    @PutMapping("/{id}")
    public DepositDto updateDepositInfo(@PathVariable Long id, @RequestBody @Valid DepositDto depositDto) {
        return depositService.updateDepositInfo(id, depositDto);
    }
}
