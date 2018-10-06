/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.User;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/logout")
public class LogOutController {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserService userService;

    @GetMapping
    public String index(HttpServletRequest request,
            HttpServletResponse response, Model model)
            throws ServletException, IOException {
        long id = 1;
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }
        // response.sendRedirect(request.getContextPath() + "/login");
        return "redirect:/login";
    }

}
