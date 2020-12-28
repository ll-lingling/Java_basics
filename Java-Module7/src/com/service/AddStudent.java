package com.service;


import com.dao.DB;
import com.domain.Student;
import com.utils.ParseParamUtils;
import com.utils.RestResultUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class AddStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 对请求参数进行一定的封装处理
        Map<String, Object> paramMap = ParseParamUtils.parseParamMapObject(req);
        // 查询是否用户已存在
        Student student = DB.findByName(paramMap);
        if (student != null) {
            // 返回信息的包装
            RestResultUtils.restResult(resp, 0, "", "当前用户已存在");
            return;
        }
        // 添加用户信息到数据库
        int num = DB.add(paramMap);
        if (num == 0) {
            // 返回信息的包装
            RestResultUtils.restResult(resp, 0, "", "添加学生失败");
        } else {
            // 返回信息的包装
            RestResultUtils.restResult(resp, 1, "", "添加学生成功");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用doGet方法
        doGet(req, resp);
    }

}