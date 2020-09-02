package com.ls.filter;


import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

public class MyFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("myfilter process....");
//        chain.doFilter(request,response);
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myfilter process....");
        chain.doFilter(request,response);
    }
}
