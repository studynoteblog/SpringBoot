package com.example.demolog.aop;

import com.example.demolog.annotation.MyLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author 全栈学习笔记
 * @date 2020/5/3 18:00
 * @description
 */
//标明这是一个切面类
@Aspect
//标明这是一个bean
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.example.demolog.annotation.MyLog)")
    public void myPointCut(){//签名，可以理解成这个切入点的一个名称

    }
    @Before("myPointCut()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取url,请求方法，ip地址，类名以及方法名，参数
        logger.info("url={},method={},ip={},class_method={},args={}", request.getRequestURI(),request.getMethod(),request.getRemoteAddr(),joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),joinPoint.getArgs());

    }
    @AfterReturning(pointcut = "myPointCut()")
    public void printLog(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MyLog myLog = method.getAnnotation(MyLog.class);
        String value = null;
        if (myLog!=null){
            value = myLog.value();
        }
        logger.info(new Date()+"-----"+value);
    }

}

/**
 * @Pointcut 定义一个方法为切点里面的内容为一个表达式, 下面详细介绍
 @befor:前置通知，在一个方法执行之前被调用。

 @after:在方法执行之后调用的通知，无论方法执行是否成功。

 @after-returning:仅当方法成功完成之后通知。

 @after-throwing:在方法抛出异常退出时执行的通知。

 @around:在方法执行之前和之后调用的通知。
 */
/**
 *
    Pointcut注解组合使用:
     上面代码中,我们定义了一个切点,该切点只进行处理指定路径的:
    @Pointcut("execution(public * com.example.DemoApplication.*(..))")
    private void controllerAspect(){}
    现在,我们在定义一个处理其他路径下的切点:

    @Pointcut("execution(public * com.demo.*.*(..))")
    private void controllerDemo(){}
     以上切点,都是分别处理不同的内容,如果我们需要一个切点来处理他们两者,我们可以这么配置:

    @Pointcut(value = "controllerAspect()||controllerDemo()")
    private void all(){}
     在@Pointcut注解内,直接引用其它被@Pointcut注解过的方法名称,这样,该切点就可以处理两个路径下的方法
    @Pointcut注解中的execution表达式: public * com.demo.*.*(..)
     第一个 public 表示方法的修饰符,可以用*代替
     第一个 * 表示 返回值,*代表所有
     com.demo.* 包路径,.*表示路径下的所有包
     第三个.* 表示路径下,所有包下的所有类的方法
     (..) 表示不限方法参数

    execution: 匹配连接点
     within: 某个类里面
     this: 指定AOP代理类的类型
     target:指定目标对象的类型
     args: 指定参数的类型
     bean:指定特定的bean名称，可以使用通配符（Spring自带的）
    @target： 带有指定注解的类型
    @args: 指定运行时传的参数带有指定的注解
    @within: 匹配使用指定注解的类
    @annotation:指定方法所应用的注解
 */