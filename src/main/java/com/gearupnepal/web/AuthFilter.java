/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dell
 */
//@Component(value = "/admin")
@WebFilter()//(filterName = "authFilter", urlPatterns = {"/admin"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println("working...................................................data");
        HttpSession session = req.getSession(false);

        if (session != null
                && session.getAttribute("user") != null
                && session.getAttribute("user").equals("true")) {
            chain.doFilter(req, resp);
            System.out.println("if condition");
            resp.sendRedirect(req.getContextPath() + "/POS");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
            System.out.println("else condition");
          //  ServletContext.getRequestDispatcher("/faces/welcome.xhtml").forward();
            
           
        }

    }

    @Override
    public void destroy() {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
