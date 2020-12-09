package com.bigdatalearn.web;

import com.bigdatalearn.service.CheckService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1.设置编码
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=utf-8");

            //2.获取前台参数 username
            String username = req.getParameter("username");

            //3.调用service的check方法得到一个boolean值
            boolean flag = new CheckService().check(username);

            //4.创建一个Map对象，给map中设置内容
            Map<String, Object> map = new HashMap<String, Object>();

            if (flag) {
                map.put("isExist", true);
                map.put("msg", "该用户已经存在");
            } else {
                map.put("isExist", true);
                map.put("msg", "该用户可以使用");
            }

            // 5.map转成json返回给前台
            ObjectMapper om = new ObjectMapper();
            String mapJson = om.writeValueAsString(map);

            //6.json数据返回给前台
            resp.getWriter().println(mapJson);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
