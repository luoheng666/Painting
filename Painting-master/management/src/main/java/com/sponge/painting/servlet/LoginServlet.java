package com.sponge.painting.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//登录功能的完善
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //处理登录逻辑
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
		//是否记住密码功能
        String remember=request.getParameter("remember");
        if(null!=username&&!username.equals("")&&username.equals(password))
        {
            //登录成功
            if(remember!=null)
            {
                //记住密码操作
                Cookie cookie1=new Cookie("username",username);
                Cookie cookie2=new Cookie("password",password);
                cookie1.setMaxAge(15*24*3600);
                cookie2.setMaxAge(15*24*3600);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }else {
                //清除cookie
                Cookie[] cookies = request.getCookies();
                for(Cookie cookie:cookies)
                {
                    if(cookie.getName().equals("username")||cookie.getName().equals("password"))
                    {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
            request.getSession().setAttribute("username",username);
            request.getRequestDispatcher("/index").forward(request,response);
        }else {
            //登录失败
            request.setAttribute("loginError","1");
            request.getRequestDispatcher("/loginPage").forward(request,response);
        }
    }


    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
	
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
