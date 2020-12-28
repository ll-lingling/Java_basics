package com.service;

import com.dao.DB;
import com.domain.Student;
import com.utils.ParseParamUtils;
import com.utils.RestResultUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;


public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求参数的封装处理
        Map<String, Object> paramMap = ParseParamUtils.parseParamMapObject(req);
        // 查询用户名是否已存在
        Student student = DB.findByName(paramMap);
        if (student != null) { // 存在，则提示用户名已存在
            // 返回信息的包装
            RestResultUtils.restResult(resp, 0, "", "当前用户已存在");
            return;
        }
        // 添加学生信息
        int num = DB.add(paramMap);
        if (num == 0) { // 注册成功0条即注册失败
            // 返回信息的包装
            RestResultUtils.restResult(resp, 0, "", "注册失败");

        } else {
            // 返回信息的包装
            RestResultUtils.restResult(resp, 1, "", "注册成功");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用doGet方法
        doGet(req, resp);
    }
}