/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Category;
import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.Role;
import com.gearupnepal.web.entity.repository.CategoryRepository;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    LoginRepository loginRepository;

    @GetMapping
    public String index(Model model) {
        long id = 1;
        model.addAttribute("categories", categoryService.getAll());
        List<Category> categories = categoryService.getAll();
        System.out.println(categories.get(0).getName());

        return "category_3";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "admin/categorys/add";
    }

    @PostMapping
    public String index(@ModelAttribute("Category") Category category,Model model) {
        List<Login> logins = loginRepository.findAll();
        category.setCreatedBy(logins.get(logins.size() - 1).getUserName());
           model.addAttribute("categories", categoryService.getAll());
     
        System.out.println("saving");
        categoryService.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
                System.out.println("deleted");

        categoryService.delete(id);
        System.out.println("deleted");
        return "redirect:/admin/category";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
           System.out.println("editingedasdsssssssssa");
        model.addAttribute("category", categoryService.findById(id));
        return "editcategory";
    }

}
