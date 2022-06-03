package com.example.zvikag.mongodbdemo.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Document("items")
public class Item {
    @Id
    private String itemId;
    private String description;
    private String type;
    private Integer price;
    @JsonAnySetter
    private Map<String,Object> properties;


}
