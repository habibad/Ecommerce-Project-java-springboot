package com.anikur.EcomJavaSpring.controller;

import com.anikur.EcomJavaSpring.model.dto.OrderRequest;
import com.anikur.EcomJavaSpring.model.dto.OrderResponse;
import com.anikur.EcomJavaSpring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderplace = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderplace, HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderResponse>> getAllOrder(){
        List <OrderResponse> orderplace = orderService.getAllOrder();
        return new ResponseEntity<>(orderplace, HttpStatus.OK);
    }

}
