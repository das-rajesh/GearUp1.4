/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Role;
import com.gearupnepal.web.entity.User;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/reset")
public class FoegetPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    LoginRepository loginRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("role", getRole());
        return "resetpassword";

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {

        return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id) {
        return "redirect:/";
    }

    @PostMapping
    public String index(@ModelAttribute("User") User user) {
        Set<Role> roles = new HashSet<>();
        long id = 1;
//        roles.add(new Role(id, "Admin"));
//        user.setRoles(roles);
//        user.setStatus(true);
        for (User u : userService.getAll()) {
            if (u.getEmail().equals(user.getEmail()) && u.getFavGame().equals(user.getFavGame())) {
                return "succeskeyreset";

            }
        }
        //    userService.save(user);
        return "redirect:/login";
    }

    public String getRole() {
        String role = loginRepository.findById((long) loginRepository.findAll().size()).get().getRole();
        return role;
    }
}
