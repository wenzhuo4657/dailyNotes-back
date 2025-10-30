package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;


public class InsertItemDto {


    @NotNull
    @Min(0)
    private Integer contentNameId;

    @NotNull
    @Min(0)
    private Integer type;
    private Date date; // 可选字段

    public InsertItemDto() {
    }

    public InsertItemDto(Integer contentNameId, Integer type, Date date) {
        this.contentNameId = contentNameId;
        this.type = type;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

