package com.learn.web.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ldy on 2017/3/27.
 * 计算每一次请求的处理时间
 */
public class WasteTimePerRequestInterceptor extends HandlerInterceptorAdapter {
    /** Logger used by this class. Available to subclasses. */
    protected final Log logger = LogFactory.getLog(getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        if(logger.isInfoEnabled()){
            logger.info("此次请求处理时间为："+(System.currentTimeMillis()-startTime)+" ms");
        }
        //如果其他处需要处理，可将消耗时间继续放到request对象中向下传递
    }
}
