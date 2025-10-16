package cn.wenzhuo4657.dailyWeb.controller.mdEdit;


import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dao.DailyRepository;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.Dto.InsertItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.Dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.Dto.UpdateItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 目前类型为： 备忘录
 *
 */
public class TypeDailyController {

    //TODO 备忘录类型，相关选择列表接口，暂时不处理多文档，而是处理多文档类型
//        备忘录需要关联tg通知，做成条目， 通知类型， 每日通知
    @Autowired
    protected DailyRepository mdRepository;

    @RequestMapping(
            value = "type",
            method = RequestMethod.GET
    )
    public List<ItemDto> getMd(
            @RequestParam(value = "id") Integer content_name_Id
    )  {

        return mdRepository.getMd(content_name_Id);
    }


    /**
     * 修改文档item
     */
    @RequestMapping(
            value = "type",
            method = RequestMethod.PUT
    )
    public boolean updateItem(@RequestBody UpdateItemDto params,
                              @RequestParam(value = "id") Integer content_name_Id
                              ) {

        if (params.getId() == null){
            return false;
        }
        mdRepository.updateMd( params, content_name_Id);
        return true;

    }


    /**
     * 新增文档item条目
     */
    @RequestMapping(
            value = "type",
            method = RequestMethod.POST
    )
    public boolean addItem(@RequestBody InsertItemDto params)  {
        mdRepository.addItem(params);
        return true;
    }






}
