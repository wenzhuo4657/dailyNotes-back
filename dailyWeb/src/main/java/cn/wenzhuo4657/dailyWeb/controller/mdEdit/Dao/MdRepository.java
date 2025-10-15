package cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dao;


import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.InsertItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.UpdateItemDto;
import cn.wenzhuo4657.dailyWeb.dao.ContentItemDao;
import cn.wenzhuo4657.dailyWeb.entity.ContentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class MdRepository {

    @Autowired
    private ContentItemDao contentItemDao;



    private  static  final  contentItemType.ItemType BASIC_CONTENT = contentItemType.ItemType.BASIC_CONTENT;
    private  static final int BASIC_CONTENT_ID = BASIC_CONTENT.id;


    public List<ItemDto> getMd() throws ClassNotFoundException {
        List<ContentItem> contentItems = contentItemDao.queryByContentId(BASIC_CONTENT_ID);

        List<ItemDto> itemDtos= new ArrayList<>();
        for (
                ContentItem contentItem : contentItems
        ){
            ItemDto itemDto = new ItemDto();
            itemDto.setId(contentItem.getId());
            itemDto.setContent(contentItem.getContent());
            itemDto.setTitle(contentItemType.toTitle(BASIC_CONTENT,contentItem));
            itemDtos.add(itemDto);
        }

        return itemDtos;
    }


    public boolean updateMd(UpdateItemDto itemDto){
        ContentItem contentItem = new ContentItem();
        contentItem.setId(itemDto.getId());
        contentItem.setContent(itemDto.getContent());
        contentItem.setContent_name_Id(BASIC_CONTENT_ID);
        contentItemDao.update(contentItem);
        return true;
    }


    public void addItem(InsertItemDto params) throws ClassNotFoundException {


        ContentItem contentItem = new ContentItem();
        contentItem.setContent_name_Id(BASIC_CONTENT_ID);
        contentItem.setField(contentItemType.toFiled(BASIC_CONTENT));
        contentItem.setContent(params.getContent());
        contentItem.setDate(new Date(System.currentTimeMillis()).toString());

        if (contentItemDao.queryByContentIdAndDate(contentItem)==0){
            contentItemDao.insert(contentItem);
        }


    }



    public  static  class   contentItemType{

//        根据ItemType生成对应的Filed属性

        public enum ItemType{
            BASIC_CONTENT(0,"basic_content");

            ItemType(int id,String des){
                this.id = id;
                this.des = des;
            }

            Integer id;
            String des;


            public static ItemType toItemType(int id) throws ClassNotFoundException {
                for (ItemType itemType : ItemType.values()){
                    if (itemType.id.equals(id)){
                        return itemType;
                    }
                }
                throw  new ClassNotFoundException("不支持的ItemType");
            }
        }

        public static String toFiled(ItemType itemType) throws ClassNotFoundException {

            if (itemType.id.equals(ItemType.BASIC_CONTENT.id)){
                return  "";
            }
            throw  new ClassNotFoundException("不支持的ItemType");
        }

        public static String toTitle(ItemType itemType, ContentItem field) throws ClassNotFoundException {
            if (itemType.id.equals(ItemType.BASIC_CONTENT.id)){
                return  field.getDate().toString();
            }
            throw  new ClassNotFoundException("不支持的ItemType");
        }
    }
}
