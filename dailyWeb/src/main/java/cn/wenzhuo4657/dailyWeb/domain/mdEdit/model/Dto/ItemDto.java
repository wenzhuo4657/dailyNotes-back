package cn.wenzhuo4657.dailyWeb.domain.mdEdit.model.Dto;


import lombok.Data;

@Data
public class ItemDto {

    private Integer id;

    private String title;

    private String content;

    private String expand;//该字段内容根据类型动态变化，用于前端区分不同文档类型， 毫无疑问的是，他可以不传
}
