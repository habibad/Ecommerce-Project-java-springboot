package com.anikur.EcomJavaSpring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Order {
    @Id
    private long id;
    @Column(unique = true)
    private String OrderId;
    private String customerName;
    private String email;
    private String status;
    private LocalDate localDate;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;
}
