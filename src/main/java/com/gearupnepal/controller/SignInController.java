/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Role;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/signin")
public class SignInController {

    @GetMapping
    public String index(Model model) {

        return "signin";
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");

        if (userName.equals("admin") && passWord.equals("admin")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", "true");
            response.sendRedirect(request.getContextPath() + "/admin/dashboard");
            System.out.println("matched***************************************************************************");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?error");

        }
    }

}
