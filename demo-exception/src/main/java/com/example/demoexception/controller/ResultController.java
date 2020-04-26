package com.example.demoexception.controller;

import com.example.demoexception.entity.Student;
import com.example.demoexception.exception.DefinitionException;
import com.example.demoexception.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 微信搜索全栈学习笔记
 *
 */
@RestController
@RequestMapping("/result")
public class ResultController {
    @GetMapping("/getStudent")
    public Result getStudent(){
        Student student = new Student();
        student.setAge(21);
        student.setId(111);
        student.setName("学习笔记");
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setData(student);
        result.setMsg("学生列表信息");
        return result;
    }
    @RequestMapping("/getDeException")
    public Result DeException(){
        throw new DefinitionException(400,"我出错了");
    }
    @RequestMapping("/getException")
    public Result Exception(){
        Result result = new Result();
        int a=1/0;
        return result;
    }
}
