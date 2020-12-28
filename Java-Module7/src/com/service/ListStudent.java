package com.service;

import com.dao.DB;
import com.domain.Student;
import com.utils.RestResultUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class ListStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 用户列表信息
        List<Student> students = DB.findAll();

        if(null == students){
            // 返回信息的包装
            RestResultUtils.restResult(resp, 1, new ArrayList<>(), "查询无结果");
        }else{
            // 返回信息的包装
            RestResultUtils.restResult(resp, 1, students, "success");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}