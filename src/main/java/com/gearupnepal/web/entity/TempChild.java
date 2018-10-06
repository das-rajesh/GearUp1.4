/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

/**
 *
 * @author admin
 */
public class TempChild {
    
    private long  id;
    private String name;
    private long quantity;
    private long maxQuantity;
    private Float price;

    public TempChild() {
    }

    public TempChild(long id, String name, long quantity, Float price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public TempChild(long id, String name, long quantity, long maxQuantity, Float price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public long getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(long maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
    
    
    
}
