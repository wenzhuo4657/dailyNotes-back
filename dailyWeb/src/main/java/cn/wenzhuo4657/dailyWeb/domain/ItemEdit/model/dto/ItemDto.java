package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ItemDto {


    @NotNull
    @Min(value = 0)
    private Integer id;

    @NotNull
    private String title;
    @NotNull
    private String content;

    private String expand; // 额外字段数据，随类型动态变化

    public ItemDto() {
    }

    public ItemDto(Integer id, String title, String content, String expand) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.expand = expand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }
}

