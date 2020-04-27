package com.example.demointerceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 全栈学习笔记
 * @date 2020/4/27 10:51
 * @description
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("经过拦截的controller代码执行完毕");
        return "hello";
    }
}
