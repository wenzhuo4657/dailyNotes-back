package cn.wenzhuo4657.dailyWeb.domain.ItemEdit;


import cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto.UpdateCheckListDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface CheckListService {


    /**
     * 更新备忘录title
     */
    public boolean CheckList(UpdateCheckListDto params);

    /**
     * 更新备忘录状态为完成
     */
    public boolean CheckListFinish(Long  id);


}
