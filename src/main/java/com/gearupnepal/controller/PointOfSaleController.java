/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Size1;
import com.gearupnepal.web.entity.ResponseData;
import com.gearupnepal.web.entity.SellReportWrapper;
import com.gearupnepal.web.service.Size1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping(method = RequestMethod.GET, value = {"/admin/pointofsale","/user/poinofsale"})
public class PointOfSaleController {

    @Autowired
    Size1Service size1Service;
    SellReportWrapper reportWrapper=new SellReportWrapper();

    @GetMapping
    public String index(Model model) {
                model.addAttribute("reportWrapper", reportWrapper);

        return "pos_1";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-data")
    @ResponseBody
    public ResponseData save(@ModelAttribute("ChildSubCategory") Size1 size) {
        size1Service.save(size);
        ResponseData data = new ResponseData();
        data.setData(true);
//        return "redirect:/super-admin/add-size";
        return data;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    @ResponseBody
    public ResponseData delete(long id) {
        size1Service.delete(id);
        ResponseData data = new ResponseData();
        data.setData(true);
//        return "redirect:/super-admin/add-size";
        return data;
    }
}
