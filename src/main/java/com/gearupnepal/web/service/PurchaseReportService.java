/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service;

import com.gearupnepal.web.entity.PurchaseReport;
import java.util.List;

/**
 *
 * @author admin
 */
public interface PurchaseReportService {
    
    List<PurchaseReport> getAll();
    void save(PurchaseReport purchaseReport);
    void delete(long id);
    PurchaseReport findById(long id);

}
