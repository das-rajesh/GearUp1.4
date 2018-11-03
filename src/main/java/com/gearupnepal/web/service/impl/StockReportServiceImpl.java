/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.StockReport;
import com.gearupnepal.web.entity.repository.StockReportRepository;
import com.gearupnepal.web.entity.repository.SizeRepository;
import com.gearupnepal.web.service.StockReportService;
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
public class StockReportServiceImpl implements StockReportService {

    @Autowired
    private StockReportRepository stockReportRepository;

//    @Cacheable(value = "categories")
    @Override
    public List<StockReport> getAll() {
        for (StockReport StockReport : stockReportRepository.findAll()) {
//            if (sStockReport.getImage() != null) {
//                byte[] blob = sStockReport.getImage();
//
//                String base64Image = Base64.getEncoder().encodeToString(blob);
//                sStockReport.setBase64Image(base64Image);
//            }

        }
        return stockReportRepository.findAll();
    }

//    @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(StockReport sStockReport) {
        stockReportRepository.save(sStockReport);

    }

    @Override
    public void delete(long id) {
        stockReportRepository.deleteById(id);
    }

    @Override
    public StockReport findById(long id) {
        for (StockReport c : getAll()) {
            if (c.getId() == id) {
                return stockReportRepository.findById(id).get();
            }
        }
        return null;
    }

}
