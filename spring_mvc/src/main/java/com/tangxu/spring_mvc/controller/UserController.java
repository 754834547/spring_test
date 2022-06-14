package com.tangxu.spring_mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tangxu.spring_mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /*
返回对象输出输出
告知springmvc框架该方法不进行视图页面跳转，直接返回方法体数据
* */
    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10(User user) {
        user.setAge(18);
        user.setPhone("13125656585");
        user.setUserName("save10");
        return user;
    }

    /*
   返回对象输出输出
 告知springmvc框架该方法不进行视图页面跳转，直接返回方法体数据
* */
    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9(User user) throws JsonProcessingException {
        user.setAge(18);
        user.setPhone("13125656585");
        user.setUserName("save9");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        return s;
    }
    /*
   返回对象输出输出
 告知springmvc框架该方法不进行视图页面跳转，直接返回方法体数据
* */
    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8(User user) {
        user.setAge(18);
        user.setPhone("13125656585");
        user.setUserName("save8");
        return user.toString();
    }
    /*
    spring字符串输出
    告知springmvc框架该方法不进行视图页面跳转，直接返回方法体数据
* */
    @RequestMapping(value = "/quick7")
    @ResponseBody
    public String save7() {
        return "hello sava7";
    }

    /*
        原生http请求返回字符串
 * */
    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse res) throws IOException {
        res.getWriter().println("hello save6");
    }
    /*

    /*
           原生http请求
    * */
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("name", "save5");

        return "success";
    }
    /*
       spring容器创建ModelAndView对象
       * */
    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("name", "save4");
        return "success";
    }

    /*
    spring容器创建ModelAndView对象
    * */
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.setViewName("success");
        modelAndView.addObject("name", "save3");
        return modelAndView;
    }

    /*
        model 模型：封装数据
        view  视图：展示数据
    * */
    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("name", "save2");
        return modelAndView;
    }

    @RequestMapping(value = "/quick")
    public String save() {
        System.out.println("Controller save save");
        return "success";
    }
}
