package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class UpdateItemDto {

    @NotNull
    @Min(value = 0)
    private Long index;

    @NotNull
    @Min(0)
    private Integer type;

    @NotNull
    private String content;


    public UpdateItemDto(Long id, Integer type, String content) {
        this.index = id;
        this.type = type;
        this.content = content;
    }

    public UpdateItemDto() {
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


}
