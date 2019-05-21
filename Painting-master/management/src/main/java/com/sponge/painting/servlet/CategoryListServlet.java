package com.sponge.painting.servlet;

import com.sponge.painting.entity.Canvas;
import com.sponge.painting.service.CanvasService;
import com.sponge.painting.service.CategoryService;

import javax.print.attribute.standard.NumberUp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//根据目录id来获取油画
@WebServlet("/categoryList")
public class CategoryListServlet extends HttpServlet {
    private CanvasService service;
    private CategoryService categoryService;
    private List<Canvas> canvas;
    @Override
    public void init() throws ServletException {
        service=new CanvasService();
        categoryService=new CategoryService();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId=request.getParameter("categoryId");
        canvas=service.getCanvasByCategoryId(Long.valueOf(categoryId));
        String categoryName=categoryService.getCategoryById(Long.valueOf(categoryId)).getName();
        int count=service.getCanvasCountByCategoryId(Long.valueOf(categoryId));
        int page=1;
        int pages=(count+1)/2;
        String get=request.getParameter("get");
        if(null!=get)
        {
            page= Integer.parseInt(request.getParameter("page"));
            if(get.equals("first"))
            {
                //首页
                page=1;
            }else if(get.equals("prev"))
            {
                //前一页
                if(page==1)
                {
                    page=1;
                }else {
                    page=page-1;
                }
            }else if(get.equals("next"))
            {
                //下一页
                if(page==pages)
                {
                    page=pages;
                }else {
                    page=page+1;
                }
            }else if(get.equals("last"))
            {
                //尾页
                page=pages;
            }
        }
        canvas=service.getCanvasByPageAndCategoryId(Long.valueOf(categoryId),page,2);
        request.setAttribute("page",page);
        request.setAttribute("categoryId",categoryId);
        if(null!=canvas&&canvas.size()>0)
        {
            request.setAttribute("canvas",canvas);
        }
        request.setAttribute("categoryName",categoryName);
        request.getRequestDispatcher("/WEB-INF/views/correct/canvasByCategoryId.jsp").forward(request,response);
    }

    @Override
    public void destroy() {
        service=null;
        categoryService=null;
    }
}
