package cn.wenzhuo4657.dailyWeb.dao;

import cn.wenzhuo4657.dailyWeb.entity.ContentType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentTypeDao {
    List<ContentType> getAll();
}
