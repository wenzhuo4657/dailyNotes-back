package cn.wenzhuo4657.dailyWeb.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    Logger  log= org.slf4j.LoggerFactory.getLogger(CorsConfig.class);
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许跨域的路径
                .allowedOrigins("*") // 允许所有来源的域
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许所有方法
                .allowedHeaders("*") // 允许所有请求头

                .maxAge(3600); // 预检请求的有效期（秒）
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // todo 注册 Sa-Token 拦截器，打开注解式鉴权功能
        registry.addInterceptor(new SaInterceptor(
                handler -> StpUtil.checkLogin()
                ))
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/oauth/**" // 使用修正后的路径
                );
    }

}
