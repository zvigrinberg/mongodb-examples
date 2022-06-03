package com.example.zvikag.mongodbdemo.controller;

import com.example.zvikag.mongodbdemo.domain.Item;
import com.example.zvikag.mongodbdemo.dto.ItemDto;
import com.example.zvikag.mongodbdemo.service.ItemsService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class MongoController {

    private final ItemsService itemsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ItemDto> getAllItems() {
        return itemsService.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void newItem(@RequestBody ItemDto newItem) {

        itemsService.saveItem(newItem);
    }

    // Single item

    @SneakyThrows
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ItemDto getOne(@PathVariable String id) {

        return itemsService.findById(id);

    }

    @SneakyThrows
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void replaceItem(@RequestBody ItemDto newItem, @PathVariable String id) {

        itemsService.updateItem(newItem,id);

    }

    @SneakyThrows
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEmployee(@PathVariable String id) {
        itemsService.deleteById(id);
    }


}
