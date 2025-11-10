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

    /**
     * 根据类型id获取相应用户的文档id
     * @return
     */
    List<ContentNameDto> getContentNameIdById(Integer typeId);
}
