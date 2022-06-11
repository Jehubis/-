package com.equdemo.web.servlet;

import com.equdemo.pojo.Installation;
import com.equdemo.service.InstManagerService;
import com.equdemo.service.impl.InstManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/instManager.do")
public class InstManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if("addInst".equals(flag)){
            this.addInst(req,resp);
        }else if ("findInst".equals(flag)){
            this.findInst(req,resp);
        }else if ("preUpdate".equals(flag)){
            this.preUpdate(req,resp);
        }else if ("modifyInst".equals(flag)){
            this.modifyInst(req,resp);
        }else if("dropInst".equals(flag)){
            this.dropInst(req,resp);
        }
    }

    private void addInst(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        Installation installation = this.createInst(req);
        try {
            InstManagerService instManagerService = new InstManagerServiceImpl();
            instManagerService.addInst(installation);
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private Installation createInst(HttpServletRequest req){
        String instposition = req.getParameter("instposition");
        String instdate = req.getParameter("instdate");
        String instdirector = req.getParameter("instdirector");
        String instunit = req.getParameter("instunit");
        String inspector = req.getParameter("inspector");
        String userunit = req.getParameter("userunit");
        String equ_name = req.getParameter("equ_name");
        String equ_num = req.getParameter("equ_num");
        Installation installation = new Installation();
        installation.setInstposition(instposition);
        installation.setInstdate(instdate);
        installation.setInstdirector(instdirector);
        installation.setInstunit(instunit);
        installation.setInspector(inspector);
        installation.setEqu_name(equ_name);
        installation.setEqu_num(equ_num);
        installation.setUserunit(userunit);
        return installation;
    }

    private void findInst(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Installation installation1 = this.createInst(req);
        try {
            InstManagerService instManagerService = new InstManagerServiceImpl();
            List<Installation> list = instManagerService.findInst(installation1);
            req.setAttribute("list",list);
            req.getRequestDispatcher("instmanager/viewInst.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void preUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String instid = req.getParameter("instid");
        try {
            InstManagerService instManagerService = new InstManagerServiceImpl();
            Installation installation1 = instManagerService.findInstByInstId(Integer.parseInt(instid));
            req.setAttribute("installation1",installation1);
            req.getRequestDispatcher("instmanager/updateInst.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void modifyInst(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String instid = req.getParameter("instid");
        Installation installation = this.createInst(req);
        installation.setInstid(Integer.parseInt(instid));
        try {
            InstManagerService instManagerService = new InstManagerServiceImpl();
            instManagerService.modifyInst(installation);
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void dropInst(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String instid = req.getParameter("instid");
        try {
            InstManagerService instManagerService = new InstManagerServiceImpl();
            instManagerService.dropInst(Integer.parseInt(instid));
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
