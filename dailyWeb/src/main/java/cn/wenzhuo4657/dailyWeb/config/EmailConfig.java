package cn.wenzhuo4657.dailyWeb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmailConfig {

    @Autowired
    private Environment env;
    @Bean
    public Map<String,String> emailConfig(){
        HashMap<String, String> config = new HashMap<>();
        config.put("from",env.getProperty("email.config.from"));
        config.put("user",env.getProperty("email.config.user"));
        config.put("password",env.getProperty("email.config.password"));
        return config;
    }
}
