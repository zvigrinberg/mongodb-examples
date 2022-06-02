package com.example.zvikag.mongodbdemo.dto;

import com.example.zvikag.mongodbdemo.domain.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ItemMapper {
    @Mappings({
       @Mapping(target="id", source="itemSource.itemId"),
       @Mapping(target="desc", source="itemSource.description"),
       @Mapping(target="theType", source="itemSource.type"),
       @Mapping(target="itemPrice", source="itemSource.price"),
       @Mapping(target="additionalAttributes", source="itemSource.properties")
    })
    ItemDto sourceToDestination(Item itemSource);

    @Mappings({
       @Mapping(source="itemDest.id", target="itemId"),
       @Mapping(source="itemDest.desc", target="description"),
       @Mapping(source="itemDest.theType", target="type"),
       @Mapping(source="itemDest.itemPrice", target="price"),
       @Mapping(source="itemDest.additionalAttributes", target="properties")
    })
    Item destinationToSource(ItemDto itemDest);

}
