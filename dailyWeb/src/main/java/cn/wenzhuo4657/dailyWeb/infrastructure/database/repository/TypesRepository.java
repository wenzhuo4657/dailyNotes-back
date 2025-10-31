package cn.wenzhuo4657.dailyWeb.infrastructure.database.repository;

import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.domain.Types.repository.ITypesRepository;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.ContentTypeDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.dao.UserContentnameDao;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentName;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentType;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TypesRepository implements ITypesRepository {

    private final static Logger log= org.slf4j.LoggerFactory.getLogger(TypesRepository.class);


    @Autowired
    private ContentTypeDao contentTypeDao;
    @Autowired
    private UserContentnameDao userContentnameDao;

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

    @Override
    public List<TypeDto> getAllByUserId(Integer userId) {
        log.warn("暂时没有处理动态路由----");
//        todo 这里需要调整为动态路由，根据用户身份来做权限控制
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

    @Override
    public List<ContentName> getContentNameIdById(Integer loginId, Integer typeId) {
        List<ContentName> list = userContentnameDao.queryByloginIdAndtypeId(loginId, typeId);
        return list;
    }
}
