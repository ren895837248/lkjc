package com.lkjc.consumablesmanager.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class LKWebMvcConfigurer implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**/*.*")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(24, TimeUnit.HOURS).cachePublic());
    }

}
