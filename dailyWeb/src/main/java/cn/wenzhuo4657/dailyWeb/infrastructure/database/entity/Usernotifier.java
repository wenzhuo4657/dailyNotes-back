package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.io.Serializable;

/**
 * (Usernotifier)实体类
 *
 * @author makejava
 * @since 2025-11-04 16:35:23
 */
public class Usernotifier implements Serializable {
    private static final long serialVersionUID = -39963319467023164L;

    private Integer id;

    private Integer userid;

    private String type;

    private String config;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

}

