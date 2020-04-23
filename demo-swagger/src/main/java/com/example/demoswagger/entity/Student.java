package com.example.demoswagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * (Student)实体类
 *
 * @author 微信公众号：全栈学习笔记
 * @since 2020-04-14 11:39:10
 */
@ApiModel("学生类")
public class Student {

    /**
    * 唯一标识id
    */
    @ApiModelProperty("id")
    private Integer id;
    /**
    * 姓名
    */
    @ApiModelProperty("姓名")
    private String name;
    /**
    * 年龄
    */
    @ApiModelProperty(value = "年龄")
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