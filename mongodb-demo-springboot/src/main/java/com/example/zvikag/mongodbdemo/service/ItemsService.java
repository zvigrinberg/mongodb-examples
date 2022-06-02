package com.example.zvikag.mongodbdemo.service;

import com.example.zvikag.mongodbdemo.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemsService {

    List<Item> findAll();
    Item saveItem(Item newItem);
    Item findById(String id);
    Item updateItem(Item newItem, String id);
    void deleteById(String id);
}
