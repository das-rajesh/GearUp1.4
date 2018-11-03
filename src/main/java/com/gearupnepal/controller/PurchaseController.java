/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Category;
import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.Purchase;
import com.gearupnepal.web.entity.Role;
import com.gearupnepal.web.entity.TempChild;
import com.gearupnepal.web.entity.repository.CategoryRepository;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.ChildSubcategoryService;
import com.gearupnepal.web.service.PurchaseService;
import com.gearupnepal.web.service.SubCategoryService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
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
@RequestMapping(value = {"/admin/purchase", "user/purchase"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class PurchaseController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    ChildSubcategoryService childSubcategoryService;

    List<TempChild> tempChilds = new ArrayList<>();

    @Autowired
    PurchaseService purchaseService;

    @GetMapping
    public String index(Model model) {
        long id = 1;
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getAll());
        model.addAttribute("childSubCategories", childSubcategoryService.getAll());
        List<Category> categories = categoryService.getAll();
        model.addAttribute("purchases", purchaseService.getAll());
        System.out.println(categories.get(0).getName());
          System.out.println("");
          List<Purchase> purchases=purchaseService.getAll();
          System.out.println(purchases.get(0).getCategory());
          for(Purchase p:purchaseService.getAll()){
              System.out.println(p.getChildsubcategory());
          }
        return "purchase";
    }

    @GetMapping(value = "/add")
    public String add() {
        return "admin/categorys/add";
    }

    @PostMapping
    public String index(@ModelAttribute("Category") Category category) {
        List<Login> logins = loginRepository.findAll();
        category.setCreatedBy(logins.get(logins.size() - 1).getUserName());
        System.out.println("saving");
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        System.out.println("deleted");

        categoryService.delete(id);
        System.out.println("deleted");
        return "redirect:/category";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        System.out.println("editingedasdsssssssssa");
        model.addAttribute("category", categoryService.findById(id));
        return "editcategory";
    }
    

}
