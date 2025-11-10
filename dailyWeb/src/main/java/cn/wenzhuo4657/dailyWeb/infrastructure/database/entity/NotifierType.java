package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.io.Serializable;

/**
 * (NotifierType)实体类
 *
 * @author makejava
 * @since 2025-11-10 13:41:14
 */
public class NotifierType implements Serializable {
    private static final long serialVersionUID = 858588409541034480L;

    private Integer id;

    private Integer typeId;

    private String name;

    private String des;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

