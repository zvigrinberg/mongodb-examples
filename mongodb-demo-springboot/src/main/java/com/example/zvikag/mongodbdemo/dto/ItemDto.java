package com.example.zvikag.mongodbdemo.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ItemDto {
   private String id;
   private String desc;
   private String theType;
   private Integer itemPrice;
   @JsonAnySetter
   private Map<String,Object> additionalAttributes;
}
