package com.example.zvikag.mongodbdemo.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document("items")
public class Item {

    private String itemId;
    private String description;
    private String type;
    private Integer price;
    @JsonAnySetter
    private List properties;


}
