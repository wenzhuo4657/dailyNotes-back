package cn.wenzhuo4657.dailyWeb.controller.mdEdit.utils;

import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.entity.ContentItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FuntionUtils {


    public static List<ItemDto>  toItemDto(List<ContentItem > contentItems){
        List<ItemDto> itemDtos = new ArrayList<>();
        for (ContentItem contentItem : contentItems){
            ItemDto itemDto = new ItemDto();
            itemDto.setId(contentItem.getId());
//            todo 这里应该根据文档类型决定title的解析方式，但目前这样就足够
            itemDto.setTitle(contentItem.getData().toString());
            itemDto.setContent(contentItem.getContent());
            itemDtos.add(itemDto);
        }

        return itemDtos;
    }
}
