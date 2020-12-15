package com.bigdata;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        System.out.println("AServlet执行了....");
        /* // 1.设置状态码
        response.setStatus(302);
        // 2.设置响应头 Location
        response.setHeader("Location","/day10_response/BServlet");*/
        // 1.response这哥们封装专门处理重定向的方法
        response.sendRedirect("http://www.itcast.cn");
    }
}