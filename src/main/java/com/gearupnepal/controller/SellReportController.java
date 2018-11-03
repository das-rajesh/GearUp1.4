/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.SellReport;
import com.gearupnepal.web.entity.ResponseData;
import com.gearupnepal.web.entity.SellReportWrapper;
import com.gearupnepal.web.entity.Size1;
import com.gearupnepal.web.service.SellReportService;
import com.gearupnepal.web.service.Size1Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(method = RequestMethod.GET, value = "/admin/sellreport")
public class SellReportController {

    @Autowired
    SellReportService sellReportService;

    @Autowired
    Size1Service size1Service;
    
    SellReportWrapper reportWrapper = new SellReportWrapper();

    @GetMapping
    public String index(Model model) {
        model.addAttribute("reportWrapper", reportWrapper);
        return "pos";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-data")
    @ResponseBody
    public ResponseData save(@ModelAttribute("reportWrapper") SellReportWrapper wrapper) {
        //  reportWrapper.setUsers((ArrayList<SellReport>) wrapper);
        System.out.println(wrapper.getSellReport().size());
        // sellReportService.save(new SellReport("22", "3", new Size1()));

        for (SellReport sellReport : wrapper.getSellReport()) {
            System.out.println("price" + sellReport.getPrice());
            System.out.println("quantity" + sellReport.getQuantity());
            System.out.println("size id" + sellReport.getSizeId());
            sellReportService.save(sellReport);
            String quantity=size1Service.findById(sellReport.getSizeId().getId()).getQuantity();
             int data=Integer.parseInt(quantity)-Integer.parseInt(sellReport.getQuantity());
           // size1Service.findById(sellReport.getSizeId().getId()).setQuantity(data+"");
            System.out.println("actutual quantity"+ quantity);
            System.out.println("sell quantity"+ sellReport.getQuantity());
            System.out.println("size id"+ sellReport.getSizeId().getId());
         //   size1Service.save(new Size1(data+"", sellReport.getSizeId().getId()));
            size1Service.save(new Size1(sellReport.getSizeId().getSize(), data+"", sellReport.getSizeId().getId(), sellReport.getSizeId().getChildSubCategoriesId()));
            
            //  sellReportService.save(new SellReport(sellReport.getQuantity(), sellReport.getPrice(), sellReport.getSizeId()));
        }
        //  sellReportService.save(sellreport);
        ResponseData data = new ResponseData();
        data.setData(true);
//        return "redirect:/super-admin/add-size";
        return data;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    @ResponseBody
    public ResponseData delete(long id) {
        sellReportService.delete(id);
        ResponseData data = new ResponseData();
        data.setData(true);
//        return "redirect:/super-admin/add-size";
        return data;
    }
}
