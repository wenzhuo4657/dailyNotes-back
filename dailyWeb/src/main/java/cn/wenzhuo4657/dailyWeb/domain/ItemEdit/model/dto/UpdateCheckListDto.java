package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdateCheckListDto {

    @NotNull
    @Min(value = 0)
    private Long id;

    @NotNull
    private String title;

    public UpdateCheckListDto() {
    }

    public UpdateCheckListDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

