package com.example.payment_gateway;

import com.example.payment_gateway.entity.Payment;
import com.example.payment_gateway.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PaymentRepositoryTest {
    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void testFindByPaymentScheme() {
        // Create a new Payment object
        Payment payment = new Payment();
        payment.setPaymentScheme("Credit Card");
        payment.setAmount(100.0);
        payment.setTransactionId("TXN12345");
        payment.setStatus("Pending");

        // Save the Payment object to the repository
        paymentRepository.save(payment);

        // Retrieve the list of payments by payment scheme
        List<Payment> payments = paymentRepository.findByPaymentScheme("Credit Card");

        // Assert that the list is not null and not empty
        assertNotNull(payments);
        assertFalse(payments.isEmpty());

        // Assert that the payment scheme of the first payment in the list is "Credit Card"
        assertEquals("Credit Card", payments.get(0).getPaymentScheme());
    }
}