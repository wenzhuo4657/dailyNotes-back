package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class QueryItemDto {

    @NotNull
    @Min(0)
    private Integer contentNameId;

    @NotNull
    @Min(0)
    @Max(1)
    private Integer type;


    public QueryItemDto() {
    }

    public QueryItemDto(Integer contentNameId, Integer type) {
        this.contentNameId = contentNameId;
        this.type = type;
    }

    public Integer getContentNameId() {
        return contentNameId;
    }

    public void setContentNameId(Integer contentNameId) {
        this.contentNameId = contentNameId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

