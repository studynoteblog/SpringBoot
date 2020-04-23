package com.example.democonfig.controller;

import com.example.democonfig.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 微信公众号：全栈学习笔记
 * @date 2020/4/6 9:57
 * @description
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    Student student;
    @GetMapping("/getStudent")
    public Student getStudent(){
        return student;
    }
}
