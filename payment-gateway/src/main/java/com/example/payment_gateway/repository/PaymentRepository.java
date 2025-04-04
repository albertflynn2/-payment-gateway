package com.example.payment_gateway.repository;

import com.example.payment_gateway.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByPaymentScheme(String paymentScheme);
}
