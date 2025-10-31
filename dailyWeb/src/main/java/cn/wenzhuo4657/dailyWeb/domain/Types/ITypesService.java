package cn.wenzhuo4657.dailyWeb.domain.Types;

import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.ContentNameDto;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;

import java.util.List;

public interface ITypesService {

    /**
     * 获取所有文档类型
     *
     */
    List<TypeDto> getAllTypes();

    List<ContentNameDto> getContentNameIdById(Integer typeId);
}
