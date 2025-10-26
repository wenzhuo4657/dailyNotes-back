package cn.wenzhuo4657.dailyWeb.tigger.http;


import cn.dev33.satoken.stp.StpUtil;
import cn.wenzhuo4657.dailyWeb.domain.Types.ITypesService;
import cn.wenzhuo4657.dailyWeb.infrastructure.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "types")
@ResponseBody // 直接将响应值作为 HTTP 响应体正文，默认会走视图解析
@RequestMapping(value = "/types")
public class TypeController {

    @Autowired
    private ITypesService typesService;


    @RequestMapping(value = "/getAllTypes")
    public String getAllTypes() {
        User userEntity = (User)StpUtil.getSession().get("userInfo");
        return typesService.getAllTypes(userEntity.getId()).toString();
    }

}
