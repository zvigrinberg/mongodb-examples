package com.example.zvikag.mongodbdemo.repository;

import com.example.zvikag.mongodbdemo.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

}
