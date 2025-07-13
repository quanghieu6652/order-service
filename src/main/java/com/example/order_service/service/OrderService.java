package com.example.order_service.service;

import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Cacheable(value = "orders")
    public List<Order> getAllOrders() {
        System.out.println("LOGGG Truy vấn DB để lấy danh sách đơn hàng");

        return orderRepository.findAll();
    }

        public Order createOrder(Order order) {
            System.out.println("LOGGG Bắt đầu lưu order: " + order);
            Order savedOrder = orderRepository.save(order);
            System.out.println("LOGGG Lưu order thành công: " + savedOrder);
            return savedOrder;
        }

    @CacheEvict(value = "orders", allEntries = true)
    public Order updateOrder(Long id, Order updatedOrder) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setProductName(updatedOrder.getProductName());
        order.setQuantity(updatedOrder.getQuantity());
        order.setPrice(updatedOrder.getPrice());
        return orderRepository.save(order);
    }
    @CacheEvict(value = "orders", allEntries = true)
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
