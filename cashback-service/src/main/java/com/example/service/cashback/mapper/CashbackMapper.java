package com.example.service.cashback.mapper;

import com.example.service.cashback.api.dto.CashbackDto;
import com.example.service.cashback.entity.Cashback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CashbackMapper {

    CashbackDto mapCashbackDto(Cashback cashback);

    @Mapping(target = "amount", source = "cashbackDto.amount")
    Cashback mapCashback(Long id, CashbackDto cashbackDto);
}
