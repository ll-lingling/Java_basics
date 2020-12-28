package com.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/EncodeCookie")
public class EncodeCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = "华为荣耀 30X,";
        product = URLEncoder.encode(product, "UTF-8");
        // 1.创建cookie对象
        Cookie cookie = new Cookie("product", product);
        // 2.response响应cookie
        response.addCookie(cookie);
    }
}