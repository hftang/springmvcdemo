package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hftang
 * @date 2019-01-03 15:03
 * @desc
 */

@Controller
@RequestMapping("/user")
public class UserController {

    //返回是字符串类型的
    @RequestMapping(path = "/testString")
    public String testString(Model model) {
        System.out.println("testString：字符串方法执行了");
        User user = new User();
        user.setAge(22);
        user.setName("hftang");
        user.setPwd("1234567");

        //存入
        model.addAttribute("user", user);

        return "success";
    }

    //返回类型是void
    @RequestMapping(path = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("---->");
//转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //重定向 因为是2次请求 所有不能直接访问 web-inf下的jsp
//        response.sendRedirect("");

//        直接返回

        response.setCharacterEncoding("UTF-8");//编码类型
        response.setContentType("text/html,charset=UTF-8");//打开类型

        response.getWriter().println("你好");
    }

    @RequestMapping(path = "/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setName("hftang888");
        user.setPwd("123456");
        user.setAge(33);

        modelAndView.addObject(user);
        modelAndView.setViewName("success");
        return modelAndView;
    }

//        使用关键字 redirect  forword

    @RequestMapping(path = "/testRedirectOrForword")
    public String testRedirectOrForword() {
        System.out.println("------->forword");
        //请求转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //请求重定向

        return "redirect:/response.jsp";
    }

    //获取json 数据  使用注解 @requestBody

    @RequestMapping(value = "/testAjax")
    public void testRequestBody(@RequestBody String body){
        System.out.println(body);
    }


}
