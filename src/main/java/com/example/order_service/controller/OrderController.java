package com.example.order_service.controller;

import com.example.order_service.entity.Order;
import com.example.order_service.kafka.OrderProducer;
import com.example.order_service.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderProducer orderProducer;

    public OrderController(OrderService orderService, OrderProducer orderProducer) {
        this.orderService = orderService;
        this.orderProducer = orderProducer;

    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @PostMapping
    public ResponseEntity<Map<String, String>> createOrder(@RequestBody Order order) {
        
        orderProducer.sendOrder(order);
        Map<String, String> response = new HashMap<>();
             System.out.println("LOGGG Đơn hàng đã được gửi tới Kafka: " + order);  // log này để kiểm tra

        response.put("message", "Đơn hàng đã được gửi tới Kafka để xử lý");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
