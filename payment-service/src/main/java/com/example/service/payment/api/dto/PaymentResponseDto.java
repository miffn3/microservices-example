package com.example.service.payment.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentResponseDto {

    private PayerDto payer;

    private BigDecimal previousAmount;

    private BigDecimal amount;

    private BigDecimal cashBack;

}
