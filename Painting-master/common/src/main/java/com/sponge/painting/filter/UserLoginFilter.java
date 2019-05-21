package com.sponge.painting.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        if(null!=request.getSession().getAttribute("username")|| Objects.equals(request.getServletPath(),"/login")||Objects.equals(request.getServletPath(),"/loginPage"))
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            /**
             * 过滤页面,管理员未登录不可操作
             *  /addCanvasPage
             *   /addCanvas
             *   /addCategoryPage","/addCategory"
             *   /deleteCanvas
             *   /deleteCanvas
             */

            if(Objects.equals(request.getServletPath(),"/addCanvasPage")
            || Objects.equals(request.getServletPath(),"/addCanvas")
                    || Objects.equals(request.getServletPath(),"/addCategoryPage")
                    || Objects.equals(request.getServletPath(),"/addCategory")
                    || Objects.equals(request.getServletPath(),"/deleteCanvas")
                    || Objects.equals(request.getServletPath(),"/deleteCanvas"))
            {
                request.setAttribute("noLogin","1");
                request.getRequestDispatcher("/loginPage").forward(request,response);
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
