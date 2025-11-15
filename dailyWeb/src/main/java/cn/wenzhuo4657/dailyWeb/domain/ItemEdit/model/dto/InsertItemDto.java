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

    private String typeName;

    public InsertItemDto() {
    }

    public InsertItemDto(Long docsId, String type) {
        this.docsId = docsId;
        this.typeName = type;

    }

    public Long getDocsId() {
        return docsId;
    }

    public void setContentNameId(Long docsId) {
        this.docsId = docsId;
    }

    public void setDocsId(Long docsId) {
        this.docsId = docsId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}

