package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.通过request对象，接收cookie数组
        Cookie[] cookies = request.getCookies();
        // 2.遍历数组
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName();
                String value = c.getValue();
                // 解码
                value = URLDecoder.decode(value, "UTF-8");
                System.out.println(name + " : " + value);
            }
        }
    }
}