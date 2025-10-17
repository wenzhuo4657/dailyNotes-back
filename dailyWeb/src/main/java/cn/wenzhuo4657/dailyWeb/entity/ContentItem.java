package cn.wenzhuo4657.dailyWeb.entity;

import cn.wenzhuo4657.dailyWeb.controller.mdEdit.function.typeDaily.FiledFn;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.function.typeDaily.FiledFunction;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.function.typeDaily.TitleFn;
import cn.wenzhuo4657.dailyWeb.controller.mdEdit.model.vo.contentItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.function.Function;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContentItem {


    private Integer id;

    private Integer content_name_Id;

    private String content;

    private String field;


    private String date;




    public void setField(String field) {
        throw  new UnsupportedOperationException("不支持此操作");
    }

    /**
     * 初始化filed
     */
    public void setField(FiledFn function, contentItemType.ItemType itemType) throws ClassNotFoundException {
        String res=function.toFiled(itemType);
        this.field=res;
    }

    /**
     *todo  变更filed
     */




}
