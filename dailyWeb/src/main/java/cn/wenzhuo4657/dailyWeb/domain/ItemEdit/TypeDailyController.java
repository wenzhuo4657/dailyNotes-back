package cn.wenzhuo4657.dailyWeb.domain.ItemEdit;


import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.InsertItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.ItemDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateItemDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 */
public class TypeDailyController  extends FieldController {







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
     * 新增文档item条目  当日
     */
    @RequestMapping(
            value = "type",
            method = RequestMethod.POST
    )
    public boolean addItem(@Valid @RequestBody InsertItemDto params)  {
        mdRepository.addItem(params.getContent_name_Id(),params.getType());

        return true;
    }


    /**
     * 新增文档item条目  指定时间
     * 支持类型： 基本日报
     */
    @RequestMapping(
            value = "type/daily/date",
            method = RequestMethod.POST
    )
    public boolean addItemInDaily(@Valid @RequestBody InsertItemDto params)  {

//        1,先插入2，再修改时间
        return  true;
    }






}
