/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TempChildWrapper {
    
private ArrayList<TempChild> users;

    public TempChildWrapper() {
    }

    public TempChildWrapper(ArrayList<TempChild> users) {
        this.users = users;
    }

    public ArrayList<TempChild> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<TempChild> users) {
        this.users = users;
    }


}
