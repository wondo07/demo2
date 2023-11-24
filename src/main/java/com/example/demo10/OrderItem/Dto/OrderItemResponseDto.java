package com.example.demo10.OrderItem.Dto;


import com.example.demo10.OrderItem.Entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemResponseDto {

    private Long orderItemId;

    private int orderPrice;

    private int count;

    private String itemName;

    private int itemPrice;

    public OrderItemResponseDto(OrderItem orderItem) {
        this.orderItemId = orderItem.getOrderItemId();
        this.orderPrice = orderItem.getOrderPrice();
        this.count = orderItem.getCount();
        this.itemName = orderItem.getItem().getItemName();
        this.itemPrice = orderItem.getItem().getItemPrice();
    }
}
