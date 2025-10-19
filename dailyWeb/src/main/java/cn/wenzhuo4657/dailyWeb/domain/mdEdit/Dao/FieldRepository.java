package cn.wenzhuo4657.dailyWeb.domain.mdEdit.Dao;

import cn.wenzhuo4657.dailyWeb.dao.ContentItemDao;
import cn.wenzhuo4657.dailyWeb.entity.ContentItem;
import org.springframework.beans.factory.annotation.Autowired;

public class FieldRepository {

    @Autowired
    protected ContentItemDao contentItemDao;


    public void updateField(Integer id, String field) {
        ContentItem item = new ContentItem();
        item.setId(id);
        item.setField(field);
        contentItemDao.updateField(item);
    }




}
