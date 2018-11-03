/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.Size1;
import com.gearupnepal.web.entity.repository.SizeRepository;
import com.gearupnepal.web.service.Size1Service;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class SizeServiceImpl implements Size1Service {

    @Autowired
    private SizeRepository size1Repository;

   // @Cacheable(value = "categories")
    @Override
    public List<Size1> getAll() {
        for (Size1 size1 : size1Repository.findAll()) {
//            if (size1.getImage() != null) {
//                byte[] blob = size1.getImage();
//
//                String base64Image = Base64.getEncoder().encodeToString(blob);
//                size1.setBase64Image(base64Image);
//            }

        }
        return size1Repository.findAll();
    }

   // @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(Size1 size1) {
        size1Repository.save(size1);

    }

    @Override
    public void delete(long id) {
        size1Repository.deleteById(id);
    }

    @Override
    public Size1 findById(long id) {
        for (Size1 c : getAll()) {
            if (c.getId() == id) {
                return size1Repository.findById(id).get();
            }
        }
        return null;
    }

}
