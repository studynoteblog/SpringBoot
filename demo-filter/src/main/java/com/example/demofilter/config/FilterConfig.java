//package com.example.demofilter.config;
//
//import com.example.demofilter.filter.MyFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author 公众号：全栈学习笔记
// * @date 2020/4/30 18:56
// * @description
// */
//@Configuration
//public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean registFilter(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new MyFilter());
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setName("Filter1");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
//}
