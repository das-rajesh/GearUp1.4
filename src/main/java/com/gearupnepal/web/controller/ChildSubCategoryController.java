/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.ChildSubcategory;
import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.SubCategory;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.ChildSubcategoryService;
import com.gearupnepal.web.service.SubCategoryService;
import com.gearupnepal.web.service.VendorService;
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
@RequestMapping(value = "/childsubcategory")
public class ChildSubCategoryController {
    
    @Autowired
    SubCategoryService subCategoryService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    LoginRepository loginRepository;
    
    @Autowired
    VendorService vendorService;
    
    @Autowired
    ChildSubcategoryService childSubcategoryService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        //       model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(0));
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("vendors", vendorService.getAll());
        //    model.addAttribute("subCategories", subCategoryService.getAll());vendors
        return "childsubcategory2";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/ch/{id1}/{id2}")
    public String save(@ModelAttribute("ChildSubcategory") ChildSubcategory childSubcategory, Model model, @PathVariable("id1") long id1,
            @PathVariable("id2") long id2) {
        List<Login> logins = loginRepository.findAll();
        System.out.println("saving    hjhhhhhhhhhhhhhhhhhhhh");
        System.out.println("printing id " + childSubcategory.getSubCategoriesId());
        childSubcategory.setCreatedBy(logins.get(logins.size() - 1).getUserName());
        model.addAttribute("id", id2);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(id1));
//        model.addAttribute("childSubCategories", categoryService.findById(id2));
        model.addAttribute("childSubCategories", childSubcategoryService.findChildSubCategoriesListById(id1));
        model.addAttribute("category", categoryService.findById(id2).getName());
        model.addAttribute("subcategory", subCategoryService.findById(id1).getName());

//        model.addAttribute("category", categoryService.findById(id2).getName());
        childSubcategory.setSubCategoriesId(subCategoryService.findById(id1));
        childSubcategoryService.save(childSubcategory);
        return "childsubcategory2";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        
        model.addAttribute("subCategory", subCategoryService.findById(id));
        return "index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id) {
        subCategoryService.delete(id);
        return "redirect:/childsubcategory2";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findCategoryId(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(id));
        System.out.println(subCategoryService.getSubCategoryListByCategoryId(id).size() + "sdaaaaaaaaaaaaaaaaaaaaa");
        model.addAttribute("category", categoryService.findById(id).getName());
        model.addAttribute("id", id);
        
        return "childsubcategory2";
    }
    
    @RequestMapping(value = "/subcategoryofcategory/{id}", method = RequestMethod.GET)
    public String findSubCategoryId(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(id));
        model.addAttribute("category", categoryService.findById(id).getName());
        model.addAttribute("categoryId", id);
        return "childsubcategory2";
    }
    
    @RequestMapping(value = "/ch/{id1}/{id2}", method = RequestMethod.GET)
    public String findchildsubcategory2Id(@PathVariable("id1") long id1,
            @PathVariable("id2") long categoryId, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(categoryId));
        model.addAttribute("childSubCategories", childSubcategoryService.findChildSubCategoriesListById(id1));
        System.out.println(childSubcategoryService.findChildSubCategoriesListById(id1).size() + "asddddddddddddddddddddd");
        model.addAttribute("category", categoryService.findById(categoryId).getName());
        model.addAttribute("subcategory", subCategoryService.findById(id1).getName());
        model.addAttribute("subcategoryId", id1);
        
        return "childsubcategory2";
    }
    
     
    
}
