package cn.wenzhuo4657.dailyWeb.domain.ItemEdit;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.InsertItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.QueryItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateItemDto;

import java.util.List;

/**
 * 文档默认行为定义
 */
public interface IItemEditService {

    /**
     * 增加item
     */
    boolean insertItem(InsertItemDto dto);


    /**
     * 修改item
     */
    boolean updateItem(UpdateItemDto dto);

    /**
     * 获取item
     */
    List<ItemDto> getItem(QueryItemDto dto);
}
