package com.example.service.payment.service;

import com.example.service.payment.api.dto.PaymentResponseDto;
import com.example.service.payment.api.dto.PaymentRequestDto;

public interface PaymentService {

    PaymentResponseDto payByClientId(Long id, PaymentRequestDto paymentRequest);
}
