package com.sponge.painting.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/loginPage")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //跳转到登录界面
        req.getRequestDispatcher("/WEB-INF/views/correct/login.jsp").forward(req,resp);
    }
}
