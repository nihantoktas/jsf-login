package com.bilgeadam.example.js.login;

import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter{

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        HttpSession session=((HttpServletRequest) servletRequest).getSession(false);

        String urlPath=request.getContextPath()+"/login.xhtml";

        Boolean isSession=session!=null&&session.getAttribute("kullanıcı")!=null;
        Boolean isLogin=request.getRequestURL().equals(urlPath);


        if (isSession||isLogin){
            filterChain.doFilter(request,response);
        }else {
            //response.sendRedirect(urlPath);
            filterChain.doFilter(request,response);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}
