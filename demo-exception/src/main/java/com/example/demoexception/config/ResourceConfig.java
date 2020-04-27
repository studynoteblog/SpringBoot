package com.example.demoexception.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 全栈学习笔记
 * @date 2020/4/27 11:28
 * @description 可解决前后端分离的情况下，静态资源无法访问的问题
 * 可以访问localhost:8095/static/images/image.jpg
 */
@Configuration
public class ResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //可以访问localhost:8095/static/images/image.jpg
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
