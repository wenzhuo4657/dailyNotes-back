package cn.wenzhuo4657.dailyWeb.domain.Types.repository;

import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.ContentName;

import java.util.List;

public interface ITypesRepository {

    List<TypeDto> getAll();


    List<TypeDto> getAllByUserId(Integer userId);

    List<ContentName> getContentNameIdById(Integer loginId, Integer typeId);
}
