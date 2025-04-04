package com.example.payment_gateway.service;

import com.example.payment_gateway.entity.Payment;
import com.example.payment_gateway.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public List<Payment> getPaymentsByScheme(String paymentScheme) {
        return paymentRepository.findByPaymentScheme(paymentScheme);
    }
}