package com.bdqn.tytcake.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局的请求监控，日志计时并写入文件中
 * @Author  郑高明
 */
@Aspect
@Component
public class RequestAspestLogger{

    private final  static Logger logger= Logger.getLogger(RequestAspestLogger.class);

    @Pointcut("execution(public * com.bdqn.tytcake.controller.*.*(..))")
    public void puintcut(){
    }

    /**
     * 记录了请求的时间，参数，客户端请求IP，所请求的目标方法
     */
    @Before("puintcut()")
    public void doBefore(){
        ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("URL==========》{}"+request.getRequestURI()+"Method=======》{}"+request.getMethod()+"IP=========》{}"+request.getRemoteAddr());
    }
}
