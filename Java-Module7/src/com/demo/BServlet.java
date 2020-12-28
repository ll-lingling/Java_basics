package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/BServlet")
public class BServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        System.out.println("BServlet执行了....");
    }
}