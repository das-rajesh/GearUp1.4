/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.service.impl;

import com.gearupnepal.web.entity.User;
import com.gearupnepal.web.entity.repository.UserRepository;
import com.gearupnepal.web.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

   

    @Cacheable(value = "users")
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @CacheEvict(allEntries = true, value = "users")
    @Override
    public void save(User user) {
        userRepository.save(user);

    }

}
