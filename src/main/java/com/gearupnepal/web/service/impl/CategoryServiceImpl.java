/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.Category;
import com.gearupnepal.web.entity.repository.CategoryRepository;
import com.gearupnepal.web.service.CategoryService;
import java.util.Base64;
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
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Cacheable(value = "categories")
    @Override
    public List<Category> getAll() {
        for (Category category : categoryRepository.findAll()) {
//            if (category.getImage() != null) {
//                byte[] blob = category.getImage();
//
//                String base64Image = Base64.getEncoder().encodeToString(blob);
//                category.setBase64Image(base64Image);
//            }

        }
        return categoryRepository.findAll();
    }

    @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(long id) {
        for (Category c : getAll()) {
            if (c.getId() == id) {
                return categoryRepository.findById(id).get();
            }
        }
        return null;
    }

}
