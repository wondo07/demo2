package com.example.demo10.OrderItem.Service;

import com.example.demo10.Exception.BusinessException;
import com.example.demo10.Exception.ErrorCode;
import com.example.demo10.OrderItem.Dto.OrderItemResponseDto;
import com.example.demo10.OrderItem.Entity.OrderItem;
import com.example.demo10.OrderItem.Repository.OrderItemRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;


    public OrderItemResponseDto get(Long orderItemId) {
        OrderItem orderItem = verifiedOrderItemWithQueryDsl(orderItemId);
        return toResponseDto(orderItem);
    }

    private OrderItem verifiedOrderItemWithQueryDsl(Long orderItemId){
        OrderItem orderItem = orderItemRepository.findByIdWithQueryDsl(orderItemId);
        if(orderItem == null){
            throw new BusinessException(ErrorCode.ORDER_ITEM_NOT_FOUND);
        }
        return orderItem;
    }

    private OrderItem verifiedOrderItem(Long orderItemId) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
        return optionalOrderItem.orElseThrow(
                () -> new BusinessException(ErrorCode.ORDER_ITEM_NOT_FOUND));
    }

    public OrderItemResponseDto toResponseDto(OrderItem orderItem){
        OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto(orderItem);

        return orderItemResponseDto;
    }

    public OrderItem save(OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }

}
