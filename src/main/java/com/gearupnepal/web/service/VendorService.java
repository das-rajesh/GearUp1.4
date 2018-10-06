/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service;

import com.gearupnepal.web.entity.Vendor;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorService {
    
    List<Vendor> getAll();
    void save(Vendor category);
    void delete(long id);
    Vendor findById(long id);

}
