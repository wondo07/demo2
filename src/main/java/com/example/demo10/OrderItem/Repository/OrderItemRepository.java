package com.example.demo10.OrderItem.Repository;


import com.example.demo10.OrderItem.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
