package com.itmk.set_course.bll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//setCourse.do的请求都会在这里被处理
@WebServlet("/setCourse.do")
public class setCourseServlet extends HttpServlet {
    private static final String PREX="WEB-INF/jsp/admin";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        if (method.equals("setCourseUI")){
            setCourseUI(req,resp);
        }
    }

    /**
     * 跳转到授课管理页面
     * @param req
     * @param resp
     */
    private void setCourseUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PREX+"/setCourse.jsp").forward(req,resp);
    }
}
