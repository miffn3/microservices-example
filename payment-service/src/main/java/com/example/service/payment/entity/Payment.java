package com.example.service.payment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
public class Payment {

    @Id
    private Long id;

    private BigDecimal previousAmount;

    private BigDecimal amount;

    private BigDecimal cashBack;

    @ManyToOne
    private Payer payer;

}
