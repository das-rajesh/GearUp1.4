/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.ChildSubcategory;
import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.Purchase;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.ChildSubcategoryService;
import com.gearupnepal.web.service.PurchaseService;
import com.gearupnepal.web.service.SubCategoryService;
import com.gearupnepal.web.service.VendorService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/updateinventory")
public class UpdateInventoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    ChildSubcategoryService childSubcategoryService;

    @Autowired
    VendorService vendorService;

    @Autowired
    PurchaseService purchaseService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        //       model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(0));
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("vendors", vendorService.getAll());
        //    model.addAttribute("subCategories", subCategoryService.getAll());
        return "updateinventory";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/csc/{id1}/{id2}")
    public String save(@ModelAttribute("childSubcategory") @Valid ChildSubcategory childSubcategory,
            BindingResult userloginResult,
            Model model,
            @PathVariable("id1") long subcategoryid,
            @PathVariable("id2") long childsubcategoryidcategoryId,
            @RequestParam("photo") MultipartFile photo) throws IOException {
        List<Login> logins = loginRepository.findAll();
        childSubcategory.setCreatedBy(logins.get(logins.size() - 1).getUserName());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(subCategoryService.findById(subcategoryid).getId()));
        model.addAttribute("childSubCategories", childSubcategoryService.findChildSubCategoriesListById(subcategoryid));
        System.out.println(childSubcategoryService.findChildSubCategoriesListById(subcategoryid).size() + "asddddddddddddddddddddd");
        model.addAttribute("category", subCategoryService.findById(subcategoryid).getCategoriesId().getName());
        model.addAttribute("subcategory", subCategoryService.findById(subcategoryid).getName());
        model.addAttribute("subcategoryId", subcategoryid);
        model.addAttribute("vendors", vendorService.getAll());
        model.addAttribute("childSubCategoryname", childSubcategory.getName());
        childSubcategory.setPhoto(photo.getBytes());
        childSubcategory.setSubCategoriesId(subCategoryService.findById(subcategoryid));
        
                childSubcategory.setId(childsubcategoryidcategoryId);

        childSubcategoryService.save(childSubcategory);
        //Files.write(Paths.get("image.jpg"), photo.getBytes());

        String category = childSubcategory.getSubCategoriesId().getCategoriesId().getName();
        String subcategory = childSubcategory.getSubCategoriesId().getName();
        String childsubcategory = childSubcategory.getName();

        purchaseService.save(new Purchase(
                childSubcategory.getVendorId().getName(),
                childSubcategory.getSubCategoriesId().getName(),
                subcategory, childsubcategory,
                childSubcategory.getPhoto(),
                childSubcategory.getPrice(),
                childSubcategory.getQuantity(),
                childSubcategory.getPrice() * childSubcategory.getQuantity(),
                childSubcategory.getBase64Image(),
                childSubcategory.getCreatedBy()));

        return "updateinventory";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("vendors", vendorService.getAll());

        model.addAttribute("subCategory", subCategoryService.findById(id));
        return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id) {
        subCategoryService.delete(id);

        return "redirect:/updateinventory";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findCategoryId(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(id));
        System.out.println(subCategoryService.getSubCategoryListByCategoryId(id).size() + "sdaaaaaaaaaaaaaaaaaaaaa");
        model.addAttribute("category", categoryService.findById(id).getName());
        model.addAttribute("id", id);
        model.addAttribute("vendors", vendorService.getAll());

        return "updateinventory";
    }

    @RequestMapping(value = "/subcategoryofcategory/{id}", method = RequestMethod.GET)
    public String findSubCategoryId(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(id));
        model.addAttribute("category", categoryService.findById(id).getName());
        model.addAttribute("categoryId", id);
        model.addAttribute("vendors", vendorService.getAll());

        return "updateinventory";
    }

    @RequestMapping(value = "/ch/{id1}/{id2}", method = RequestMethod.GET)
    public String findupdateinventoryId(@PathVariable("id1") long id1,
            @PathVariable("id2") long categoryId, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(categoryId));
        model.addAttribute("childSubCategories", childSubcategoryService.findChildSubCategoriesListById(id1));
        System.out.println(childSubcategoryService.findChildSubCategoriesListById(id1).size() + "asddddddddddddddddddddd");
        model.addAttribute("category", categoryService.findById(categoryId).getName());
        model.addAttribute("subcategory", subCategoryService.findById(id1).getName());
        model.addAttribute("subcategoryId", id1);
        model.addAttribute("vendors", vendorService.getAll());

        return "updateinventory";
    }

    @RequestMapping(value = "/csc/{id1}/{id2}", method = RequestMethod.GET)
    public String csc(@PathVariable("id1") long subcategoryid,
            @PathVariable("id2") long childsubcategoryidcategoryId,
            Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(subCategoryService.findById(subcategoryid).getId()));
        model.addAttribute("childSubCategories", childSubcategoryService.findChildSubCategoriesListById(subcategoryid));
        System.out.println(childSubcategoryService.findChildSubCategoriesListById(subcategoryid).size() + "asddddddddddddddddddddd");
        model.addAttribute("category", subCategoryService.findById(subcategoryid).getCategoriesId().getName());
        model.addAttribute("subcategory", subCategoryService.findById(subcategoryid).getName());
        model.addAttribute("subcategoryId", subcategoryid);
        model.addAttribute("childsubcategoryId", childsubcategoryidcategoryId);
        model.addAttribute("vendors", vendorService.getAll());
        model.addAttribute("childsubcategoryname", childSubcategoryService.findById(childsubcategoryidcategoryId).getName());

        return "updateinventory";
    }
}
