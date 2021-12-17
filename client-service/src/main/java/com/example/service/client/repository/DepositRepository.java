package com.example.service.client.repository;

import com.example.service.client.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

    List<Deposit> findAllByClient_Id(Long clientId);
}
