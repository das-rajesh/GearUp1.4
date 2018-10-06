/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.Role;
import com.gearupnepal.web.entity.User;
import com.gearupnepal.web.service.UserService;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/admin/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String index(Model model) {

        long id = 0;
        User user = new User(id, "rajesh@gmail.com", "admin", true);
        HashSet<Role> roles = new HashSet<Role>();
        roles.add(new Role(id + 3, "user"));
        roles.add(new Role(id + 2, "Manager"));
        user.setRoles(roles);
        userService.save(user);
        model.addAttribute("users", userService.getAll());
        return "admin/users/index";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "admin/users/add";
    }

    @PostMapping(value = "/save")
    public String add(User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }
}
