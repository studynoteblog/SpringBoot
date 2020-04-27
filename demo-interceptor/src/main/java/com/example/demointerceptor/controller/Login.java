package com.example.demointerceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 微信公众号：全栈学习笔记
 * @date 2020/4/27 10:50
 * @description
 */
@RestController
@RequestMapping("LoginController")
public class Login {
    @RequestMapping("/login")
    public String login(){
        System.out.println("controller开始执行");
        return "login success";
    }
}
