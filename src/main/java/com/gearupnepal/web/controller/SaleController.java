/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.Category;
import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/sale")
public class SaleController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    LoginRepository loginRepository;
    
    @Autowired
    SaleService saleService;

    @GetMapping
    public String index(Model model) {
        long id = 1;
        model.addAttribute("sales", saleService.getAll());
        
        return "sell";
    }


}
