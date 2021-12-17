package com.example.service.payment.service.feign.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CashbackDto {

    private BigDecimal amount;
}
