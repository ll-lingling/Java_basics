package com.service;


import com.dao.DB;

import com.utils.ParseParamUtils;
import com.utils.RestResultUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class DeleteStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 对请求参数进行一定封装处理
        Map<String, Object> param = ParseParamUtils.parseParamMapObject(req);
        // 根据用户id删除用户
        int num = DB.deleteById(param);
        if (num == 0) {
            // 返回信息的包装
            RestResultUtils.restResult(resp, 0, "", "删除失败");
        } else {
            // 返回信息的包装
            RestResultUtils.restResult(resp, 1, "", "删除成功");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用doGet方法
        doGet(req, resp);
    }
}