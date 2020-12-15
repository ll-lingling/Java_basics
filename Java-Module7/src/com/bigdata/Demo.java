package com.bigdata;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(value = "/CountServlet", loadOnStartup = 4) // 服务器启动时，创建此servlet对象
public class Demo extends HttpServlet {
    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("count", 0);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置response响应编码
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>拉勾网站</h1>");
        // 用户每次访问，从域中取出，加1，再存进去
        ServletContext servletContext = request.getServletContext();
        // 从域中取出
        Integer count = (Integer) servletContext.getAttribute("count");
        // 加1
        count++;
        // 再存进去
        servletContext.setAttribute("count", count);
        response.getWriter().write("<div>你是，第" + count + "位访问此网站... </div>");
    }
}