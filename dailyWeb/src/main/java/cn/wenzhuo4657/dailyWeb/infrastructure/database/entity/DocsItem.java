package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.io.Serializable;

/**
 * (DocsItem)实体类
 *
 * @author makejava
 * @since 2025-11-10 13:41:14
 */
public class DocsItem implements Serializable {
    private static final long serialVersionUID = -16086469790491786L;

    private Integer id;

    private Integer index;

    private Integer docsId;

    private String itemContent;

    private String itemField;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getDocsId() {
        return docsId;
    }

    public void setDocsId(Integer docsId) {
        this.docsId = docsId;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public String getItemField() {
        return itemField;
    }

    public void setItemField(String itemField) {
        this.itemField = itemField;
    }

}

