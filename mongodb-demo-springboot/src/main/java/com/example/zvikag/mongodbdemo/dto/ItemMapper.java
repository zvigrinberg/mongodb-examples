package com.example.zvikag.mongodbdemo.dto;

import com.example.zvikag.mongodbdemo.domain.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel =  "spring")
public interface ItemMapper {
    @Mappings({
       @Mapping(target="id", source="item.itemId"),
       @Mapping(target="desc", source="item.description"),
       @Mapping(target="theType", source="item.type"),
       @Mapping(target="itemPrice", source="item.price"),
       @Mapping(target="additionalAttributes", source="item.properties")
    })
    ItemDto sourceToDestination(Item item);

    @Mappings({
       @Mapping(source="itemDest.id", target="itemId"),
       @Mapping(source="itemDest.desc", target="description"),
       @Mapping(source="itemDest.theType", target="type"),
       @Mapping(source="itemDest.itemPrice", target="price"),
       @Mapping(source="itemDest.additionalAttributes", target="properties")
    })
    Item destinationToSource(ItemDto itemDest);

}
