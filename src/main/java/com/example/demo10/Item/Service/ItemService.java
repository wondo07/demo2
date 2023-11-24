package com.example.demo10.Item.Service;

import com.example.demo10.Exception.BusinessException;
import com.example.demo10.Exception.ErrorCode;
import com.example.demo10.Item.Dto.ItemResponseDto;
import com.example.demo10.Item.Entity.Item;
import com.example.demo10.Item.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;


    public ItemResponseDto get(Long itemId) {
        Item item = verifiedItem(itemId);
        return toResponseDto(item);
    }

    private Item verifiedItem(Long itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        return optionalItem.orElseThrow(
                () -> new BusinessException(ErrorCode.ITEM_NOT_FOUND));
    }



    public ItemResponseDto toResponseDto(Item item){
        return new ItemResponseDto(item);
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }
}
