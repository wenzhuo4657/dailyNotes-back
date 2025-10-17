package cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dao;


import cn.wenzhuo4657.dailyWeb.controller.mdEdit.function.typeDaily.FiledFunction;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.Dto.InsertItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.Dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.Dto.UpdateItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.vo.contentItemType;
import cn.wenzhuo4657.dailyWeb.dao.ContentItemDao;
import cn.wenzhuo4657.dailyWeb.entity.ContentItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DailyRepository {

    @Autowired
    private ContentItemDao contentItemDao;



    private  static  final  contentItemType.ItemType BASIC_CONTENT = contentItemType.ItemType.BASIC_CONTENT;
    private  static final int BASIC_CONTENT_ID = BASIC_CONTENT.getId();


    public List<ItemDto> getMd() throws ClassNotFoundException {
        return getMd(BASIC_CONTENT_ID);
    }

    public List<ItemDto> getMd(Integer content_name_Id)  {

        try {
            contentItemType.ItemType itemType = contentItemType.ItemType.toItemType(content_name_Id);
            List<ContentItem> contentItems = contentItemDao.queryByContentId(itemType.getId());

            List<ItemDto> itemDtos= new ArrayList<>();
            for (
                    ContentItem contentItem : contentItems
            ){
                ItemDto itemDto = new ItemDto();
                itemDto.setId(contentItem.getId());
                itemDto.setContent(contentItem.getContent());
                itemDto.setTitle(FiledFunction.toTitle.apply(itemType,contentItem));
                itemDtos.add(itemDto);
            }
            return itemDtos;
        }catch (ClassNotFoundException e){
            log.error("不支持的ItemType");
            return null;
        }



    }


    public boolean updateMd(UpdateItemDto itemDto){
        return  updateMd(itemDto,BASIC_CONTENT_ID);
    }
    public boolean updateMd(UpdateItemDto itemDto,Integer content_name_Id){

        try {
            contentItemType.ItemType itemType = contentItemType.ItemType.toItemType(content_name_Id);
            ContentItem contentItem = new ContentItem();
            contentItem.setId(itemDto.getId());
            contentItem.setContent(itemDto.getContent());
            contentItem.setContent_name_Id(itemType.getId());
            contentItemDao.update(contentItem);
        }catch (ClassNotFoundException e){
            log.error("不支持的ItemType");
            return false;
        }

        return true;
    }

    public void addItem()  {
        InsertItemDto params = new InsertItemDto();
        params.setContent_name_Id(BASIC_CONTENT_ID);

        addItem( params);

    }

    public void addItem(InsertItemDto params)  {


        try {
            contentItemType.ItemType itemType = contentItemType.ItemType.toItemType(params.getContent_name_Id());
            ContentItem contentItem = new ContentItem();
            contentItem.setContent_name_Id(itemType.getId());
            contentItem.setField(FiledFunction.toFiled,itemType);
            contentItem.setContent("");
            contentItem.setDate(new Date(System.currentTimeMillis()).toString());

            if (itemType==BASIC_CONTENT&&contentItemDao.queryByContentIdAndDate(contentItem)!=0){
                throw new Exception("已经存在");
            }

            contentItemDao.insert(contentItem);
        }catch (ClassNotFoundException e){
            log.error("不支持的ItemType");

        }catch (Exception e){
            log.error("添加失败");
        }

    }




}
