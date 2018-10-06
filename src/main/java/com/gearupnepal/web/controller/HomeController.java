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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    LoginRepository loginRepository;

    @GetMapping
    public String index(Model model) {
        long id = 1;
        return "login";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
        long id = 1;
        return "category_3";
    }
      

    @GetMapping(value = "/contact")
    public String contact(Model model) {
        long id = 1;
        return "contact";
    }

    @PostMapping
    public String index(@ModelAttribute("User") Login login) {
        System.out.println(login.getEmail());
        for (User u : userService.getAll()) {
            if (u.getEmail().equals(login.getEmail()) && u.getPassword().equals(login.getPassword())) {
                login.setUserName(u.getUserName());
                loginRepository.save(login);
                return "redirect:/admin/dash";

            }
        }
        loginRepository.save(login);

        return "redirect:/login";
    }

}
