package com.example.demo10.Order.Service;

import com.example.demo10.Exception.BusinessException;
import com.example.demo10.Exception.ErrorCode;
import com.example.demo10.Order.Dto.OrderResponseDto;
import com.example.demo10.Order.Entity.Order;
import com.example.demo10.Order.Repository.OrderRepository;

import com.example.demo10.OrderItem.Dto.OrderItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;


    public OrderResponseDto get(Long orderId) {
        Order order = verifiedOrder(orderId);
        return toResponseDto(order);
    }



    private Order verifiedOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElseThrow(
                () -> new BusinessException(ErrorCode.ORDER_NOT_FOUND));
    }



    public OrderResponseDto toResponseDto(Order order){

        OrderResponseDto orderResponseDto = new OrderResponseDto(order);
        List<OrderItemResponseDto> orderItemResponseDtos = order.getOrderItems().stream().map(
                orderItem -> new OrderItemResponseDto(orderItem)).collect(Collectors.toList());
        orderResponseDto.setOrderItemResponseDtos(orderItemResponseDtos);
        return orderResponseDto;
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public List<OrderResponseDto> gets() {

        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(
                order -> new OrderResponseDto(order)).collect(Collectors.toList());
    }
}
