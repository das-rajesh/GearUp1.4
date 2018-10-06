/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.Sale;
import com.gearupnepal.web.entity.repository.SaleRepository;
import com.gearupnepal.web.service.SaleService;
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
public class SellServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Cacheable(value = "categories")
    @Override
    public List<Sale> getAll() {
        for (Sale sale : saleRepository.findAll()) {
            if (sale.getPhoto()!= null) {
                byte[] blob = sale.getPhoto();

                String base64Image = Base64.getEncoder().encodeToString(blob);
               sale.setBase64Image(base64Image);
            }

        }
        return saleRepository.findAll();
    }

    @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(Sale sale) {
        saleRepository.save(sale);

    }

    @Override
    public void delete(long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public Sale findById(long id) {
        for (Sale c : getAll()) {
            if (c.getId() == id) {
                return saleRepository.findById(id).get();
            }
        }
        return null;
    }

}
