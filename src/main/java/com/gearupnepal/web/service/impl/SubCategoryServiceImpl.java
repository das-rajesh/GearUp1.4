/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.Category;
import com.gearupnepal.web.entity.SubCategory;
import com.gearupnepal.web.entity.repository.CategoryRepository;
import com.gearupnepal.web.entity.repository.SubCategoryRepository;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.SubCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    @Cacheable(value = "categories")
    @Override
    public List<SubCategory> getAll() {

        return subCategoryRepository.findAll();
    }

    @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(SubCategory subCategory) {
        subCategoryRepository.save(subCategory);

    }

    @Override
    public void delete(long id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public SubCategory findById(long id) {
        for (SubCategory c : getAll()) {
            if (c.getId() == id) {
                return subCategoryRepository.findById(id).get();
            }
        }
        return null;
    }

    @Override
    public List<SubCategory> getSubCategoryListByCategoryId(long id) {
        for (Category c : categoryRepository.findAll()) {
            if (c.getId() == id) {
                return c.getSubCategoryList();
            }
        }
        return null;
    }

    @Override
    public Category findCategoryBySubCategoryId(long id) {

        return subCategoryService.findById(id).getCategoriesId();
    }

}
