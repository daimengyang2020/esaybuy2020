package com.buy.web;

import com.buy.utils.EmptyUtils;
import com.buy.utils.PrintUtil;
import com.buy.utils.ReturnResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "AbstarctServlet")
public abstract class AbstarctServlet extends HttpServlet {
    //用来获取Servlet对象实例
    public abstract Class getServletClass();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String action=request.getParameter("action");
        Method method=null;
        Object result=null;
        //根据action参数来决定页面的跳转情况
            try {
                //根据action参数来决定页面的跳转情况
                if (EmptyUtils.isEmpty(action)) {
                    //如果参数为空，跳转的首页
                    result=execute(response,request);
                } else {
                    //有参数的处理方式
                    method = getServletClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
                    result = method.invoke(this, request, response);
                }
                toViem(request,response,result);
            } catch (NoSuchMethodException e) {
                String viemName="404.jsp";
                request.getRequestDispatcher(viemName).forward(request,response);
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                if(!EmptyUtils.isEmpty(result)){
                    if(result instanceof String){
                        String viemName="500.jsp";
                        request.getRequestDispatcher(viemName).forward(request,response);
                    }else {
                        ReturnResult returnResult=new ReturnResult();
                        returnResult.returnFail("系统错误");
                        PrintUtil.write(returnResult,response);
                    }
                }else {
                    String viemName="500.jsp";
                    request.getRequestDispatcher(viemName).forward(request,response);
                }
                e.printStackTrace();
            }
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
    /*
     *根据Servlet调用方法返回的结果，决定下一步是返回jsp页面还是打印json数据
     */
    protected void toViem(HttpServletRequest request,HttpServletResponse response,Object result) throws ServletException, IOException {
        if(!EmptyUtils.isEmpty(result)){
            //判断result是不是json数据，如果不是则加上后缀jsp
           if(result instanceof String ){
               String viemName=result.toString()+".jsp";
               request.getRequestDispatcher(viemName).forward(request,response);
           }else {
               //返回的json数据
               PrintUtil.write(result,response);
           }
        }
    }
    public Object execute(HttpServletResponse response,HttpServletRequest request){
        return "/front/home";
    }
}
