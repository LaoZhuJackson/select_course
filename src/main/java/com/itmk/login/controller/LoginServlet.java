package com.itmk.login.controller;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录控制器，处理登录模块的请求
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        if (method.equals("login")){
            login(req, resp);
        }else if (method.equals("adminHomeUI")){
            adminHomeUI(req, resp);
        }else if (method.equals("adminWelcome")){
            adminWelcome(req, resp);
        }
    }

    /**
     * 登录：通过JSON传输数据，返回JSON数据
     * @param req
     * @param resp
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置请求头,返回JSON数据
        resp.setContentType ("application/json;charset=UTF-8");
        //查询数据库

        //构造返回的数据格式
        JSONObject object=new JSONObject();
        object.put("code",200);//返回成功的状态码 200
        object.put("msg","登录成功！");
        //把数据写回前端
        PrintWriter writer = resp.getWriter();
        writer.print(object.toJSONString());//转换成JSON字符串
    }

    /**
     * 返回首页页面
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void adminHomeUI(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        req.getRequestDispatcher("WEB-INF/jsp/home/admin_home.jsp").forward(req,resp);
    }
    /**
     * 返回欢迎页面
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void adminWelcome(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        req.getRequestDispatcher("WEB-INF/jsp/home/admin_welcome.jsp").forward(req,resp);
    }
}
