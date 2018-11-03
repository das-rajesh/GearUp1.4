/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service;

import com.gearupnepal.web.entity.Color;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ColorService {
    
    List<Color> getAll();
    void save(Color color);
    void delete(long id);
    Color findById(long id);

}
