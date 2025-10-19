package cn.wenzhuo4657.dailyWeb.entity;

import cn.wenzhuo4657.dailyWeb.domain.mdEdit.function.typeDaily.FiledFn;
import cn.wenzhuo4657.dailyWeb.domain.mdEdit.model.vo.contentItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        this.field = field;
    }

    /**
     * 初始化filed
     */
    public void setField(FiledFn function, contentItemType.ItemType itemType) throws ClassNotFoundException {
        String res=function.toFiled(itemType);
        this.field=res;
    }






}
