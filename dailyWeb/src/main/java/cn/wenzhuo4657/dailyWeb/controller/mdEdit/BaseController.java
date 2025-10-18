package cn.wenzhuo4657.dailyWeb.controller.mdEdit;


import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.Dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.Dto.UpdateItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "content")
@ResponseBody // 直接将响应值作为 HTTP 响应体正文，默认会走视图解析
@RequestMapping(value = "/md")
public class BaseController extends TypeDailyController  {





    /**
     * 获取基本文档（即日报）基本数据，无需指定参数
     */
    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<ItemDto> getMd(
    )  {

        return mdRepository.getMd();
    }


    /**
     * 修改文档item content
     */
    @RequestMapping(
            method = RequestMethod.PUT
    )
    public boolean updateItem(@RequestBody UpdateItemDto params) {

        if (params.getId() == null){
            return false;
        }


        mdRepository.updateMd( params);
        return true;

    }


    /**
     * 新增文档item条目
     */
    @RequestMapping(
            method = RequestMethod.POST
    )
    public boolean addItem()  {
        mdRepository.addItem();
        return true;
    }












}
