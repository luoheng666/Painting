package com.sponge.painting.servlet;

import com.sponge.painting.entity.Canvas;
import com.sponge.painting.service.CanvasService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/addCanvas")
public class AddCanvasServlet extends HttpServlet {
    private CanvasService service;
    @Override
    public void init() throws ServletException {
        service=new CanvasService();
    }

    //添加油画作品
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //添加蛋糕
        System.out.println("正在初始化**********");
        try {
            request.setCharacterEncoding("utf-8");
            Canvas canvas=new Canvas();
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload fileUpload=new ServletFileUpload(factory);
            List<FileItem> fileItems=fileUpload.parseRequest(request);
            for(FileItem item:fileItems)
            {
                if(item.isFormField())
                {
                    //普通表单项
                    String name=item.getFieldName();
                    String value=item.getString("utf-8");
                    if(name.equals("name"))
                    {
                        canvas.setName(value);
                    }else if(name.equals("creator"))
                    {
                        canvas.setCreator(value);
                    }else if(name.equals("categoryId"))
                    {
                        canvas.setCategoryId(Long.valueOf(value));
                    }else if(name.equals("price"))
                    {
                        canvas.setPrice(Integer.parseInt(value));
                    }else if(name.equals("description"))
                    {
                        canvas.setDescription(value);
                    }else if(name.equals("detail"))
                    {
                        canvas.setDetail(value);
                    }
                }else{
                    //文件项
                    canvas.setSmallImg(item.get());
                }
            }
            System.out.println(canvas);
            //添加油画
            service.addCanvas(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/index");
    }

    @Override
    public void destroy() {
        service=null;
    }
}
