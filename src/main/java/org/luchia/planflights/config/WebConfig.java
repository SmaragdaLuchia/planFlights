package org.luchia.planflights.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // WebConfig.java
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOriginPatterns("*") // Use this exact line
            .allowedMethods("*")
            .allowedHeaders("*")
            .exposedHeaders("*")
            .maxAge(3600);
    }
}
