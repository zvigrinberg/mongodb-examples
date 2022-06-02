package com.example.zvikag.mongodbdemo.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class ItemDto {
   private String id;
   private String desc;
   private String theType;
   private Integer itemPrice;
   @JsonAnyGetter
   private List additionalAttributes;
}
