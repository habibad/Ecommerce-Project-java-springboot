package com.anikur.EcomJavaSpring.service;

import com.anikur.EcomJavaSpring.model.dto.OrderRequest;
import com.anikur.EcomJavaSpring.model.dto.OrderResponse;
import com.anikur.EcomJavaSpring.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
//    @Autowired
//    private OrderRepo orderRepo;
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        return null;
    }

    public List<OrderResponse> getAllOrder() {
        return null;
    }
}
