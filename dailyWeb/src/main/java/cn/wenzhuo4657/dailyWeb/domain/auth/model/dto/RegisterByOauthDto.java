package cn.wenzhuo4657.dailyWeb.domain.auth.model.dto;

public class RegisterByOauthDto {

    private String oauth_provider_username;
    private String oauth_provider_avatar;
    private String oauth_provider;

    private String oauth_provider_user_id;


    public RegisterByOauthDto() {

    }

    public RegisterByOauthDto(String oauth_provider_username, String oauth_provider_avatar, String oauth_provider, String oauth_provider_user_id) {
        this.oauth_provider_username = oauth_provider_username;
        this.oauth_provider_avatar = oauth_provider_avatar;
        this.oauth_provider = oauth_provider;
        this.oauth_provider_user_id = oauth_provider_user_id;
    }

    public String getOauth_provider_username() {
        return oauth_provider_username;
    }

    public void setOauth_provider_username(String oauth_provider_username) {
        this.oauth_provider_username = oauth_provider_username;
    }

    public String getOauth_provider_avatar() {
        return oauth_provider_avatar;
    }

    public void setOauth_provider_avatar(String oauth_provider_avatar) {
        this.oauth_provider_avatar = oauth_provider_avatar;
    }

    public String getOauth_provider() {
        return oauth_provider;
    }

    public void setOauth_provider(String oauth_provider) {
        this.oauth_provider = oauth_provider;
    }

    public String getOauth_provider_user_id() {
        return oauth_provider_user_id;
    }

    public void setOauth_provider_user_id(String oauth_provider_user_id) {
        this.oauth_provider_user_id = oauth_provider_user_id;
    }
}
