package com.example.zvikag.mongodbdemo.controller;

import com.example.zvikag.mongodbdemo.domain.Item;
import com.example.zvikag.mongodbdemo.service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class MongoController {

    private final ItemsService itemsService;

    @GetMapping
    List<Item> getAllItems() {
        return itemsService.findAll();
    }


    @PostMapping
    Item newItem(@RequestBody Item newItem) {
        return itemsService.saveItem(newItem);
    }

    // Single item

    @GetMapping("/{id}")
    Item getOne(@PathVariable String id) {

        return itemsService.findById(id);

    }

    @PutMapping("/{id}")
    Item replaceItem(@RequestBody Item newItem, @PathVariable String id) {

        return itemsService.updateItem(newItem,id);

    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable String id) {
        itemsService.deleteById(id);
    }


}
