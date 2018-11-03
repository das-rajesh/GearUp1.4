/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import java.util.List;

/**
 *
 * @author admin
 */
public class Authority {

    private List<Authority> authority;

    public Authority() {
    }

    public Authority(List<Authority> authority) {
        this.authority = authority;
    }

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }

    
}
