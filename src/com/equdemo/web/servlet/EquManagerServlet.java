package com.equdemo.web.servlet;

import com.equdemo.pojo.Equipment;
import com.equdemo.service.EquManagerService;
import com.equdemo.service.impl.EquManagerServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/equManager.do")
public class EquManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if("addEqu".equals(flag)){
            this.addEqu(req,resp);
        }else if ("findEqu".equals(flag)){
            this.findEqu(req,resp);
        }else if ("preUpdate".equals(flag)){
            this.preUpdate(req,resp);
        }else if ("modifyEqu".equals(flag)){
            this.modifyEqu(req,resp);
        }else if("dropEqu".equals(flag)){
            this.dropEqu(req,resp);
        }
    }

    private void addEqu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        Equipment equipment = this.createEqu(req);
        try {
            EquManagerService equManagerService = new EquManagerServiceImpl();
            equManagerService.addEqu(equipment);
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private Equipment createEqu(HttpServletRequest req){
        String equname = req.getParameter("equname");
        String equnum = req.getParameter("equnum");
        String equtype = req.getParameter("equtype");
        String equsupplier = req.getParameter("equsupplier");
        String numofequ = req.getParameter("numofequ");
        String price = req.getParameter("price");
        String date = req.getParameter("date");
        Equipment equipment = new Equipment();
        equipment.setEquname(equname);
        equipment.setEqunum(equnum);
        equipment.setEqutype(equtype);
        equipment.setEqusupplier(equsupplier);
        equipment.setNumofequ(numofequ);
        equipment.setPrice(price);
        equipment.setDate(date);
        return equipment;
    }

    private void findEqu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Equipment equipment1 = this.createEqu(req);
        try {
            EquManagerService equManagerService = new EquManagerServiceImpl();
            List<Equipment> list = equManagerService.findEqu(equipment1);
            req.setAttribute("list",list);
            req.getRequestDispatcher("equmanager/viewEqu.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void preUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String equid = req.getParameter("equid");
        try {
            EquManagerService equManagerService = new EquManagerServiceImpl();
            Equipment equipment1 = equManagerService.findEquByEquId(Integer.parseInt(equid));
            req.setAttribute("equipment1",equipment1);
            req.getRequestDispatcher("equmanager/updateEqu.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void modifyEqu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String equid = req.getParameter("equid");
        Equipment equipment = this.createEqu(req);
        equipment.setEquid(Integer.parseInt(equid));
        try {
            EquManagerService equManagerService = new EquManagerServiceImpl();
            equManagerService.modifyEqu(equipment);
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void dropEqu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String equid = req.getParameter("equid");
        try {
            EquManagerService equManagerService = new EquManagerServiceImpl();
            equManagerService.dropEqu(Integer.parseInt(equid));
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
