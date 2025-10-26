package cn.wenzhuo4657.dailyWeb.infrastructure.database.dao;

import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentTypeDao {
    List<ContentType> getAll();


}
