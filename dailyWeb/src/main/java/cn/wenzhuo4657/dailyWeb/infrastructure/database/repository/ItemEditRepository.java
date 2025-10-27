package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.function.typeDaily.FiledFunction;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.vo.contentItemType;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository.IItemEditRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.ContentItemDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.UserContentnameDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.dao.ContentNameDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentItem;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentName;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



@Repository
public class ItemEditRepository implements IItemEditRepository {


    private final static Logger log= org.slf4j.LoggerFactory.getLogger(ItemEditRepository.class);

    @Autowired
    protected ContentItemDao contentItemDao;

    @Autowired
    protected UserContentnameDao userContentnameDao;
    @Autowired
    private ContentNameDao contentNameDao;


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
    public void addItem(Integer content_name_Id,Integer type)  {
        try {
            contentItemType.ItemType itemType = contentItemType.ItemType.toItemType(type);
            ContentItem contentItem = new ContentItem();
            contentItem.setContent_name_Id(content_name_Id);
            contentItem.setField(FiledFunction.toFiled,itemType);
            contentItem.setContent("");
            contentItem.setDate(new Date(System.currentTimeMillis()).toString());

            if (itemType.equals(contentItemType.ItemType.BASIC_CONTENT) &&contentItemDao.queryByContentIdAndDate(contentItem)!=0){
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

    @Override
    public boolean queryContentName(Integer content_name_Id, Integer type, Integer userid) {
//        todo 修改表中的联合主键和约束
        int query = userContentnameDao.query(content_name_Id, type, userid);
        if (query ==0){
            return false;
        }
        return true;
    }

    @Override
    public int queryContentType(Integer id) {
        ContentName contentname = contentNameDao.queryById(id);
        if (contentname == null){
            throw new RuntimeException("内容不存在");
        }

        return contentname.getType();


    }
}
