package com.example.democrossorigin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 微信公众号 全栈学习笔记
 * @date 2020/4/20 9:38
 * @description
 */
//@CrossOrigin  表示所有的URL均可访问此资源
@CrossOrigin(origins = "http://127.0.0.1:8093")//表示只允许这一个url可以跨域访问这个controller
@RestController
@RequestMapping("/testCorss")
public class CorssOriginController {

    //可以对方法运用该注解
    //@CrossOrigin(origins = "http://127.0.0.1:8093")
    @GetMapping("/getString")
    public String getString(){
        return "跨域成功！";
    }

}
