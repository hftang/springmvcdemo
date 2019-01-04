package com.itcast.intercepters;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hftang
 * @date 2019-01-04 17:11
 * @desc 自定义拦截器
 */
public class MyIntercepters implements HandlerInterceptor {

    /**
     * 返回TRUE 表示让拦截通过
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle 拦截器 被执行");


        return true;
    }


}
