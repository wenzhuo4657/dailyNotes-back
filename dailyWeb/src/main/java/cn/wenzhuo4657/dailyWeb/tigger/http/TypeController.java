package cn.wenzhuo4657.dailyWeb.tigger.http;


import cn.wenzhuo4657.dailyWeb.domain.Types.ITypesService;

import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.DocsDto;
import cn.wenzhuo4657.dailyWeb.domain.Types.model.dto.TypeDto;
import cn.wenzhuo4657.dailyWeb.types.utils.AuthUtils;
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
        return typesService.getAllTypes(AuthUtils.getLoginId());
    }


    @RequestMapping(value = "/getContentIdsByTypes")
    public List<DocsDto> getTypesWithItems(@RequestParam("id") Long typeId) {
        return typesService.getContentNameIdById(typeId,AuthUtils.getLoginId());
    }

}
