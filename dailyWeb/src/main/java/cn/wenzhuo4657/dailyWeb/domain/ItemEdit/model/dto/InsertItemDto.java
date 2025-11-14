package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;


public class InsertItemDto {


    @NotNull
    @Min(0)
    private Long docsId;

    @NotNull
    @Min(0)
    private Integer type;
    private Date date; // 可选字段

    public InsertItemDto() {
    }

    public InsertItemDto(Long docsId, Integer type, Date date) {
        this.docsId = docsId;
        this.type = type;
        this.date = date;
    }

    public Long getDocsId() {
        return docsId;
    }

    public void setContentNameId(Long docsId) {
        this.docsId = docsId;
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

