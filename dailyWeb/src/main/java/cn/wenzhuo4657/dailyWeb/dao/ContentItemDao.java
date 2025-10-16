package cn.wenzhuo4657.dailyWeb.dao;

import cn.wenzhuo4657.dailyWeb.entity.ContentItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContentItemDao {


    List<ContentItem> queryByContentId(@Param("i") int i);


    int insert(ContentItem record);

    void update(ContentItem itemDto);

    int queryByContentIdAndDate(ContentItem contentItem);
}
