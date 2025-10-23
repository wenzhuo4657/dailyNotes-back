package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;

import cn.wenzhuo4657.dailyWeb.domain.Types.repository.ITypesRepository;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.ContentTypeDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class TypesRepository implements ITypesRepository {


    @Autowired
    private ContentTypeDao contentTypeDao;

    @Override
    public List<TypeDto> getAll(){
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
