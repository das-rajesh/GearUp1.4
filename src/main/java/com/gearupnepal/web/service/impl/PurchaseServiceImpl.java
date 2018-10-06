/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.Purchase;
import com.gearupnepal.web.entity.repository.PurchaseRepository;
import com.gearupnepal.web.service.PurchaseService;
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
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Cacheable(value = "categories")
    @Override
    public List<Purchase> getAll() {
        for (Purchase purchase : purchaseRepository.findAll()) {
            if (purchase.getPhoto()!= null) {
                byte[] blob = purchase.getPhoto();

                String base64Image = Base64.getEncoder().encodeToString(blob);
               purchase.setBase64Image(base64Image);
            }

        }
        return purchaseRepository.findAll();
    }

    @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);

    }

    @Override
    public void delete(long id) {
        purchaseRepository.deleteById(id);
    }

    @Override
    public Purchase findById(long id) {
        for (Purchase c : getAll()) {
            if (c.getId() == id) {
                return purchaseRepository.findById(id).get();
            }
        }
        return null;
    }

}
