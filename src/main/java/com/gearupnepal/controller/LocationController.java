/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller;

import com.gearupnepal.web.entity.Vendor;
import com.gearupnepal.web.entity.Login;
import com.gearupnepal.web.entity.Role;
import com.gearupnepal.web.entity.repository.VendorRepository;
import com.gearupnepal.web.entity.repository.LoginRepository;
import com.gearupnepal.web.service.VendorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/admin/location")
public class LocationController {

   

    @GetMapping
    public String index(Model model) {
        long id = 1;
          return "location";
    }

 

}
