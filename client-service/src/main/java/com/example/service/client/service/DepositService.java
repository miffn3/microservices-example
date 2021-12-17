package com.example.service.client.service;

import com.example.service.client.api.dto.DepositDto;

import java.util.List;

public interface DepositService {

    DepositDto getDepositById(Long id);

    List<DepositDto> getDepositsByClientId(Long id);

    DepositDto updateDepositInfo(Long id, DepositDto depositDto);

    DepositDto createDepositByClientId(Long clientId, DepositDto depositDto);
}
