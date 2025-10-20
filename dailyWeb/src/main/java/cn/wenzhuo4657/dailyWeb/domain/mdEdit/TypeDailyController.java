package cn.wenzhuo4657.dailyWeb.domain.mdEdit;


import cn.wenzhuo4657.dailyWeb.domain.mdEdit.model.Dto.InsertItemDto;
import cn.wenzhuo4657.dailyWeb.domain.mdEdit.model.Dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.mdEdit.model.Dto.UpdateItemDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 */
public class TypeDailyController  extends FieldController {

    //TODO 备忘录类型，相关选择列表接口，暂时不处理多文档，而是处理多文档类型
//        备忘录需要关联tg通知，做成条目， 通知类型， 每日通知


    @RequestMapping(
            value = "type",
            method = RequestMethod.GET
    )
    public List<ItemDto> getMd(
            @RequestParam(value = "id") Integer content_name_Id,
            @RequestParam(value = "type") Integer type
    )  {

        return mdRepository.getMd(content_name_Id,type);
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
//        todo 参数校验，使用spring-boot-starter-validation
        if (params.getDate()==null){
            mdRepository.addItem(params.getContent_name_Id(),params.getType());

        }else {
            mdRepository.addItem(params.getContent_name_Id(),params.getType(),params.getDate());
        }

        return true;
    }






}
