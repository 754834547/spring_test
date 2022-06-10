package com.tangxu.spring_mvc.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//servlet监听spring容器,启动就
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        servletContextEvent.getServletContext().setAttribute("app", app);
        System.out.println("spring 容器初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
