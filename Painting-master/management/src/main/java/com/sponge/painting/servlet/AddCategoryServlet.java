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
import java.util.Objects;

@WebServlet(urlPatterns = {"/addCategoryPage","/addCategory"})
public class AddCategoryServlet extends HttpServlet {
    private CategoryService service;
    private List<Category> categories;
    @Override
    public void init() throws ServletException {
        service=new CategoryService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Objects.equals("/addCategoryPage",request.getServletPath()))
        {
            //跳转添加分类页面
            request.getRequestDispatcher("/WEB-INF/views/correct/addCategory.jsp").forward(request,response);
        }else if(Objects.equals("/addCategory",request.getServletPath()))
        {
            //添加分类
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            String name=request.getParameter("name");
            String description=request.getParameter("description");
            if(null!=name&&null!=description&&!"".equals(name)&&!"".equals(description))
            {
                categories=service.getCategories();
                boolean flag=false;
                for(Category category:categories)
                {
                    if(name.equals(category.getName()))
                    {
                        flag=true;
                    }
                }
                if(!flag)
                {
                    //添加分类
                    Category category=new Category();
                    category.setName(name);
                    category.setDescription(description);
                    service.addCategory(category);
                    request.getSession().setAttribute("categories",service.getCategories());
                    request.setAttribute("addCategoryError","0");
                }else {
                    request.setAttribute("addCategoryError","1");
                }
            }
            request.getRequestDispatcher("/showCategory").forward(request,response);
        }
    }

    @Override
    public void destroy() {
        service=null;
    }
}
