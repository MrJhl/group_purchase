package com.group.shop.config.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ControllerLogAspect {
 
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //用于计算请求的时间间隔
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    //这个表达式的意思是，cotroller这个controller下所有的方法都会切入
    @Pointcut("execution(public * com.group.shop.controller..*.*(..))")
    public void setLogger(){}

    @Before("setLogger()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("请求url : " + request.getRequestURL().toString());
        logger.info("请求类型 : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("接口包路径 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("参数 : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "setLogger()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("返回结果 : " + ret);
        logger.info("消耗时间 : " + (System.currentTimeMillis() - startTime.get()));
    }


}

