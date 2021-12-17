package com.example.service.payment.api.controller;


import com.example.service.payment.api.dto.PaymentResponseDto;
import com.example.service.payment.api.dto.PaymentRequestDto;
import com.example.service.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v3/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> paySomeMoney(@PathVariable Long id, @RequestBody @Valid PaymentRequestDto paymentRequest) {
        return Optional.ofNullable(paymentService.payByClientId(id, paymentRequest))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }
}
