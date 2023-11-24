package com.example.demo10.Item.Repository;


import com.example.demo10.Item.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
