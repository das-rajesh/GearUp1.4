/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.ChildSubcategory;
import com.gearupnepal.web.entity.SubCategory;
import com.gearupnepal.web.entity.repository.ChildSubCategoryRepository;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.ChildSubcategoryService;
import com.gearupnepal.web.service.SubCategoryService;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ChildSubCategoryServiceImpl implements ChildSubcategoryService {

    @Autowired
    ChildSubCategoryRepository childSubCategoryRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @Override
    public List<ChildSubcategory> getAll() {
        for (ChildSubcategory c : childSubCategoryRepository.findAll()) {
            if (c.getPhoto() != null) {
                byte[] blob = c.getPhoto();

                String base64Image = Base64.getEncoder().encodeToString(blob);
                c.setBase64Image(base64Image);
            }

        }

        return childSubCategoryRepository.findAll();
    }

    @Override
    public void save(ChildSubcategory childSubCategory) {
        childSubCategoryRepository.save(childSubCategory);
    }

    @Override
    public void delete(long id) {
        childSubCategoryRepository.deleteById(id);
    }

    @Override
    public ChildSubcategory findById(long id) {
        for (ChildSubcategory c : getAll()) {
            if (c.getId() == id) {
                return childSubCategoryRepository.findById(id).get();
            }
        }
        return null;
    }

    @Override
    public List<ChildSubcategory> findChildSubCategoriesListById(long subcategoryid) {
        //return  subCategoryService.getSubCategoryListByCategoryId(categoryId);
        for (SubCategory c : subCategoryService.getAll()) {
            if (c.getId() == subcategoryid) {
                return c.getChildCategoryModelNameList();
            }
        }
        return null;
    }

}
