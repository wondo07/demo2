package com.example.demo10.OrderItem.Controller;

import com.example.demo10.OrderItem.Dto.OrderItemResponseDto;
import com.example.demo10.OrderItem.Service.OrderItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping("/{orderItemId}")
    private ResponseEntity get(@PathVariable Long orderItemId){
        OrderItemResponseDto orderItemResponseDto = orderItemService.get(orderItemId);
        return new ResponseEntity<>(orderItemResponseDto, HttpStatus.OK);
    }
}
