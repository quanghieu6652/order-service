// package com.example.order_service.consumer;

// import com.example.order_service.entity.Order;
// import com.example.order_service.service.OrderService;
// import org.springframework.kafka.annotation.KafkaListener;
// import org.springframework.stereotype.Component;

// @Component
// public class OrderConsumer {

//     private final OrderService orderService;

//     public OrderConsumer(OrderService orderService) {
//         this.orderService = orderService;
//     }

//     @KafkaListener(topics = "orders", groupId = "order-group", containerFactory = "kafkaListenerContainerFactory")
//     public void consume(Order order) {
//         System.out.println("LOGGG Nhận đơn hàng từ Kafka: " + order);
//         orderService.createOrder(order); // Ghi vào DB
//         System.out.println("LOGGG Đã lưu order thành công");

//     }
// }
