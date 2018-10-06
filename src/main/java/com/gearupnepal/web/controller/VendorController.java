/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.Vendor;
import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.Role;
import com.gearupnepal.web.entity.repository.VendorRepository;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.VendorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping(value = "/vendor")
public class VendorController {

    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    VendorService vendorService;
    @Autowired
    LoginRepository loginRepository;

    @GetMapping
    public String index(Model model) {
        long id = 1;
        List<Vendor> vendors = vendorRepository.findAll();
        model.addAttribute("vendors", vendorService.getAll());
        return "vendor";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "admin/vendors/add";
    }

    @PostMapping
    public String index(@ModelAttribute("Vendor") Vendor vendor) {
        List<Login> logins = loginRepository.findAll();
        vendor.setCreatedBy(logins.get(logins.size() - 1).getUserName());
        System.out.println("saving");
        vendorRepository.save(vendor);
        return "redirect:/vendor";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id) {
        System.out.println("deleted");

        vendorRepository.deleteById(id);
        System.out.println("deleted");
        return "redirect:/vendor";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        System.out.println("editingedasdsssssssssa");
        model.addAttribute("vendor", vendorRepository.findById(id));
        return "index";
    }

}
