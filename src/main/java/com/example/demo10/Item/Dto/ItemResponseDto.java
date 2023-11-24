package com.example.demo10.Item.Dto;


import com.example.demo10.Item.Entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemResponseDto {

    private String itemName;

    private int itemPrice;


    public ItemResponseDto(Item item) {
        this.itemName = item.getItemName();
        this.itemPrice = item.getItemPrice();
    }
}
