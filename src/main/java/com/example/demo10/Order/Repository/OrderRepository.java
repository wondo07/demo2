package com.example.demo5.Order.Repository;

import com.example.demo5.Order.Entity.Order;
import com.example.demo5.Order.Repository.queryDsl.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {
}
