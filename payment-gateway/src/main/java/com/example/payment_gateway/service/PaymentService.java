package com.example.payment_gateway.service;

import com.example.payment_gateway.entity.Payment;
import com.example.payment_gateway.repository.PaymentRepository;
import io.nats.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Connection natsConnection;

    public Payment createPayment(Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        try {
            natsConnection.publish("payments", ("Payment created: " + savedPayment.getId()).getBytes());
        } catch (Exception e) {
            logger.error("Failed to publish message to NATS", e);
        }
        return savedPayment;
    }

    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public List<Payment> getPaymentsByScheme(String paymentScheme) {
        return paymentRepository.findByPaymentScheme(paymentScheme);
    }
}