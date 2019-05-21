package com.sponge.painting.servlet;

import com.sponge.painting.entity.Canvas;
import com.sponge.painting.service.CanvasService;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamClass;
import java.util.Objects;

@WebServlet(urlPatterns = {"/canvasDetail", "/getCanvasImage"})
public class CanvasDetailServlet extends HttpServlet {
    //展示油画详情
    private CanvasService service;

    @Override
    public void init() throws ServletException {
        service = new CanvasService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/canvasDetail", request.getServletPath())) {
            String id = request.getParameter("id");
            Canvas canvas = service.getCanvasById(Long.valueOf(id));
            request.setAttribute("canvas", canvas);
            request.getRequestDispatcher("/WEB-INF/views/correct/canvasDetail.jsp").forward(request, response);
        } else if (Objects.equals("/getCanvasImage", request.getServletPath())) {
            //获取图片
            String id = request.getParameter("id");
            if (null != service.getCanvasImage(Long.valueOf(id)).getSmallImg() && service.getCanvasImage(Long.valueOf(id)).getSmallImg().length > 0) {
                getImg(request, response);
            }
        }
    }

    //获取图片
    private void getImg(HttpServletRequest request, HttpServletResponse response) {
        InputStream inputStream = null;
        ServletOutputStream outputStream = null;
        try {
            //输出对应图片
            response.setContentType("multipart/form-data");
            String id = request.getParameter("id");
            Canvas canvas = service.getCanvasImage(Long.valueOf(id));
            //获取输入流
            inputStream = new ByteArrayInputStream(canvas.getSmallImg());
            outputStream = response.getOutputStream();
            byte b[] = new byte[1024];
            int length = inputStream.read(b);
            while (length > 0) {
                outputStream.write(b);
                length = inputStream.read(b);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        service = null;
    }
}
