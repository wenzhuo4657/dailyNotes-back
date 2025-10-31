package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

public class ContentName {

    private Integer id;

    private String name;

    private Integer type;

    // SQLite 最终存储为 TEXT，这里统一使用 String
    private String createTime;

    private String updateTime;

    public ContentName() {
    }

    public ContentName(Integer id, String name, Integer type, String createTime, String updateTime) {
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
}
