package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.io.Serializable;

/**
 * (UserAuth)实体类
 *
 * @author makejava
 * @since 2025-11-10 13:41:16
 */
public class UserAuth implements Serializable {
    private static final long serialVersionUID = -49622796500743526L;

    private Integer id;

    private Long userId;

    private Integer docsTypeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDocsTypeId() {
        return docsTypeId;
    }

    public void setDocsTypeId(Integer docsTypeId) {
        this.docsTypeId = docsTypeId;
    }

}

