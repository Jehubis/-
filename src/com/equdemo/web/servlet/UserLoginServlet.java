package com.equdemo.web.servlet;

import com.equdemo.exception.UserNotFoundException;
import com.equdemo.pojo.Users;
import com.equdemo.service.UserLoginService;
import com.equdemo.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login.do")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        String userpower = req.getParameter("userpower");
        String code = req.getParameter("code");
        try {
            HttpSession session = req.getSession();
            String codeTemp = (String)session.getAttribute("code");
            if(codeTemp.equals(code)){
                UserLoginService userLoginService = new UserLoginServiceImpl();
                Users users = userLoginService.userLogin(username, userpwd,userpower);
                //建立客户端与服务端会话状态

                session.setAttribute("users",users);
                ServletContext servletContext = this.getServletContext();
                HttpSession temp = (HttpSession)servletContext.getAttribute(users.getUserid()+"");
                if(temp != null){
                    servletContext.removeAttribute(users.getUserid()+"");
                    temp.invalidate();
                }
                servletContext.setAttribute(users.getUserid()+"",session);
                //使用重定向方式跳转到首页
                if(userpower.equals("0")){
                    resp.sendRedirect("main.jsp");
                }else if(userpower.equals("1")){
                    resp.sendRedirect("main1.jsp");
                }

            }else {
                req.setAttribute("msg","验证码有误,请重新输入!");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        }catch(UserNotFoundException e){
            req.setAttribute("msg",e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }

    }
}
