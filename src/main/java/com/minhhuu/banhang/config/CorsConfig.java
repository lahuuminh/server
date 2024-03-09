package com.minhhuu.banhang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Chấp nhận yêu cầu từ tất cả các nguồn
                .allowedMethods("*") // Chấp nhận tất cả các phương thức HTTP (GET, POST, PUT, DELETE, v.v.)
                .allowedHeaders("*"); // Chấp nhận tất cả các tiêu đề
    }
}
