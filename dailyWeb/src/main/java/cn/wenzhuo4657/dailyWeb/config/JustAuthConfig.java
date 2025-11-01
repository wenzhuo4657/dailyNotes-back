package cn.wenzhuo4657.dailyWeb.config;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GithubProperties.class)
public class JustAuthConfig {

    @Bean
    @ConditionalOnProperty(prefix = "github", name = {"client-id", "client-secret", "redirect-uri"})
    public AuthRequest authRequest(GithubProperties githubProperties) {
        return new AuthGithubRequest(AuthConfig.builder()
                .clientId(githubProperties.getClientId())
                .clientSecret(githubProperties.getClientSecret())
                .redirectUri(githubProperties.getRedirectUri())
                .build());
    }
}
