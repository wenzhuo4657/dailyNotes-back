package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.io.Serializable;

/**
 * (Dataversion)实体类
 *
 * @author makejava
 * @since 2025-10-27 21:54:05
 */
public class Dataversion implements Serializable {
    private static final long serialVersionUID = 523686320027327787L;

    private Integer id;

    private String tag;

    private String log;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

}

