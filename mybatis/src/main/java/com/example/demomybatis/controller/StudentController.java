package com.example.demomybatis.controller;

import com.example.demomybatis.entity.Student;
import com.example.demomybatis.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author 全栈学习笔记
 * @since 2020-04-14 11:39:20
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Student selectOne(Integer id) {
        return this.studentService.queryById(id);
    }

}