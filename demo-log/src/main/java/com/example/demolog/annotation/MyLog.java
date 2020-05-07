package com.example.demolog.annotation;

import java.lang.annotation.*;

/**
 * @author 全栈学习笔记
 * @date 2020/5/3 17:56
 * @description
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {
    String value() default "";
}
