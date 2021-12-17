package com.example.service.payment.service.feign.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositDto {

    private Long id;

    private BigDecimal amount;
}
