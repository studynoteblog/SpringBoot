package com.example.demofilter.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 微信公众号：全栈学习笔记
 * @date 2020/4/28 10:17
 * @description
 */
@Order(1)
@WebFilter(filterName = "myFilter1",urlPatterns = {"/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器之前要干啥呢");
        //转发到资源目的地，
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("处理一下服务端返回的response");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了");
    }
}
