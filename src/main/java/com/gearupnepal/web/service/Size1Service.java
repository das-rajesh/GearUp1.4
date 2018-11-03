/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service;

import com.gearupnepal.web.entity.Size1;
import java.util.List;

/**
 *
 * @author admin
 */
public interface Size1Service {
    
    List<Size1> getAll();
    void save(Size1 size1);
    void delete(long id);
    Size1 findById(long id);

}
