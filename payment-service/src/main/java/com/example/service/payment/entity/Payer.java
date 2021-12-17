package com.example.service.payment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Payer {

    @Id
    private Long id;

    private String firstName;

    private String lastName;
}
