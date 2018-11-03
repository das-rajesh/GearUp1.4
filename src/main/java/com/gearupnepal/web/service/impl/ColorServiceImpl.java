/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.Color;
import com.gearupnepal.web.entity.repository.ColorRepository;
import com.gearupnepal.web.service.ColorService;
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
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Cacheable(value = "categories")
    @Override
    public List<Color> getAll() {
        for (Color color : colorRepository.findAll()) {
//            if (color.getImage() != null) {
//                byte[] blob = color.getImage();
//
//                String base64Image = Base64.getEncoder().encodeToString(blob);
//                color.setBase64Image(base64Image);
//            }

        }
        return colorRepository.findAll();
    }

    @CacheEvict(allEntries = true, value = "categories")
    @Override
    public void save(Color color) {
        colorRepository.save(color);

    }

    @Override
    public void delete(long id) {
        colorRepository.deleteById(id);
    }

    @Override
    public Color findById(long id) {
        for (Color c : getAll()) {
            if (c.getId() == id) {
                return colorRepository.findById(id).get();
            }
        }
        return null;
    }

}
