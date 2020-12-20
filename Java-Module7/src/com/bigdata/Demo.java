package com.bigdata;

import javax.servlet.*;
import java.io.IOException;

public class Demo implements Servlet {
//    init: servlet对象创建时，调用此方法完成初始化操作
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("LifeServlet创建了....");

    }
//    getServletConfig：获取ServletConfig配置对象
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /*
        对外提供服务的方法，Tomcat会调用servlet里面的service方法执行具体的业务逻辑
        servletRequest: 请求对象：借助该对象来获取请求参数
        servletResponse：响应对象：借助该对象来想浏览器响应一些数据
    */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("LifeServlet的service方法执行了");

    }
//    getServletInfo：获取servlet的描述信息
    @Override
    public String getServletInfo() {
        return null;
    }
//  destroy：当servlet对象销毁，会调用此方法完成销毁操作
    @Override
    public void destroy() {
        System.out.println("LifeServlet销毁了...");

    }
}