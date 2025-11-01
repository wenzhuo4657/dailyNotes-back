package cn.wenzhuo4657.dailyWeb.infrastructure.database.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2025-10-27 21:54:06
 */
public class User implements Serializable {
    private static final long serialVersionUID = -61424034044724139L;

    private Integer id;

    private String avatarUrl;

    private String name;

    private String oauthProvider;

    private String oauthProviderUserId;

    private String createdAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOauthProvider() {
        return oauthProvider;
    }

    public void setOauthProvider(String oauthProvider) {
        this.oauthProvider = oauthProvider;
    }

    public String getOauthProviderUserId() {
        return oauthProviderUserId;
    }

    public void setOauthProviderUserId(String oauthProviderUserId) {
        this.oauthProviderUserId = oauthProviderUserId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}

