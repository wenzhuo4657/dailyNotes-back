package cn.wenzhuo4657.dailyWeb.domain.ItemEdit.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class QueryItemDto {

    @NotNull
    @Min(0)
    private Long docsId;

    @NotNull
    @Min(0)
    @Max(1)
    private Integer type;


    public QueryItemDto() {
    }

    public QueryItemDto(Long docsId, Integer type) {
        this.docsId = docsId;
        this.type = type;
    }

    public Long getDocsId() {
        return docsId;
    }

    public void setDocsId(Long docsId) {
        this.docsId = docsId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

