package com.poni.aspect;

import jdk.nashorn.internal.ir.CallNode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/*
 *@author:PONI_CHAN
 *@date:2018/9/30 21:22
 */
@Aspect
@Component   //引入spring容器
public class HttpAspect {

    //org.slf4j.Logger spring自带日志框架,方便查看进程号，端口号，包
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.poni.controller.GirlController.*(..))")   //切某个点
    public void log(){
    }

    //http请求到这些方法之前日志记录下来
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        //创建Http请求对象
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());

    }
    //http请求到这些方法之后日志记录下来
    @After("log()")
    public void doAfter(){
        logger.info("6666666666666");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturing(Object object){
        logger.info("response={}",object.toString());
    }

}
