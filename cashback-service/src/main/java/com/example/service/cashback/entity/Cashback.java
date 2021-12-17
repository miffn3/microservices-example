package com.example.service.cashback.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Cashback {

    @Id
    private Long id;

    private BigDecimal amount;
}
