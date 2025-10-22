package cn.wenzhuo4657.dailyWeb.config;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "email.config")
public record EmailProperties(
        @NotBlank String from,
        @NotBlank String to,
        @NotBlank String password
) { }
