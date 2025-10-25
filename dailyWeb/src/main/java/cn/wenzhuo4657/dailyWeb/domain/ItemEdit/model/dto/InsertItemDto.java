package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;


public class InsertItemDto {


    @NotNull
    private Integer content_name_Id;
    @NotNull
    @Min(value = 0)
    private Integer type;
    private Date date;

    public InsertItemDto() {
    }

    public InsertItemDto(Integer content_name_Id, Integer type, Date date) {
        this.content_name_Id = content_name_Id;
        this.type = type;
        this.date = date;
    }

    public Integer getContent_name_Id() {
        return content_name_Id;
    }

    public void setContent_name_Id(Integer content_name_Id) {
        this.content_name_Id = content_name_Id;
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
