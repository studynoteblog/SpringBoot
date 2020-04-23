package com.example.demomybatis.entity;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author 全栈学习笔记
 * @since 2020-04-14 11:39:10
 */
public class Student  {
    private static final long serialVersionUID = -91969758749726312L;
    /**
    * 唯一标识id
    */
    private Integer id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 年龄
    */
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}