/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Purchase;
import com.gearupnepal.web.entity.PurchaseReport;
import com.gearupnepal.web.entity.ResponseData;
import com.gearupnepal.web.service.PurchaseService;
import com.gearupnepal.web.service.PurchaseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(method = RequestMethod.GET, value = "/admin/purchasereport")
public class PurchaseReportController {

    @Autowired
    PurchaseReportService purchaseReportService;
    
    @Autowired
    PurchaseService purchaseService;

    @GetMapping
    public String index() {
        return "size";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-data")
    @ResponseBody
    public ResponseData save(@ModelAttribute("ChildSubCategory") PurchaseReport size) {
        purchaseReportService.save(size);
     //  purchaseService.save(new Purchase);
        ResponseData data = new ResponseData();
        data.setData(true);
//        return "redirect:/super-admin/add-size";
        return data;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    @ResponseBody
    public ResponseData delete(long id) {
        purchaseReportService.delete(id);
        ResponseData data = new ResponseData();
        data.setData(true);
//        return "redirect:/super-admin/add-size";
        return data;
    }
}
