/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.controller;

import com.gearupnepal.web.entity.ChildSubcategory;
import com.gearupnepal.web.entity.Login;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dell
 */
@Controller
@RequestMapping(value = "/admin")
public class DashBoardController {

    @GetMapping
    @ResponseBody
    public String index(Model model) {
        long id = 1;
        return "<h1>Secured Area</h1>";
    }

    @GetMapping(value = "/dash")
    public String home(Model model) {
        long id = 1;
        return "dash_1";
    }
       @RequestMapping(method = RequestMethod.POST, value = "/dash")
    public String save( Model model) {
        
        return "dash_1";
    }
    
    
}
