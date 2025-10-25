package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class UpdateItemDto {

    @NotNull
    @Min(value = 0)
    private Integer id;
    @NotNull
    private String content;


    public UpdateItemDto(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
