package com.example.service.client.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Entity
public class Deposit {

    @Id
    private Long id;

    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;
}
