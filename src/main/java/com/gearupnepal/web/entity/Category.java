/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
     @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    
    @Column(name = "base64image")
    private String base64image;
    @Column(name = "quantity")
    private Integer quantity;
  
    
    @Size(min = 1, max = 20)
    @Column(name = "created_by")
    private String createdBy;
  
    
    @Column(name = "created_date",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
  
    
    @Column(name = "modified_date",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @OneToMany(mappedBy = "categoriesId")
    private List<SubCategory> subCategoryList;

    public Category() {
    }

    public Category(long id) {
        this.id = id;
    }

    public Category(long id, String name, String createdBy, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getBase64image() {
        return base64image;
    }

    public void setBase64image(String base64image) {
        this.base64image = base64image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

  

}
