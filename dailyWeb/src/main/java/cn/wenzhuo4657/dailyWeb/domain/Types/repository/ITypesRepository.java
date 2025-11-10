package cn.wenzhuo4657.dailyWeb.domain.Types.repository;

import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.Docs;

import java.util.List;

public interface ITypesRepository {

    List<TypeDto> getAll();


    List<TypeDto> getAllByUserId(Integer userId);

    List<Docs> getDocsIdByTypeId(Integer userId, Integer typeId);
}
