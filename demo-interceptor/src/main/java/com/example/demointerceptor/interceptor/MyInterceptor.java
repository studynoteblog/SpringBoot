package com.example.demointerceptor.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author 全栈学习笔记
 * @date 2020/4/27 10:49
 * @description
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    /**
     * 此方法会在进入controller之前执行，返回Boolean值决定是否执行后续操作
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("进入拦截器了");
        //中间写逻辑代码，比如判断是否登录成功,失败则返回false
        return true;
    }

    /**
     * 此方法将在controller执行之后执行，但是视图还没有解析，
     * 可向ModelAndView中添加数据
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //
        System.out.println("controller 执行完了");
    }


    /**
     * 该方法会在整个请求结束（请求结束，但是并未返回给用户）之后执行，
     * 可获取响应数据及异常信息。
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("我获取到了一个返回的结果："+response);
        System.out.println("请求结束了");
    }
}
