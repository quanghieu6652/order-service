package com.example.order_service.kafka;

import com.example.order_service.entity.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
     System.out.println("LOGGG Gửi order tới Kafka: " + order);  // log này để kiểm tra

        kafkaTemplate.send("orders", order);
    }
}
