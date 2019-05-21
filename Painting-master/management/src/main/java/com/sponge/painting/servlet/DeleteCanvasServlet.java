package com.sponge.painting.servlet;

import com.sponge.painting.entity.Canvas;
import com.sponge.painting.service.CanvasService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除油画
 */
@WebServlet("/deleteCanvas")
public class DeleteCanvasServlet extends HttpServlet {
    private CanvasService service;
    @Override
    public void init() throws ServletException {
        service=new CanvasService();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        service.deleteCanvas(Long.valueOf(id));
        request.getRequestDispatcher("/index").forward(request,response);
    }

    @Override
    public void destroy() {
        service=null;
    }
}
