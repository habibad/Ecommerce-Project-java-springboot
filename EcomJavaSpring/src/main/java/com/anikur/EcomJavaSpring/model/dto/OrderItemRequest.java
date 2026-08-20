package com.anikur.EcomJavaSpring.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity

) { }
