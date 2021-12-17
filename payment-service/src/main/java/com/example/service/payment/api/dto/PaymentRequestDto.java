package com.example.service.payment.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class PaymentRequestDto {

    @NotNull
    private BigDecimal amount;
}
