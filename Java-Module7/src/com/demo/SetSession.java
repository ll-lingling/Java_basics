package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SetSession")
public class SetSession extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.通过rquest对象，获取session对象
        HttpSession session = request.getSession();
        // 2.操作session的API，存储数据
        session.setAttribute("username", "哈哈，呵呵");
    }
}
