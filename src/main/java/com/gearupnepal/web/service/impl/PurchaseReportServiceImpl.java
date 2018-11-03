/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.PurchaseReport;
import com.gearupnepal.web.entity.repository.PurchaseReportRepository;
import com.gearupnepal.web.service.PurchaseReportService;
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
public class PurchaseReportServiceImpl implements PurchaseReportService {

    @Autowired
    private PurchaseReportRepository purchaseReportRepository;

    //@Cacheable(value = "categories")
    @Override
    public List<PurchaseReport> getAll() {
        for (PurchaseReport purchaseReport : purchaseReportRepository.findAll()) {
//            if (purchaseReport.getImage() != null) {
//                byte[] blob = purchaseReport.getImage();
//
//                String base64Image = Base64.getEncoder().encodeToString(blob);
//                purchaseReport.setBase64Image(base64Image);
//            }

        }
        return purchaseReportRepository.findAll();
    }

  //  @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(PurchaseReport purchaseReport) {
        purchaseReportRepository.save(purchaseReport);

    }

    @Override
    public void delete(long id) {
        purchaseReportRepository.deleteById(id);
    }

    @Override
    public PurchaseReport findById(long id) {
        for (PurchaseReport c : getAll()) {
            if (c.getId() == id) {
                return purchaseReportRepository.findById(id).get();
            }
        }
        return null;
    }

}
