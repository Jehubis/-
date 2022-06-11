package com.equdemo.web.servlet;


import com.equdemo.pojo.Overhaul;
import com.equdemo.service.OvhManagerService;
import com.equdemo.service.impl.OvhManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/ovhManager.do")
public class OvhManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if("addOvh".equals(flag)){
            this.addOvh(req,resp);
        }else if ("findOvh".equals(flag)){
            this.findOvh(req,resp);
        }else if ("preUpdate".equals(flag)){
            this.preUpdate(req,resp);
        }else if ("modifyOvh".equals(flag)){
            this.modifyOvh(req,resp);
        }else if("dropOvh".equals(flag)){
            this.dropOvh(req,resp);
        }
    }

    private void addOvh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        Overhaul overhaul = this.createOvh(req);
        try {
            OvhManagerService ovhManagerService = new OvhManagerServiceImpl();
            ovhManagerService.addOvh(overhaul);
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private Overhaul createOvh(HttpServletRequest req){
        String repairman = req.getParameter("repairman");
        String phonenumber = req.getParameter("phonenumber");
        String ovhresult = req.getParameter("ovhresult");
        String remarks = req.getParameter("remarks");
        String ovhdate = req.getParameter("ovhdate");
        String equ_num = req.getParameter("equ_num");
        String equ_name = req.getParameter("equ_name");
        String equ_type = req.getParameter("equ_type");
        Overhaul overhaul = new Overhaul();
        overhaul.setRepairman(repairman);
        overhaul.setPhonenumber(phonenumber);
        overhaul.setOvhresult(ovhresult);
        overhaul.setRemarks(remarks);
        overhaul.setOvhdate(ovhdate);
        overhaul.setEqu_num(equ_num);
        overhaul.setEqu_name(equ_name);
        overhaul.setEqu_type(equ_type);
        return overhaul;
    }

    private void findOvh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Overhaul overhaul1 = this.createOvh(req);
        try {
            OvhManagerService ovhManagerService = new OvhManagerServiceImpl();
            List<Overhaul> list = ovhManagerService.findOvh(overhaul1);
            req.setAttribute("list",list);
            req.getRequestDispatcher("ovhmanager/viewOvh.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void preUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String ovhid = req.getParameter("ovhid");
        try {
            OvhManagerService ovhManagerService = new OvhManagerServiceImpl();
            Overhaul overhaul1 = ovhManagerService.findOvhByOvhId(Integer.parseInt(ovhid));
            req.setAttribute("overhaul1",overhaul1);
            req.getRequestDispatcher("ovhmanager/updateOvh.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void modifyOvh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String ovhid = req.getParameter("ovhid");
        Overhaul overhaul = this.createOvh(req);
        overhaul.setOvhid(Integer.parseInt(ovhid));
        try {
            OvhManagerService ovhManagerService = new OvhManagerServiceImpl();
            ovhManagerService.modifyOvh(overhaul);
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }

    private void dropOvh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String ovhid = req.getParameter("ovhid");
        try {
            OvhManagerService ovhManagerService = new OvhManagerServiceImpl();
            ovhManagerService.dropOvh(Integer.parseInt(ovhid));
            resp.sendRedirect("ok.jsp");
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
