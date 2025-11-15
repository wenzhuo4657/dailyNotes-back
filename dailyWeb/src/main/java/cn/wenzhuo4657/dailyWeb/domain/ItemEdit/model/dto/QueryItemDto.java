package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class QueryItemDto {

    @NotNull
    @Min(0)
    private Long docsId;

    @NotNull
    private String typeName;


    public QueryItemDto() {
    }

    public QueryItemDto(Long docsId, String typeName) {
        this.docsId = docsId;
        this.typeName=typeName;

    }

    public Long getDocsId() {
        return docsId;
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

