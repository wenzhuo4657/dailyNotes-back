package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdateCheckListDto {

    @NotNull
    @Min(value = 0)
    private Integer id;

    @NotNull
    private String title;

    public UpdateCheckListDto() {
    }

    public UpdateCheckListDto(Integer id, String title) {
        this.id = id;
        this.title = title;
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
}

