package com.itcast.exptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hftang
 * @date 2019-01-04 16:05
 * @desc
 */
public class SysHandlerExceptHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        SysException sysException = null;
        if (e instanceof SysException) {
            sysException = (SysException) e;
        } else {
            sysException = new SysException("系统正在维护。。。");
        }

        ModelAndView mv = new ModelAndView();

        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");

        return mv;
    }
}
