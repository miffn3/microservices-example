package com.example.service.cashback.repository;

import com.example.service.cashback.entity.Cashback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashbackRepository extends JpaRepository<Cashback, Long> {
}
