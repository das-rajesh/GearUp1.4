/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "child_category_model_name")
public class ChildSubcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Float price;

    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "base64Image")
    private String base64Image;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @JoinColumn(name = "sub_categories_id", referencedColumnName = "id")
    @ManyToOne
    private SubCategory subCategoriesId;

    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    @ManyToOne
    private Vendor vendorId;

    public ChildSubcategory() {
    }

    public ChildSubcategory(long id, String name, Float price, byte[] photo, String size, String color, String base64Image, int quantity, String createdBy, Date createdDate, Date modifiedDate, SubCategory subCategoriesId, Vendor vendorId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.size = size;
        this.color = color;
        this.base64Image = base64Image;
        this.quantity = quantity;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.subCategoriesId = subCategoriesId;
        this.vendorId = vendorId;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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

    public SubCategory getSubCategoriesId() {
        return subCategoriesId;
    }

    public void setSubCategoriesId(SubCategory subCategoriesId) {
        this.subCategoriesId = subCategoriesId;
    }

    public Vendor getVendorId() {
        return vendorId;
    }

    public void setVendorId(Vendor vendorId) {
        this.vendorId = vendorId;
    }

}
