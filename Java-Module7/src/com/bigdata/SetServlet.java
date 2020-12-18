package com.bigdata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SetServlet")
public class SetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建cookie对象，设置数据
        Cookie cookie = new Cookie("name", "jack");
        // 2.通过response，响应（返回）cookie
        response.addCookie(cookie);
    }
}
