package com.ToDoAPI.todoAPI.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Cors implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Remova ou comente essa linha para desabilitar o CORS global
        registry.addMapping("/**").allowedOrigins("http://localhost:3000");
    }


}
