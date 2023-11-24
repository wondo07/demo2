package com.example.demo10.Item.Controller;

import com.example.demo10.Item.Dto.ItemResponseDto;
import com.example.demo10.Item.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{itemId}")
    private ResponseEntity get(@PathVariable Long itemId){
       ItemResponseDto itemResponseDto = itemService.get(itemId);
       return new ResponseEntity<>(itemResponseDto, HttpStatus.OK);
    }
}
