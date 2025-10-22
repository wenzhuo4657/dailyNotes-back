package cn.wenzhuo4657.dailyWeb.domain.Types.Dao;


import cn.wenzhuo4657.dailyWeb.dao.ContentTypeDao;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.entity.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class BaseRepositoryByTypes {

    @Autowired
    private ContentTypeDao contentTypeDao;

    public List<TypeDto>  getAll(){
        List<ContentType> all = contentTypeDao.getAll();
        List<TypeDto> typeDtos = new ArrayList<>();
        for (ContentType contentType : all){
            TypeDto typeDto = new TypeDto();
            typeDto.setId(contentType.getId());
            typeDto.setName(contentType.getName());
            typeDtos.add(typeDto);
        }
        return typeDtos;
    }



}
