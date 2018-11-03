/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller.api;


import com.gearupnepal.web.entity.PurchaseReport;
import com.gearupnepal.web.service.PurchaseReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */

@RestController
@RequestMapping(value = "/admin/api/purchasereport")
public class PurchaseReportApiController {
    
    @Autowired
    PurchaseReportService purchaseReportService;
    
    @GetMapping
    public ResponseEntity<List<PurchaseReport>> index(){
        return ResponseEntity.ok(purchaseReportService.getAll());
    }
    
    
}
