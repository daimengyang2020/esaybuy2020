package com.buy.web;

import com.buy.entity.EasybuyProductCategory;
import com.buy.entity.EasybuyUser;
import com.buy.service.product.IproductCategoryService;
import com.buy.service.product.ProductCategoryServiceimpl;

import javax.ejb.HomeHandle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="HomeServlet",urlPatterns = {"/home"})
public class HomServlet extends AbstarctServlet{
    IproductCategoryService iproductCategoryService;
    @Override
    public void init() throws ServletException {
      iproductCategoryService=new ProductCategoryServiceimpl();
    }
    public String index(HttpServletRequest request, HttpServletResponse response){
       // 从service层获取数据
       IproductCategoryService iproductCategoryService=new ProductCategoryServiceimpl();
       List<EasybuyProductCategory> categorylist=iproductCategoryService.queryAllProductCategory("0");
        //存取数据
        request.setAttribute("categorgList",categorylist);
        //页面跳转
        return "/front/home";
    }

    @Override
    public Class getServletClass() {
        return HomServlet.class;
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        String opr= request.getParameter("opr");
//        if (opr.equals("sel")){
//            sel(request,response);
//        }else if (opr.equals("del")){
//            del(request,response);
//        }else if (opr.equals("add")){
//            add(request,response);
//        }else if (opr.equals("login")){
//            Login(request,response);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }

//    protected void sel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        List<EasybuyProductCategory> list=iproductCategoryService.queryAllProductCategory("0");
////        request.setAttribute("list",list);
////        request.getRequestDispatcher("/front/home.jsp").forward(request,response);
////    }
////    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String id=request.getParameter("id");
////        int id_1= Integer.parseInt(id);
////        PrintWriter out=response.getWriter();
////        response.setContentType("text/html;charset=utf-8");
////        if (iproductCategoryService.delete(id_1)) {
////            out.print("<script type='text/javascript'>alert('删除成功')</script>");
////            sel(request,response);
////        }else {
////            out.print("<script type='text/javascript'>alert('删除失败')</script>");
////        }
////    }
////    protected void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String name=request.getParameter("l_user");
////        String pwd=request.getParameter("1_pwd");
////        iproductCategoryService=new ProductCategoryServiceimpl();
////        if (iproductCategoryService.login(name,pwd)) {
////            response.sendRedirect( request.getContextPath()+"/front/home.jsp");//成功跳转到主页
////        }else {
////            response.sendRedirect( request.getContextPath()+"/front/login.jsp");//失败回到登录
////        }
////    }
////    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String userName=request.getParameter("l_user");
////        String pwd=request.getParameter("l_pwd");
////        String newPwd=request.getParameter("l_pwd_1");
////        String email=request.getParameter("l_email");
////        String phone=request.getParameter("l_tel");
////        EasybuyUser eu=new EasybuyUser();
////        eu.setLoginname("死值k");//这里每次注册 不允许重复，不然报错
////        eu.setUsername(userName);
////        eu.setPassword(pwd);
////        eu.setEmail(email);
////        eu.setMobile(phone);
////        eu.setSex(1);//默认男
////        PrintWriter out=response.getWriter();
////        response.setContentType("text/html;charset=utf-8");
////        if (pwd.equals(newPwd)){
////            iproductCategoryService=new ProductCategoryServiceimpl();
////            if (iproductCategoryService.add(eu)) {
////                response.sendRedirect( request.getContextPath()+"/front/login.jsp");//注册成功
////                return;
////            }else {
////                response.sendRedirect(request.getContextPath()+"/front/Regist.jsp");//注册失败
////                return;
////            }
////        }else {
////            response.sendRedirect(request.getContextPath()+"/front/Regist.jsp");//两次密码不一致
////            return;
////        }
////    }
}