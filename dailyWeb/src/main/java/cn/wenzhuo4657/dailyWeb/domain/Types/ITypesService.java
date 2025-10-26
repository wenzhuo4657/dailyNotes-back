package cn.wenzhuo4657.dailyWeb.domain.Types;

import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;

import java.util.List;

public interface ITypesService {

    /**
     * 获取所有文档类型
     * todo 这里需要调整为动态路由，根据用户身份来做权限控制
     */
    List<TypeDto> getAllTypes(Integer userId);
}
