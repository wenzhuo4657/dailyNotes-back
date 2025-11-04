package cn.wenzhuo4657.dailyWeb.domain.tell.model.entity;

public class UserNotifierDto {
    private  Integer id;

    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserNotifierDto(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public UserNotifierDto() {
    }
}
