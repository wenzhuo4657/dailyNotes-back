package cn.wenzhuo4657.dailyWeb.domain.auth.model.aggregate;

public class CheckUserByOauthAggregate {

    private String oauth_provider;

    private String oauth_provider_user_id;


    public CheckUserByOauthAggregate(String oauth_provider, String oauth_provider_user_id) {
        this.oauth_provider = oauth_provider;
        this.oauth_provider_user_id = oauth_provider_user_id;
    }

    public CheckUserByOauthAggregate() {
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
