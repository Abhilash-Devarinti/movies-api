package com.abhilash.movies.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Specify the origins you want to allow
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify the HTTP methods you want to allow
                .allowedHeaders("*"); // Specify the headers you want to allow
    }
}
