package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.io.Serializable;

/**
 * (Docs)实体类
 *
 * @author makejava
 * @since 2025-11-10 13:41:14
 */
public class Docs implements Serializable {
    private static final long serialVersionUID = -26464799115145196L;

    private Integer id;

    private String name;

    private Integer typeId;

    private String createTime;

    private String updateTime;

    private Integer docsId;

    private Long userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDocsId() {
        return docsId;
    }

    public void setDocsId(Integer docsId) {
        this.docsId = docsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

