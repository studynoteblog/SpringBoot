package com.example.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 全栈学习笔记
 * @date 2020/4/12 12:20
 * @description
 */
@Controller
public class TestController {
    @RequestMapping("/getHtml")
    public String getHtml(){
        return "index";
    }
}
