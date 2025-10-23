package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemDto {


    @NotNull
    @Min(value = 0)
    private Integer id;

    @NotNull
    private String title;
    @NotNull
    private String content;

    private String expand;//该字段内容根据类型动态变化，用于前端区分不同文档类型， 毫无疑问的是，他可以不传
}
