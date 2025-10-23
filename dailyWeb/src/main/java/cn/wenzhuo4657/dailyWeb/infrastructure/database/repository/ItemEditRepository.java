package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.function.typeDaily.FiledFunction;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.contentItemType;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository.IItemEditRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.ContentItemDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Repository
public class ItemEditRepository implements IItemEditRepository {
    private  static  final  contentItemType.ItemType BASIC_CONTENT = contentItemType.ItemType.BASIC_CONTENT;
    private  static final int BASIC_CONTENT_TYPE_ID = BASIC_CONTENT.getId();
    private static final int BASE_CONTENT_NAME_ID = 0;


    @Autowired
    protected ContentItemDao contentItemDao;

    @Override
    public List<ItemDto> getMd(){
        return getMd(BASE_CONTENT_NAME_ID,BASIC_CONTENT_TYPE_ID);
    }


    @Override
    public List<ItemDto> getMd(Integer content_name_Id, Integer type)  {

        try {

            contentItemType.ItemType itemType = contentItemType.ItemType.toItemType(type);

            List<ContentItem> contentItems = contentItemDao.queryByContentId(content_name_Id);

            List<ItemDto> itemDtos= new ArrayList<>();
            for (
                    ContentItem contentItem : contentItems
            ){
                ItemDto itemDto = new ItemDto();
                itemDto.setId(contentItem.getId());
                itemDto.setContent(contentItem.getContent());
                itemDto.setTitle(FiledFunction.toTitle.apply(itemType,contentItem));
                itemDto.setExpand(FiledFunction.toExpand.apply(itemType,contentItem));
                itemDtos.add(itemDto);
            }
            return itemDtos;
        }catch (ClassNotFoundException e){
            log.error("不支持的ItemType");
            return null;
        }



    }


    @Override
    public boolean updateMd(UpdateItemDto itemDto){
        return  updateMd(itemDto,BASIC_CONTENT_TYPE_ID);
    }

    @Override
    public boolean updateMd(UpdateItemDto itemDto,Integer type){

        try {
            contentItemType.ItemType itemType = contentItemType.ItemType.toItemType(type);
            ContentItem contentItem = new ContentItem();
            contentItem.setId(itemDto.getId());
            contentItem.setContent(itemDto.getContent());
            contentItem.setContent_name_Id(itemType.getId());
            contentItemDao.updateContent(contentItem);
        }catch (ClassNotFoundException e){
            log.error("不支持的ItemType");
            return false;
        }

        return true;
    }

    @Override
    public void addItem()  {

        addItem(BASE_CONTENT_NAME_ID,BASIC_CONTENT_TYPE_ID);

    }

    @Override
    public void addItem(Integer content_name_Id,Integer type)  {
        try {
            contentItemType.ItemType itemType = contentItemType.ItemType.toItemType(type);
            ContentItem contentItem = new ContentItem();
            contentItem.setContent_name_Id(content_name_Id);
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


    @Override
    public ContentItem selectContentItem(Integer id){
        return contentItemDao.selectContentItem(id);
    }



    @Override
    public void updateField(Integer id, String field) {
        ContentItem item = new ContentItem();
        item.setId(id);
        item.setField(field);
        contentItemDao.updateField(item);
    }

}
