package cn.wenzhuo4657.dailyWeb.controller.mdEdit;

import cn.wenzhuo4657.dailyWeb.controller.mdEdit.Dao.BaseRepository;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.Dto.UpdateCheckListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 对field进行处理
 */
public class FieldController {


    @Autowired
    protected BaseRepository mdRepository;

//        todo 目前缺少修改field的逻辑
    /**
     *  备忘录类型的title字段重写
     */
    @RequestMapping(
            value = "checkList",
            method = RequestMethod.POST
    )
    public boolean CheckList(@RequestBody UpdateCheckListDto params)  {

        return true;
    }

    @RequestMapping(
            value = "checkList/finish",
            method = RequestMethod.POST
    )
    public boolean CheckListFinish(@RequestBody UpdateCheckListDto params)  {

        return true;
    }
}
