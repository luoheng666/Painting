package com.sponge.painting.servlet;

import com.sponge.painting.entity.Category;
import com.sponge.painting.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/showCategory")
public class CategoryPageServlet extends HttpServlet {
    private CategoryService service;
    private List<Category> categories;
    @Override
    public void init() throws ServletException {
        service=new CategoryService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //跳转到添加分类界面
        categories=service.getCategories();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/WEB-INF/views/correct/showCategory.jsp").forward(request,response);
    }

    @Override
    public void destroy() {
        service=null;
    }
}
