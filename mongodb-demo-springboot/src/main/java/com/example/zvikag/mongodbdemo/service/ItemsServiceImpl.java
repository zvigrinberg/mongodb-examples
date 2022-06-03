package com.example.zvikag.mongodbdemo.service;

import com.example.zvikag.mongodbdemo.domain.Item;
import com.example.zvikag.mongodbdemo.dto.ItemDto;
import com.example.zvikag.mongodbdemo.dto.ItemMapper;
import com.example.zvikag.mongodbdemo.exception.ItemNotFoundException;
import com.example.zvikag.mongodbdemo.exception.NotFoundForDeleteException;
import com.example.zvikag.mongodbdemo.exception.NotFoundForUpdateException;
import com.example.zvikag.mongodbdemo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemsServiceImpl implements ItemsService {

    private final ItemRepository itemRepository;
    ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    @Override
    public List<ItemDto> findAll() {
        List<Item> all = itemRepository.findAll();
        List<ItemDto> transformedList = new ArrayList<>();
        all.forEach(item -> { transformedList.add(itemMapper.sourceToDestination(item));
        });
        return transformedList;
    }

    @Override
    public void saveItem(ItemDto newItem) {

        Item item = itemMapper.destinationToSource(newItem);
        itemRepository.save(item);

    }

    @Override
    public ItemDto findById(String id) throws Throwable {
        Optional<Item> byId = itemRepository.findById(id);
        Item item = byId.orElseThrow((Supplier<Throwable>) () -> {
            String message = "item=" + id + " not found";
            log.error(message);
            return new ItemNotFoundException(message);
        });
        return itemMapper.sourceToDestination(item);

    }

    @Override
    public void updateItem(ItemDto newItem, String id) throws Throwable {
        Optional<Item> byId = itemRepository.findById(id);
        byId.orElseThrow((Supplier<Throwable>) () -> {
            String message = "Update Failed for non exists item id=" + id;
            log.error(message);
            return new NotFoundForUpdateException(message);
        });
        Item newItemDB = itemMapper.destinationToSource(newItem);
        itemRepository.save(newItemDB);

    }

    @Override
    public void deleteById(String id) throws Throwable {
        Optional<Item> byId = itemRepository.findById(id);
        byId.orElseThrow((Supplier<Throwable>) () -> {
            String message = "Delete Failed for non exists item id=" + id;
            log.error(message);
            return new NotFoundForDeleteException(message);});
        itemRepository.deleteById(id);
    }
}
