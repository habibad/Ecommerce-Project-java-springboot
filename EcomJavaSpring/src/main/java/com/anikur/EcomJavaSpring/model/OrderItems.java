package com.anikur.EcomJavaSpring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderItems {
    @Id
    private int ProductId;
    @ManyToOne
    private Product product;
    private int quantitjy;
    private BigDecimal totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

}
