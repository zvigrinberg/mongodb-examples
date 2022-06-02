package com.example.zvikag.mongodbdemo.service;

import com.example.zvikag.mongodbdemo.domain.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item saveItem(Item newItem) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public Item updateItem(Item newItem, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
