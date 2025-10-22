package cn.wenzhuo4657.dailyWeb.domain.Types;


import cn.wenzhuo4657.dailyWeb.domain.Types.Dao.BaseRepositoryByTypes;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "types")
@ResponseBody // 直接将响应值作为 HTTP 响应体正文，默认会走视图解析
@RequestMapping(value = "/types")
public class BaseController {

    @Autowired
    private BaseRepositoryByTypes baseRepository;

    /**
     * 获取所有类型
     */
    @RequestMapping(value = "/getAllTypes")
    public List<TypeDto> getAllTypes(){
       return baseRepository.getAll();
    }
}
