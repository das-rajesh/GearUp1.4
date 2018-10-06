/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.Role;
import com.gearupnepal.web.entity.repository.RoleRepository;
import com.gearupnepal.web.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Cacheable(value = "roles")
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @CacheEvict(allEntries = true,value = "roles")
    @Override
    public void save(Role role) {
        roleRepository.save(role);

    }

}
