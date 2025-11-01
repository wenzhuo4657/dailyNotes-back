package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.io.Serializable;

/**
 * (UserContentname)实体类
 *
 * @author makejava
 * @since 2025-10-27 21:54:06
 */
public class UserContentname implements Serializable {
    private static final long serialVersionUID = -84656458608573022L;

    private Integer id;

    private Integer userid;

    private Integer contentnameid;

    private Integer typeid;


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

    public Integer getContentnameid() {
        return contentnameid;
    }

    public void setContentnameid(Integer contentnameid) {
        this.contentnameid = contentnameid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

}

