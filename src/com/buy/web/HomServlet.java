package com.buy.web;

import com.buy.entity.EasybuyProductCategory;
import com.buy.service.product.IproductCategoryService;
import com.buy.service.product.ProductCategoryServiceimpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="HomeServlet",urlPatterns = {"/home"})
public class HomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从service层获取数据
        IproductCategoryService iproductCategoryService=new ProductCategoryServiceimpl();
        List<EasybuyProductCategory> list=iproductCategoryService.queryAllProductCategory("0");
        //存取数据
        request.setAttribute("categorgList",list);
        request.getRequestDispatcher("/front/home.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
