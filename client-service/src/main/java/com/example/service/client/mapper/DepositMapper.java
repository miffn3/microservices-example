package com.example.service.client.mapper;

import com.example.service.client.api.dto.DepositDto;
import com.example.service.client.entity.Deposit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DepositMapper {

    DepositDto mapDepositDto(Deposit deposit);

//    @Mapping(target = "amount", source = "depositDto.amount")
    Deposit mapDeposit(Long id, DepositDto depositDto);

//    @Mapping(target = "amount", source = "depositDto.amount")
//    @Mapping(target = "client.id", source = "clientId")
    Deposit mapDepositWithClientId(Long clientId, DepositDto depositDto);
}
