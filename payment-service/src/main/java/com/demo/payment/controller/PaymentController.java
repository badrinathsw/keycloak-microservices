package com.demo.payment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping
    public Map<String, Object> getPayments(Authentication authentication) {
        return Map.of(
                "service", "payment-service",
                "message", "Payments retrieved successfully",
                "authenticatedClient", authentication.getName(),
                "payments", List.of(
                        Map.of("id", 501, "orderId", 101, "status", "SUCCESS"),
                        Map.of("id", 502, "orderId", 102, "status", "PENDING")
                )
        );
    }

    @GetMapping("/{id}")
    public Map<String, Object> getPayment(@PathVariable int id,
                                          Authentication authentication) {
        return Map.of(
                "service", "payment-service",
                "paymentId", id,
                "authenticatedClient", authentication.getName()
        );
    }
}
