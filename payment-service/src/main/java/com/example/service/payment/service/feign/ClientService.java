package com.example.service.payment.service.feign;

import com.example.service.payment.service.feign.dto.ClientDto;
import com.example.service.payment.service.feign.dto.DepositDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "client-service")
public interface ClientService {

    @GetMapping("/api/v1/client/client/{id}")
    ClientDto getClientById(Long id);

    @GetMapping("/api/v1/deposit/{id}")
    DepositDto getDepositInfo(@PathVariable Long id);

    @GetMapping("/api/v1/deposit/all/{id}")
    List<DepositDto> getDepositsByClientId(@PathVariable Long id);

    @PutMapping("/api/v1/deposit/{id}")
    DepositDto updateDepositInfo(@PathVariable Long id, @RequestBody DepositDto depositDto);
}
