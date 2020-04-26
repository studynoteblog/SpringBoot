package com.example.demoexception.exception;

/**
 * @author 微信搜索：全栈学习笔记
 */
public enum ErrorEnum {
    // 数据操作错误定义
    SUCCESS(200, "nice"),
    NO_PERMISSION(403, "你没得权限"),
    NO_AUTH(401, "你能不能先登录一下"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器跑路了"),;

    /**
     * 错误码
     */
    private Integer errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    ErrorEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}