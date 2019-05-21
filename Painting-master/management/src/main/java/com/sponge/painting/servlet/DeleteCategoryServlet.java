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
@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {
    private CategoryService service;
    @Override
    public void init(){
        service=new CategoryService();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        service.deleteCategory(Long.valueOf(id));
        List<Category>categories=service.getCategories();
        request.getSession().setAttribute("categories",categories);
        request.getRequestDispatcher("/showCategory").forward(request,response);
    }

    @Override
    public void destroy() {
        service=null;
    }
}
