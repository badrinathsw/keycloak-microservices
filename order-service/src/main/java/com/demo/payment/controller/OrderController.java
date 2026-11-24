package com.demo.payment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public Map<String, Object> getOrders(Authentication authentication) {
        return Map.of(
                "service", "order-service",
                "message", "Orders retrieved successfully",
                "authenticatedClient", authentication.getName(),
                "orders", List.of(
                        Map.of("id", 101, "product", "Laptop", "amount", 75000),
                        Map.of("id", 102, "product", "Phone", "amount", 35000)
                )
        );
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrder(@PathVariable int id,
                                        Authentication authentication) {
        return Map.of(
                "service", "order-service",
                "orderId", id,
                "authenticatedClient", authentication.getName()
        );
    }
}
