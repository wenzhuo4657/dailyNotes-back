package cn.wenzhuo4657.dailyWeb.dao;

import cn.wenzhuo4657.dailyWeb.entity.ContentItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContentItemDao {


    ContentItem queryByContentId(@Param("i") int i);
}
