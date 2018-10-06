/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service;

import com.gearupnepal.web.entity.ChildSubcategory;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ChildSubcategoryService {
    
    List<ChildSubcategory> getAll();
    void save(ChildSubcategory category);
    void delete(long id);
    ChildSubcategory findById(long id);
    List<ChildSubcategory> findChildSubCategoriesListById(long subcategoryid);
    
}
