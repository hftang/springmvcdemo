package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hftang
 * @date 2018-12-28 13:41
 * @desc
 */

@Controller
@RequestMapping(path = "/kk")
public class HelloController {

    /**
     * value 和 path 是一样的
     * @return
     */

    @RequestMapping(value = "/hello", params = {"name=111"}, method = RequestMethod.GET,headers = {"accept"})
    public String sayHello() {
        System.out.println("hello spring");
        return "success";
    }

    @RequestMapping(path = "/tellme")
    public String tellMe() {
        System.out.println("tell me !!!");
        return "success";
    }
}
