package com.yang.springbootintegrated.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by BLIT on 2019/3/7.
 */
@Configuration
public class CorsConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //允许跨域访问的链接 "/**" 表示允许所有链接
                .allowedMethods("*");           //允许的http方法(GET,PUT,POST,DELETE...),"*"表示允许所有方法
    }
}
