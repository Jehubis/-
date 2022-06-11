package com.equdemo.web.filter;

import com.equdemo.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 判断当前客户端浏览器是否登录的Filter
 */
@WebFilter(urlPatterns = {"*.do","*.jsp"})
public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        //判断当前请求的是否为login.jsp或者login.do,如果请求的是用户登录的资源那么需要放行
        if (uri.indexOf("login.jsp") != -1 || uri.indexOf("login.do") != -1 || uri.indexOf("validateCode.do") != -1) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            Users users = (Users)session.getAttribute("users");
            if (users != null){
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                request.setAttribute("msg","请先登录");
                request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
            }
        }
    }
    @Override
    public void destroy() {

    }
}
