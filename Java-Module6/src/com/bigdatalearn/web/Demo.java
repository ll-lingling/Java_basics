package com.bigdatalearn.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
 * 是一个web服务器的动态资源，可以由客户端访问，还可以给客户端返回信息
 * 继承自httpservlet
 * 重写doget，dopost方法
 * 添加一个webservlet注解
 * 把项目部署到tomcat启动
 * */

@WebServlet("/Demo")
public class Demo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("UTF-8");
        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        //打印一句话表明请求已经到达服务器资源
        System.out.println("jiiehsou");
        //通过打印留给客户端返回一个hello
        resp.getWriter().println("hello.......");
    }
}
