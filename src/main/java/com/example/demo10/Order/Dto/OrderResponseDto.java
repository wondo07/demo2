package com.example.demo5.Order.Dto;

import com.example.demo5.Order.Entity.Order;
import com.example.demo5.OrderItem.Dto.OrderItemResponseDto;
import com.example.demo5.OrderItem.Entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponseDto {

    private Long orderId;

    private LocalDateTime orderDate;

    private List<OrderItemResponseDto> orderItemResponseDtos;

    public OrderResponseDto(Order order) {
        this.orderId = order.getOrderId();
        this.orderDate = order.getOrderDate();
        this.orderItemResponseDtos = order.getOrderItems().stream()
                .map(orderItem -> new OrderItemResponseDto(orderItem)).collect(Collectors.toList());
    }
}
