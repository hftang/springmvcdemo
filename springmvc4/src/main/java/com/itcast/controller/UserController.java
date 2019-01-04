package com.itcast.controller;

import com.itcast.exptions.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hftang
 * @date 2019-01-04 14:29
 * @desc
 */


@Controller
@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(path = "/testController")
    public String testController() throws SysException {

        try {
            int z = 10 / 0;
        } catch (Exception e) {
            throw new SysException("除0了");
        }
        System.out.println("testController--->");
        return "success";
    }

    /**
     * 测试拦截器
     *
     * @return
     */

    @RequestMapping(path = "/testInterceptors")
    public String testInterceptors() {
        System.out.println("controller--->");

        return "success";
    }
}
