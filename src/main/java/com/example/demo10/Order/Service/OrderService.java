package com.example.demo5.Order.Service;

import com.example.demo5.Exception.BusinessException;
import com.example.demo5.Exception.ErrorCode;
import com.example.demo5.Order.Dto.OrderResponseDto;
import com.example.demo5.Order.Entity.Order;

import com.example.demo5.Order.Repository.OrderRepository;
import com.example.demo5.OrderItem.Dto.OrderItemResponseDto;
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
        Order order = verifiedOrderWithQueryDsl(orderId);
        return toResponseDto(order);
    }

    public OrderResponseDto get1(Long orderId) {
        Order order = verifiedOrderWithQueryDsl1(orderId);
        return toResponseDto(order);
    }

    private Order verifiedOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElseThrow(
                () -> new BusinessException(ErrorCode.ORDER_NOT_FOUND));
    }

    public Order verifiedOrderWithQueryDsl(Long orderId){
        Order order = orderRepository.findByIdWithQueryDsl(orderId);
        if(order == null){
            throw new BusinessException(ErrorCode.ORDER_NOT_FOUND);
        }
        return order;
    }

    public Order verifiedOrderWithQueryDsl1(Long orderId){
        Order order = orderRepository.findByIdWithQueryDsl1(orderId);
        if(order == null){
            throw new BusinessException(ErrorCode.ORDER_NOT_FOUND);
        }
        return order;
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

        List<Order> orders = orderRepository.findAll1();

        return orders.stream().map(
                order -> new OrderResponseDto(order)).collect(Collectors.toList());
    }
}
