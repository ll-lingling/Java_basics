package com.filter;


import com.utils.RestResultUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class AddFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 取得session空间， 判断是否有内容
        HttpSession session = request.getSession();
        Object name = session.getAttribute("name");
        // 拦截 验证
        if(null == name){ // session 空间无登录信息，提示用户登录
            RestResultUtils.restResult(response, 3, "", "未登录，请重新登录!");
            return;
        }
        // 符合要求 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}