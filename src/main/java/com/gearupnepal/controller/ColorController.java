/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Color;
import com.gearupnepal.web.entity.ResponseData;
import com.gearupnepal.web.service.ColorService;
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
@RequestMapping(method = RequestMethod.GET, value = "/admin/color")
public class ColorController {

    @Autowired
    ColorService colorService;

    @GetMapping
    public String index() {
        return "color";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-data")
    @ResponseBody
    public ResponseData save(@ModelAttribute("Color") Color color) {
        colorService.save(color);
        ResponseData data = new ResponseData();
        data.setData(true);
//        return "redirect:/super-admin/add-color";
        return data;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    @ResponseBody
    public ResponseData delete(long id) {
        colorService.delete(id);
        ResponseData data = new ResponseData();
        data.setData(true);
//        return "redirect:/super-admin/add-color";
        return data;
    }
}
