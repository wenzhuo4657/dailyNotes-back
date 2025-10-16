package cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dao;


import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.InsertItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.UpdateItemDto;
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
    private  static final int BASIC_CONTENT_ID = BASIC_CONTENT.id;


    public List<ItemDto> getMd() throws ClassNotFoundException {
        return getMd(BASIC_CONTENT_ID);
    }

    public List<ItemDto> getMd(Integer content_name_Id)  {

        try {
            contentItemType.ItemType itemType = contentItemType.ItemType.toItemType(content_name_Id);
            List<ContentItem> contentItems = contentItemDao.queryByContentId(itemType.id);

            List<ItemDto> itemDtos= new ArrayList<>();
            for (
                    ContentItem contentItem : contentItems
            ){
                ItemDto itemDto = new ItemDto();
                itemDto.setId(contentItem.getId());
                itemDto.setContent(contentItem.getContent());
                itemDto.setTitle(contentItemType.toTitle(itemType,contentItem));
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
            contentItem.setContent_name_Id(itemType.id);
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
            contentItem.setContent_name_Id(itemType.id);
            contentItem.setField(contentItemType.toFiled(itemType));
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



    public  static  class   contentItemType{

//        根据ItemType生成对应的Filed属性

        public enum ItemType{
            BASIC_CONTENT(0,"basic_content"),
            CHECK_LIST(1,"check_list");

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
            if (itemType.id.equals(ItemType.CHECK_LIST.id)){
//              TODO  设置属性分割+属性解析菜单类，目前仅支持status属性进行应编码解析
//                属性分割：     ' '用于第一次分割，获取属性和值的字符串，':'表示第二次分割，获取属性和值。
//                举例：  status:yes syntax:markdown   ,每次解析前必须去除前后空格，避免空
//                属性解析，使用菜单类，或者reacd记录类，避免硬编码丢失
                return  "status:";
            }
            throw  new ClassNotFoundException("不支持的ItemType");
        }

        public static String toTitle(ItemType itemType, ContentItem field) throws ClassNotFoundException {
            if (itemType.id.equals(ItemType.BASIC_CONTENT.id)){
                return  field.getDate().toString();
            }
            if (itemType.id.equals(ItemType.CHECK_LIST.id)){
                return  field.getField();//这里实际上是将title作为前端的内容信息，此处备忘录为是否完成
            }
            throw  new ClassNotFoundException("不支持的ItemType");
        }
    }
}
