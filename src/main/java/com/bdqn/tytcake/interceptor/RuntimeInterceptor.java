package com.bdqn.tytcake.interceptor;


import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 郑高明
 * 运行性能监控
 */
public class RuntimeInterceptor extends HandlerInterceptorAdapter{
    private NamedThreadLocal<Long> threadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

    /**
     * 进入控制器的开始时间
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        Long beginTime = System.currentTimeMillis();// 开始时间
        System.out.println("开始时间==================" + beginTime);
        threadLocal.set(beginTime);
        return true;
    }

    /**
     * 走出控制器的时间
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        Long endTime = System.currentTimeMillis();// 结束时间
        Long beginTime = threadLocal.get();//  结束时间
        Long consumeTime = endTime - beginTime;// 耗时时间
        System.out.println("==============================耗时时间" + consumeTime);
    }
}