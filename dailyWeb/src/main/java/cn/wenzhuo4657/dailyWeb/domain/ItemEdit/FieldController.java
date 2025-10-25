package cn.wenzhuo4657.dailyWeb.domain.ItemEdit;

import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateCheckListDto;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.repository.IItemEditRepository;
import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.service.fieldService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 对field进行处理
 */
public class FieldController {


    @Autowired
    protected IItemEditRepository mdRepository;

    @Autowired
    protected fieldService fieldService;


    /**
     *  备忘录类型的title字段重写
     */
    @RequestMapping(
            value = "/field/checkList/title",
            method = RequestMethod.POST
    )
    public boolean CheckList( @Valid @RequestBody UpdateCheckListDto params)  {
        fieldService.updateCheckListTitle(params);
        return true;
    }

    @RequestMapping(
            value = "/field/checkList/finish",
            method = RequestMethod.POST
    )
    public boolean CheckListFinish(@Valid @RequestParam("id") Integer  id)  {
        fieldService.updateCheckListFinish(id);
        return true;
    }


}
