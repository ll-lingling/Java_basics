package com.utils;


import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ParseParamUtils {

    // 请求参数二次封装
    public static Map<String, Object> parseParamMapObject(HttpServletRequest request) {
        Map<String, String> map = parseParamMap(request);
        Map<String, Object> map2 = new HashMap(map);
        return map2;
    }

    // 请求参数一次封装
    public static Map<String, String> parseParamMap(HttpServletRequest request) {
        // 申明一个集合
        Map<String, String> map = new HashMap();
        // 参数处理
        if (null != request) { // 请求不为空
            // 取得请求参数的所有参数名
            Enumeration enumeration = request.getParameterNames();

            while (true) {
                String paraName;  // 参数名
                String paraValue;  // 参数值
                // 请求参数无下一个 则返回集合
                if (!enumeration.hasMoreElements()) {
                    return map;
                }
                // 获取参数名
                paraName = (String) enumeration.nextElement();
                // 获取参数值
                paraValue = request.getParameter(paraName);
                if (null != paraValue) { // 参数值不为空
                    paraValue = paraValue.trim();  // 去空格
                }
                // 参数如果不为空，但为字符串null 或 undefind，设为对象null
                // sql中不能带null 和 undefined
                if ("null".equals(paraValue) || "undefined".equals(paraValue)) {
                    paraValue = null;
                }
                // 参数值为空字符串的处理
                if (paraValue == "") {
                    paraValue = null;
                }
                // 将参数名和参数值放入集合
                map.put(paraName, paraValue);
            }
        } else {
            return map;
        }
    }
}