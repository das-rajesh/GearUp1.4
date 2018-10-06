/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service;

import com.gearupnepal.web.entity.Sale;
import java.util.List;

/**
 *
 * @author admin
 */
public interface SaleService {

    List<Sale> getAll();
    void save(Sale sell);
    void delete(long id);
    Sale findById(long id);

}
