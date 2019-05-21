package com.sponge.painting.filter;

import javax.servlet.*;
import java.io.IOException;
//字符编码过滤器
public class CharsetEncodingFilter implements Filter {
    private String charset;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charset=filterConfig.getInitParameter("Charset");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(charset);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
