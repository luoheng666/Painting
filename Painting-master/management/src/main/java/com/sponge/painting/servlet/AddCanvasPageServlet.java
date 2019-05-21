package com.sponge.painting.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addCanvasPage")
public class AddCanvasPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //跳转到添加油画页面
        request.getRequestDispatcher("/WEB-INF/views/correct/addCanvas.jsp").forward(request,response);
    }
}
