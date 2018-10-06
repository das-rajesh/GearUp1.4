/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service;

import com.gearupnepal.web.entity.Category;
import com.gearupnepal.web.entity.SubCategory;
import java.util.List;

/**
 *
 * @author admin
 */
public interface SubCategoryService {
    
    List<SubCategory> getAll();
    void save(SubCategory category);
    void delete(long id);
    SubCategory findById(long id);
    List<SubCategory> getSubCategoryListByCategoryId(long id);
    Category findCategoryBySubCategoryId(long id);
}
