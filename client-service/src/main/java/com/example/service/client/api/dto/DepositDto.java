package com.example.service.client.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DepositDto {

    private Long id;

    @NotNull
    private BigDecimal amount;
}
