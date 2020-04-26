package com.example.demoexception.utils;

import com.example.demoexception.exception.ErrorEnum;
import com.example.demoexception.exception.DefinitionException;
/**
 * @author 微信搜索：全栈学习笔记
 */
public class Result<T> {
    //是否成功
    private Boolean success;
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //数据
    private T data;
    public Result() {

    }
    //自定义返回结果的构造方法
    public Result(Boolean success,Integer code, String msg,T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //自定义异常返回的结果
    public static Result defineError(DefinitionException de){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(de.getErrorCode());
        result.setMsg(de.getErrorMsg());
        result.setData(null);
        return result;
    }
    //其他异常处理方法返回的结果
    public static Result otherError(ErrorEnum errorEnum){
        Result result = new Result();
        result.setMsg(errorEnum.getErrorMsg());
        result.setCode(errorEnum.getErrorCode());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}