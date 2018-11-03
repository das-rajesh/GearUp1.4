/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.SellReport;
import com.gearupnepal.web.entity.repository.SellReportRepository;
import com.gearupnepal.web.entity.repository.SizeRepository;
import com.gearupnepal.web.service.SellReportService;
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
public class SellReportServiceImpl implements SellReportService {

    @Autowired
    private SellReportRepository SellReportRepository;

//    @Cacheable(value = "categories")
    @Override
    public List<SellReport> getAll() {
        for (SellReport SellReport : SellReportRepository.findAll()) {
//            if (sSellReport.getImage() != null) {
//                byte[] blob = sSellReport.getImage();
//
//                String base64Image = Base64.getEncoder().encodeToString(blob);
//                sSellReport.setBase64Image(base64Image);
//            }

        }
        return SellReportRepository.findAll();
    }

//    @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(SellReport sSellReport) {
        SellReportRepository.save(sSellReport);

    }

    @Override
    public void delete(long id) {
        SellReportRepository.deleteById(id);
    }

    @Override
    public SellReport findById(long id) {
        for (SellReport c : getAll()) {
            if (c.getId() == id) {
                return SellReportRepository.findById(id).get();
            }
        }
        return null;
    }

}
