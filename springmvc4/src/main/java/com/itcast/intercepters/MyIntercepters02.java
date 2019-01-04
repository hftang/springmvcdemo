package com.itcast.intercepters;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hftang
 * @date 2019-01-04 17:11
 * @desc 自定义拦截器
 */
public class MyIntercepters02 implements HandlerInterceptor {

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

        System.out.println("preHandle 拦截器 被执行2222");

        //返回false 被拦截 跳转到不同的页面
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle after2222");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after-->after2222");
    }
}
