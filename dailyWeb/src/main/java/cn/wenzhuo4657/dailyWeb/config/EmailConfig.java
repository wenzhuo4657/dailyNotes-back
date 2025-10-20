package cn.wenzhuo4657.dailyWeb.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(EmailProperties.class)
public class EmailConfig {



}
