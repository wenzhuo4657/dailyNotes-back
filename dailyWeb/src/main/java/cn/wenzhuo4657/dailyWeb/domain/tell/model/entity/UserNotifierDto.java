package cn.wenzhuo4657.dailyWeb.domain.tell.model.entity;

public class UserNotifierDto {
    private  Integer notifyId;
    private String name;

    private String type;


    public Integer getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(Integer notifyId) {
        this.notifyId = notifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserNotifierDto(Integer notifyId, String name, String type) {
        this.notifyId = notifyId;
        this.name = name;
        this.type = type;
    }

    public UserNotifierDto() {
    }
}
