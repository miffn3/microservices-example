package com.example.service.payment.service.feign;

import com.example.service.payment.service.feign.dto.CashbackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cashback-service")
public interface CashbackService {

    @GetMapping("/api/v1/cashback/{id}")
    CashbackDto getClientsCashBack(@PathVariable Long id);

    @PostMapping("/api/v1/cashback/{id}")
    CashbackDto updateClientsCashback(@PathVariable Long id, @RequestBody CashbackDto cashbackRequestDto);

}
