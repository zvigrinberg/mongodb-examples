package com.example.zvikag.mongodbdemo.repository;

import com.example.zvikag.mongodbdemo.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {

}
