/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.SubCategory;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.SubCategoryService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/admin/subcategory")
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    LoginRepository loginRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        //       model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(0));
        model.addAttribute("categories", categoryService.getAll());
        return "subcategory";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public String save(@ModelAttribute("SubCategory") SubCategory subCategory, Model model, @PathVariable("id") long id) {
        List<Login> logins = loginRepository.findAll();
        subCategory.setCreatedBy(logins.get(logins.size() - 1).getUserName());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(id));
        model.addAttribute("id", id);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("category", categoryService.findById(id).getName());
        subCategory.setCategoriesId(categoryService.findById(id));

        ArrayList<Long> data = new ArrayList<Long>();
        for (SubCategory s : subCategoryService.getAll()) {
            data.add(s.getId());
        }
        subCategory.setId(Collections.max(data)+1);
        subCategoryService.save(subCategory);
        return "redirect:/admin/subcategory";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {

        model.addAttribute("subCategory", subCategoryService.findById(id));
        return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id) {
        subCategoryService.delete(id);
        return "redirect:/admin/subcategory";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findCategoryId(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        //  model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(id));
        model.addAttribute("category", categoryService.findById(id).getName());
        model.addAttribute("id", id);
        model.addAttribute("subCategories", categoryService.findById(id).getSubCategoryList());

        return "subcategory";
    }

}
