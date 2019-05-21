package com.sponge.painting.servlet;

import com.sponge.painting.entity.Canvas;
import com.sponge.painting.entity.Category;
import com.sponge.painting.service.CanvasService;
import com.sponge.painting.service.CategoryService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private CanvasService service;
    private CategoryService categoryService;
    private List<Canvas> canvas;
    private Logger logger=Logger.getLogger("IndexServlet");
    private List<Category> categories;
    @Override
    public void init() throws ServletException {
        service=new CanvasService();
        categoryService=new CategoryService();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据分页获取数据
        int page=1;
        int count=service.getCanvasCount();
        int pages=(count+4)/5;
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
                logger.debug("page=**************************"+page);
            }else if(get.equals("last"))
            {
                //尾页
                page=pages;
            }
        }
        canvas=service.getCanvasByPage(page,5);
        request.setAttribute("page",page);
        if(null!=canvas&&canvas.size()>0)
        {
            request.setAttribute("canvas",canvas);
        }

        //获取目录
        categories=categoryService.getCategories();
        if(null!=categories)
        {
            request.getSession().setAttribute("categories",categories);
        }
        //跳转到主页
        request.getRequestDispatcher("/WEB-INF/views/correct/index.jsp").forward(request,response);
    }

    @Override
    public void destroy() {
        service=null;
        categoryService=null;
    }

}
