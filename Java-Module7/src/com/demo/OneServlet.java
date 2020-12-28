package com.demo;

import javax.servlet.*;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 向servletContext域存数据....
        ServletContext sc1 = request.getServletContext();
        ServletContext sc2 = getServletContext();
        sc1.setAttribute("user", "jack");
        System.out.println("OneServlet存了数据。。。");
    }
}