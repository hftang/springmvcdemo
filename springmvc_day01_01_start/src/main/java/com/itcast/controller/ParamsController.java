package com.itcast.controller;

import com.itcast.domain.Account;
import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.file.Path;
import java.util.Date;
import java.util.Map;

/**
 * @author hftang
 * @date 2018-12-28 17:01
 * @desc
 */
@Controller
@RequestMapping("/params")
@SessionAttributes(value = "msg")
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

    /**
     * 测试requestParams注解
     *
     * @param name
     * @return
     */

    @RequestMapping("/testParams")
    public String testParams(@RequestParam(value = "username", required = true) String name) {
        System.out.println(name);
        return "success";

    }

    /**
     * 测试 requestBody
     *
     * @param body
     * @return
     */

    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        //name=hftang&password=12345&money=1111
        return "success";
    }


    @RequestMapping(path = "/testPathVariable/{id}")
    public String testPathvariable(@PathVariable(value = "id") String id) {
        System.out.println(id);
        return "success";
    }

    @RequestMapping(path = "/saveAccount")
    public String saveAccount(Account account) {
        System.out.println(account);

        return "success";
    }

    //    保存用户

    @RequestMapping(path = "/saveUser")
    public String savaUser(User user) {
        System.out.println(user);
        return "success";
    }

    //获取原生的api
    @RequestMapping(path = "/getApi")
    public String getApi(HttpServletRequest request, HttpServletResponse response) {

        System.out.println(request);
        System.out.println(response);

        //获取session
        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        return "success";
    }

    //获取请求值的头信息
    @RequestMapping(path = "/getHeader")
    public String getHeader(@RequestHeader(value = "accept") String header) {
        System.out.println(header);
        return "success";
    }

    //获取cookievalue

    @RequestMapping(path = "/getCookieValue")
    public String getCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("cookievalue:" + cookieValue);
        return "success";
    }

    //测试modelattribute

    @RequestMapping(path = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute:" + user);
        return "success";
    }


    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        User user = new User();
        user.setAge(30);
        user.setUname(uname);
        user.setDate(new Date());
        System.out.println("showUser:" + uname);
        map.put("abc", user);
    }

    //测试 sessionattribute

    @RequestMapping("/getSessionAttribute")
    public String getSessionAttribute(Model model) {
        model.addAttribute("msg", "hftang");
        System.out.println("--存入了request域中");
        //存入requestscope中

        //SessionAttributes 存在session域中
        return "success";
    }

    //从session中获取值
    @RequestMapping("/obtainAttributes")
    public String obtainsAttribute(ModelMap modelMap) {
        String msgg = (String) modelMap.get("msg");
        System.out.println("msgg" + msgg);
        return "success";
    }

    //删除一个值
    @RequestMapping("/delAttribute")
    public String delAttribute(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        System.out.println("del complete");
        return "success";
    }
}
