package cn.wenzhuo4657.dailyWeb.tigger.http;


import cn.dev33.satoken.stp.StpUtil;
import cn.wenzhuo4657.dailyWeb.domain.Types.ITypesService;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.ContentNameDto;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "types")
@ResponseBody // 直接将响应值作为 HTTP 响应体正文，默认会走视图解析
@RequestMapping(value = "/types")
public class TypeController {

    @Autowired
    private ITypesService typesService;


    @RequestMapping(value = "/getAllTypes")
    public List<TypeDto> getAllTypes() {
        return typesService.getAllTypes();
    }


    @RequestMapping(value = "/getContentIdsByTypes")
    public List<ContentNameDto> getTypesWithItems(@RequestParam("id") Integer typeId) {
        return typesService.getContentNameIdById(typeId);
    }

}
