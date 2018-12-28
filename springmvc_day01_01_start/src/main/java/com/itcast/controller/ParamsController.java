package com.itcast.controller;

import com.itcast.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hftang
 * @date 2018-12-28 17:01
 * @desc
 */
@Controller
@RequestMapping("/params")
public class ParamsController {

    @RequestMapping(value = "/pass")
    public String passParams(String name, String password) {
        System.out.println("----->");
        System.out.println(name);
        System.out.println(password);

        return "success";
    }

    @RequestMapping("/object")
    public String testObject(Account account) {
        System.out.println(account);

        return "success";
    }
}
