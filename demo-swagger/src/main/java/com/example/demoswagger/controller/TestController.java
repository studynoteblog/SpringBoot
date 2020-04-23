package com.example.demoswagger.controller;

import com.example.demoswagger.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 微信公众号 全栈学习笔记
 * @date 2020/4/19 16:08
 * @description
 */
@RestController
@RequestMapping("/Test")
@Api("测试swagger接口")
public class TestController {

    @RequestMapping(path = "/getStudent",method = RequestMethod.GET)
    @ApiOperation("/根据学生id获取学生信息")
    @ApiImplicitParam(name = "id",value = "id",required = true,paramType = "query",dataType = "int")
    public Student getStudent(@RequestParam Integer id){
        Student student = new Student();
        student.setId(11);
        student.setAge(21);
        student.setName("全栈学习笔记");
        Map<Integer,Student> studentMap = new HashMap<>();
        studentMap.put(11,student);
        return studentMap.get(id);
    }
    @RequestMapping(path = "/getStudent",method = RequestMethod.PATCH)
    @ApiOperation("/根据学生id获取学生信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name",value = "姓名",required = true,paramType = "query",dataType = "String"),
        @ApiImplicitParam(name = "age",value = "年龄",required = true,paramType = "query",dataType = "int")
    })
    public Student editStudent(@RequestParam String name, @RequestParam Integer age){
        Student student = new Student();
        student.setId(12);
        student.setName(name);
        student.setAge(age);
        return student;

    }
    @ApiOperation("/添加学生信息")
    @RequestMapping(path = "/addStudent",method = RequestMethod.POST)
    public Map<Integer,Student> AddStudent(@RequestBody Student student){
        Map<Integer,Student> studentMap = new HashMap<>();
        studentMap.put(student.getId(),student);
        return studentMap;
    }
}
