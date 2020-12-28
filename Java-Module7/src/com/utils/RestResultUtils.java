package com.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class RestResultUtils {

    public static void restResult(HttpServletResponse resp, int code, Object data, String msg) throws IOException {
        // 设置response 的返回编码，防止乱码
        resp.setContentType("text/html;charset=utf-8");
        // response 响应体输出流
        PrintWriter out = resp.getWriter();
        Map<String, Object> result = new HashMap<>();
//        Gson gson = new Gson();  // json对象， 需要GSon.jar包
        ObjectMapper om = new ObjectMapper();

        // 消息封装进集合
        result.put("code", code);
        result.put("data", data);
        result.put("msg", msg);
        // 将集合json格式化，以便传输
        String item = om.writeValueAsString(result);
        // 响应消息
        out.print(item);
    }
}