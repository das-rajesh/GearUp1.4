/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.ChildSubcategory;
import com.gearupnepal.web.entity.Sale;
import com.gearupnepal.web.entity.TempChild;
import com.gearupnepal.web.entity.TempChildWrapper;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.ChildSubcategoryService;
import com.gearupnepal.web.service.SaleService;
import com.gearupnepal.web.service.SubCategoryService;
import com.gearupnepal.web.service.VendorService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/POS")
public class PosController {

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

    List<TempChild> tempChilds = new ArrayList<>();

    @Autowired
    SaleService saleService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getAll());
        model.addAttribute("childSubCategories", childSubcategoryService.getAll());
        model.addAttribute("vendors", vendorService.getAll());
        //    model.addAttribute("subCategories", subCategoryService.getAll());vendors

        TempChildWrapper wrapper = new TempChildWrapper();
        wrapper.setUsers(new ArrayList<TempChild>(tempChilds));
        model.addAttribute("tempChildListWrapper", wrapper);
        tempChilds.clear();
        return "pointofsale_2_3";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findSubCategoryId(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getAll());
        model.addAttribute("childSubCategoriesbyId", childSubcategoryService.findChildSubCategoriesListById(id));
        model.addAttribute("vendors", vendorService.getAll());
        model.addAttribute("tempChilds", tempChilds);
        model.addAttribute("totals", total());

        TempChildWrapper wrapper = new TempChildWrapper();
        wrapper.setUsers(new ArrayList<TempChild>(tempChilds));
        model.addAttribute("tempChildListWrapper", wrapper);
//        model.addAttribute("categories", categoryService.getAll());
//        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(id));
//        model.addAttribute("category", categoryService.findById(id).getName());
//        model.addAttribute("categoryId", id);
        return "pointofsale_2_3";
    }

    @RequestMapping(value = "/child/{id}", method = RequestMethod.GET)
    public String findChildSubCategoryId(@PathVariable("id") long id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getAll());
        model.addAttribute("childSubCategoriesbyId", childSubcategoryService.findChildSubCategoriesListById(childSubcategoryService.findById(id).getSubCategoriesId().getId()));
        model.addAttribute("vendors", vendorService.getAll());
        model.addAttribute("singleChildData", childSubcategoryService.findById(id));
        model.addAttribute("one", 1);
        TempChildWrapper wrapper = new TempChildWrapper();
        wrapper.setUsers(new ArrayList<TempChild>(tempChilds));
        model.addAttribute("tempChildListWrapper", wrapper);

//        model.addAttribute("categories", categoryService.getAll());
//        model.addAttribute("subCategories", subCategoryService.getSubCategoryListByCategoryId(id));
//        model.addAttribute("category", categoryService.findById(id).getName());
//        model.addAttribute("categoryId", id);
        tempChilds.add(new TempChild(id, childSubcategoryService.findById(id).getName(),
                childSubcategoryService.findById(id).getQuantity(), childSubcategoryService.findById(id).getPrice()));
        model.addAttribute("tempChilds", tempChilds);
        model.addAttribute("totals", total());
        model.addAttribute("id", id);

        return "pointofsale_2_3";
    }

    public float total() {
        float total = 0;
        for (int i = 0; i < tempChilds.size(); i++) {

            try {
                float data1 = tempChilds.get(i).getQuantity();

                float data2 = tempChilds.get(i).getPrice();
                if (data1 != 0 || data2 != 0) {
                    total += data1 * data2;
                }
            } catch (NullPointerException e) {
                System.out.println("null");
            }

            //total += tempChilds.get(i).getQuantity() * tempChilds.get(i).getPrice();
        }
        return total;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/child/{id}")
    public String save(@ModelAttribute("tempChild") TempChild tempChild,
            @PathVariable("id") long id,
            Model model) {
        for (TempChild temp : tempChilds) {
            if (temp.getName().equals(tempChild.getName())) {
                tempChilds.add((int) temp.getId(), temp);
                System.out.println(temp.getQuantity());
                System.out.println("SAVE HO RAHA HAE");

            }
        }

        TempChildWrapper wrapper = new TempChildWrapper();
        wrapper.setUsers(new ArrayList<TempChild>(tempChilds));
        model.addAttribute("tempChildListWrapper", wrapper);

        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getAll());
        model.addAttribute("childSubCategoriesbyId", childSubcategoryService.findChildSubCategoriesListById(childSubcategoryService.findById(id).getSubCategoriesId().getId()));
        model.addAttribute("vendors", vendorService.getAll());
        model.addAttribute("singleChildData", childSubcategoryService.findById(id));
        model.addAttribute("one", 1);
        model.addAttribute("id", id);

        tempChilds.add(new TempChild(id, childSubcategoryService.findById(id).getName(),
                childSubcategoryService.findById(id).getQuantity(), childSubcategoryService.findById(id).getPrice()));
        model.addAttribute("tempChilds", tempChilds);
        model.addAttribute("totals", total());

        return "pointofsale_2_3";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/change/{id}")
    public String change(@ModelAttribute("tempChild") TempChild tempChild,
            @PathVariable("id") long id,
            Model model) {
        for (TempChild temp : tempChilds) {
            if (temp.getName().equals(tempChild.getName())) {
                tempChilds.get((int) id - 1).setQuantity(tempChild.getQuantity());
                //  tempChilds.add((int) temp.getId(), temp);

            }
        }
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getAll());
        model.addAttribute("childSubCategoriesbyId", childSubcategoryService.findChildSubCategoriesListById(childSubcategoryService.findById(id).getSubCategoriesId().getId()));
        model.addAttribute("vendors", vendorService.getAll());
        model.addAttribute("singleChildData", childSubcategoryService.findById(id));
        model.addAttribute("one", 1);
        model.addAttribute("id", id);

        TempChildWrapper wrapper = new TempChildWrapper();
        wrapper.setUsers(new ArrayList<TempChild>(tempChilds));
        model.addAttribute("tempChildListWrapper", wrapper);

        model.addAttribute("tempChilds", tempChilds);
        model.addAttribute("totals", total());
        return "pointofsale_2_3";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateQuantity(@ModelAttribute(value = "tempChildListWrapper") TempChildWrapper tempChildWrapper,
            Model model) {
        long id = 0;
        //      childSubcategoryService.findById(0).setQuantity(20);
        //   childSubcategoryService.save(childSubcategoryService.findById(3));
        System.out.println(tempChildWrapper.getUsers().get(0).getId());
        System.out.println("sdhdbashdasbdkasdj");
        for (int i = 0; i < tempChildWrapper.getUsers().size(); i++) {
            for (ChildSubcategory ch : childSubcategoryService.getAll()) {
                if (ch.getName().equals(tempChildWrapper.getUsers().get(i).getName())) {
                    ch.setQuantity(ch.getQuantity() - ((int) tempChildWrapper.getUsers().get(i).getQuantity()));
                    System.out.println(ch.getQuantity());
                    System.out.println(ch.getName());
                    System.out.println(ch.getQuantity() + "sdasdasdasdasd");
                    ch.setId(ch.getId());

                    childSubcategoryService.save(ch);
                    System.out.println(ch.getQuantity() + "quantity ");

                    String category = ch.getSubCategoriesId().getCategoriesId().getName();
                    String subcategory = ch.getSubCategoriesId().getName();
                    String childsubcategory = ch.getName();
                    System.out.println((int) tempChildWrapper.getUsers().get(i).getQuantity() + "quantity uiiuyoiuyiuyiu");
                   Sale sale=new Sale(
                            category,
                            subcategory,
                            childsubcategory,
                            ch.getPhoto(),
                             tempChildWrapper.getUsers().get(i).getPrice(),
                            (int) tempChildWrapper.getUsers().get(i).getQuantity(),
                            tempChildWrapper.getUsers().get(i).getPrice()
                            *  tempChildWrapper.getUsers().get(i).getQuantity(),
                            ch.getBase64Image(),
                            ch.getCreatedBy());
                    sale.setUnitprice(tempChildWrapper.getUsers().get(i).getPrice()+0.0);
                    sale.setTotalprice((tempChildWrapper.getUsers().get(i).getPrice())*
                            ((tempChildWrapper.getUsers().get(i).getQuantity())));
                    saleService.save(sale);

                }
            }
        }
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("subCategories", subCategoryService.getAll());
        model.addAttribute("vendors", vendorService.getAll());
        model.addAttribute("one", 1);

        tempChilds.clear();

        return "pointofsale_2_3";

    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // this will allow 500 size of array.
        dataBinder.setAutoGrowCollectionLimit(500);
    }
}
