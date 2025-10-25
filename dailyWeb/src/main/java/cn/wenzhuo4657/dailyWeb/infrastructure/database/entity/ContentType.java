package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

public class ContentType {

    private Integer id;

    private String name;

    private String des;

    public ContentType() {
    }

    public ContentType(Integer id, String name, String des) {
        this.id = id;
        this.name = name;
        this.des = des;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
