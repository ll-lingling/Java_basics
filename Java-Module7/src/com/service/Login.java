package com.service;

import com.dao.DB;
import com.domain.Student;
import com.utils.ParseParamUtils;
import com.utils.RestResultUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求参数的封装处理
        Map<String, Object> param = ParseParamUtils.parseParamMapObject(req);
        // 查询用户是否存在
        Student student = DB.findByName(param);
        if(student == null){ // 不存在，则提示用户名密码不正确
            // 返回信息的包装
            RestResultUtils.restResult(resp, 0, "", "用户名/密码不正确");
        }else{// 存在，判断密码是否匹配
            // 取得密码
            String password = student.getPassword();
            if(password.equals(param.get("password"))){ // 密码匹配
                // 往session中添加信息
                HttpSession session = req.getSession();
                session.setAttribute("name", student.getName());
                session.setAttribute("password", student.getPassword());
                // 返回信息的包装
                RestResultUtils.restResult(resp, 1, "", "登录成功");
            }else{
                // 返回信息的包装
                RestResultUtils.restResult(resp, 0, "", "用户名/密码不正确");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用doGet方法
        doGet(req, resp);
    }
}