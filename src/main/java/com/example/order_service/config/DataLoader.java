// package com.example.order_service.config;

// import com.example.order_service.entity.Order;
// import com.example.order_service.repository.OrderRepository;
// import jakarta.annotation.PostConstruct;
// import org.springframework.stereotype.Component;

// @Component
// public class DataLoader {

//     private final OrderRepository orderRepository;

//     public DataLoader(OrderRepository orderRepository) {
//         this.orderRepository = orderRepository;
//     }

//     @PostConstruct
//     public void loadData() {
//         // Tạo một vài đơn hàng mẫu
//         Order order1 = new Order();
//         order1.setProductName("Sản phẩm A");
//         order1.setQuantity(2);
//         order1.setPrice(150.0);

//         Order order2 = new Order();
//         order2.setProductName("Sản phẩm B");
//         order2.setQuantity(1);
//         order2.setPrice(300.0);

//         Order order3 = new Order();
//         order3.setProductName("Sản phẩm C");
//         order3.setQuantity(5);
//         order3.setPrice(50.0);

//         // Lưu vào database
//         orderRepository.save(order1);
//         orderRepository.save(order2);
//         orderRepository.save(order3);

//         System.out.println("Đã thêm dữ liệu mẫu Order vào database.");
//     }
// }
