package com.fqz.java.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/16
 * Time: 13:55
 * 每个应用都有一个唯一的Context对象，即上下文对象，我们可以在Context对象的创建和销毁过程中添加监听，
 * 实现ServletContextListener来达到目的。
 */
public class MyServletContextListener implements ServletContextListener {
    /**
     * 初始化web 应用时调用
     * servletContextEvent.getServletContext().getInitParameter，在web.xml中的Context-parameter中配置
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("LALALLAA ~~~~~~~~~~~~~~~ !!!!!!!!!!!!!!!!!!!! ----------------");
        System.out.println(servletContextEvent.getServletContext().getInitParameter("Init Parameter"));
        servletContextEvent.getServletContext().setAttribute("KEY","value");//初始化web应用时，向context中添加一个Attribute
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
