package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 全栈学习笔记
 * @date 2020/4/16 10:43
 * @description
 */
@Controller
public class ThymeleafController {
    @GetMapping("/getStudents")
    public ModelAndView getStudent(){
        List<Student> students = new LinkedList<>();
        Student student = new Student();
        student.setId(1);
        student.setName("全栈学习笔记");
        student.setAge(21);
        Student student1 = new Student();
        student1.setId(2);
        student1.setName("张三");
        student1.setAge(22);
        students.add(student);
        students.add(student1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students",students);
        modelAndView.setViewName("students");
        return modelAndView;
    }
    @RequestMapping("/getString")
    public String getString(HttpServletRequest request){
        String name = "全栈学习笔记";
        request.setAttribute("name",name);
        return "index";
    }
    @RequestMapping("/getModel")
    public String getModel(Model model){
        model.addAttribute("key","这是一个键");
        return "index";
    }
}
