package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.util.Date;

public class ContentName {

    private Integer id;

    private String name;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    public ContentName() {
    }

    public ContentName(Integer id, String name, Integer type, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
