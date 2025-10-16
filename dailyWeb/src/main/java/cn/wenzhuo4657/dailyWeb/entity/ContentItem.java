package cn.wenzhuo4657.dailyWeb.entity;

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
        this.field = field;
    }


    //        TODO java使用函数式接口,以此来避免直接使用String类型设置title，对于title和field的设置必须使用我设置的contentItemType中的转换方法
    public String setField(Function  function) {
        throw  new UnsupportedOperationException("不支持此操作");
    }
}
