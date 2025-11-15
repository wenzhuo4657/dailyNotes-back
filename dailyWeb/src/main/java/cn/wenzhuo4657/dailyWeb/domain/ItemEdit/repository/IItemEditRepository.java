package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateItemDto;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.DocsItem;

import java.util.List;


public interface IItemEditRepository {


    List<DocsItem> getDocsItems(Long docs_Id);



    boolean updateItem(UpdateItemDto itemDto, Integer type, Long userId);




    boolean addItem(Long docs_Id, Integer type, Long userId);


    DocsItem selectDocsItem(Long id);

    void updateField(Long id, String field);





}
