package cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dao;


import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.dao.ContentItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MdRepository {

    @Autowired
    private ContentItemDao contentItemDao;

    public List<ItemDto> getMd(){
        contentItemDao.queryByContentId(0);
    }



}
