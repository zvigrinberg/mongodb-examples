package com.example.zvikag.mongodbdemo.service;

import com.example.zvikag.mongodbdemo.domain.Item;
import com.example.zvikag.mongodbdemo.dto.ItemDto;

import java.util.List;
import java.util.Optional;

public interface ItemsService {

    List<ItemDto> findAll();
    void saveItem(ItemDto newItem);
    ItemDto findById(String id) throws Throwable;
    void updateItem(ItemDto newItem, String id) throws Throwable;
    void deleteById(String id) throws Throwable;
}
