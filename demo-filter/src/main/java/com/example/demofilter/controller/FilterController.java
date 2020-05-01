package com.example.demofilter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 微信公众号：全栈学习笔记
 * @date 2020/4/30 14:19
 * @description
 */
@RestController
@RequestMapping("/Filter")
public class FilterController {
    @RequestMapping("/testFilter")
    public String testFilter(){
        System.out.println("filter执行成功");
        return "filter";
    }
}
