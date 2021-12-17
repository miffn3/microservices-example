package com.example.service.client.service.impl;

import com.example.service.client.api.dto.DepositDto;
import com.example.service.client.entity.Deposit;
import com.example.service.client.mapper.DepositMapper;
import com.example.service.client.repository.DepositRepository;
import com.example.service.client.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DepositServiceImpl implements DepositService {

    private final DepositRepository depositRepository;
    private final DepositMapper depositMapper;

    @Override
    public DepositDto getDepositById(Long id) {
        return depositRepository.findById(id)
                .map(depositMapper::mapDepositDto)
                .orElse(null);
    }

    @Override
    public List<DepositDto> getDepositsByClientId(Long clientId) {
        return depositRepository.findAllByClient_Id(clientId)
                .stream()
                .map(depositMapper::mapDepositDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepositDto updateDepositInfo(Long id, DepositDto depositDto) {
        Deposit deposit = depositMapper.mapDeposit(id, depositDto);
        return depositMapper.mapDepositDto(depositRepository.save(deposit));
    }

    @Override
    public DepositDto createDepositByClientId(Long clientId, DepositDto depositDto) {
        Deposit deposit = depositMapper.mapDepositWithClientId(clientId, depositDto);
        return depositMapper.mapDepositDto(depositRepository.save(deposit));
    }
}
