package com.tangxu.spring_mvc.web;

import com.tangxu.spring_mvc.listener.WebApplicationContextUtils;
import com.tangxu.spring_mvc.service.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    private String message;
    public void init() {
        message = "Hello userServlet!";
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        /*
        * web容器上下文中获取spring容器
        *
        * */
        //ApplicationContext app1= (ApplicationContext) req.getServletContext().getAttribute("app");//方法一、获取spring容器

        ApplicationContext app1=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        UserService userService = app1.getBean(UserService.class);
        userService.save();

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

    }


}
