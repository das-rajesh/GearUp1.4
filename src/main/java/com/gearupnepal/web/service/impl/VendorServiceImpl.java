/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.Vendor;
import com.gearupnepal.web.entity.repository.VendorRepository;
import com.gearupnepal.web.service.VendorService;
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
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Cacheable(value = "categories")
    @Override
    public List<Vendor> getAll() {
        for (Vendor vendor : vendorRepository.findAll()) {
//            if (vendor.getImage() != null) {
//                byte[] blob = vendor.getImage();
//
//                String base64Image = Base64.getEncoder().encodeToString(blob);
//                vendor.setBase64Image(base64Image);
//            }

        }
        return vendorRepository.findAll();
    }

    @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(Vendor vendor) {
        vendorRepository.save(vendor);

    }

    @Override
    public void delete(long id) {
        vendorRepository.deleteById(id);
    }

    @Override
    public Vendor findById(long id) {
        for (Vendor c : getAll()) {
            if (c.getId() == id) {
                return vendorRepository.findById(id).get();
            }
        }
        return null;
    }

}
