package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateItemDto;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.DocsItem;

import java.util.List;

public interface IItemEditRepository {


    List<ItemDto> getMd(Integer content_name_Id, Integer type);



    boolean updateMd(UpdateItemDto itemDto, Integer type);



    void addItem(Integer content_name_Id, Integer type);


    DocsItem selectDocsItem(Long id);

    void updateField(Integer id, String field);


    boolean queryContentName(Integer content_name_Id,Integer type,Integer userid);


    int queryContentType(Integer id);
}
