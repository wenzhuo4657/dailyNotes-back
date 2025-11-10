package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.io.Serializable;

/**
 * (Notifier)实体类
 *
 * @author makejava
 * @since 2025-11-10 18:17:09
 */
public class Notifier implements Serializable {
    private static final long serialVersionUID = 334212465223081884L;

    private Integer id;

    private Integer userId;

    private Integer notifierTypeId;

    private String name;

    private String configJson;

    private Integer notifierId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNotifierTypeId() {
        return notifierTypeId;
    }

    public void setNotifierTypeId(Integer notifierTypeId) {
        this.notifierTypeId = notifierTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfigJson() {
        return configJson;
    }

    public void setConfigJson(String configJson) {
        this.configJson = configJson;
    }

    public Integer getNotifierId() {
        return notifierId;
    }

    public void setNotifierId(Integer notifierId) {
        this.notifierId = notifierId;
    }

}

