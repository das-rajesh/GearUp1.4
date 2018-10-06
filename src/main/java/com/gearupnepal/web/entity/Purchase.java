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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "purchases")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "vendor")
    private String vendor;
    @Size(max = 100)
    @Column(name = "category")
    private String category;
    @Size(max = 100)
    @Column(name = "subcategory")
    private String subcategory;
    @Size(max = 100)
    @Column(name = "childsubcategory")
    private String childsubcategory;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "unitprice")
    private Float unitprice;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "totalprice")
    private Float totalprice;
    @Size(max = 1000)
    @Column(name = "base64Image")
    private String base64Image;
    @Size(max = 200)
    @Column(name = "created_by")
    private String createdBy;
   
    
    @Column(name = "purchased_date",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchasedDate;
   
    @Column(name = "modified_date",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public Purchase() {
    }

    public Purchase(Long id) {
        this.id = id;
    }
    
    

    public Purchase(Long id, String vendor, Date purchasedDate, Date modifiedDate) {
        this.id = id;
        this.vendor = vendor;
        this.purchasedDate = purchasedDate;
        this.modifiedDate = modifiedDate;
    }

    public Purchase( String vendor, String category, String subcategory, String childsubcategory, 
            byte[] photo, Float unitprice, int quantity, Float totalprice, 
            String base64Image, String createdBy) {
        this.vendor = vendor;
        this.category = category;
        this.subcategory = subcategory;
        this.childsubcategory = childsubcategory;
        this.photo = photo;
        this.unitprice = unitprice;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.base64Image = base64Image;
        this.createdBy = createdBy;
    }

    public Purchase(String name, String name0, String subcategory, String childsubcategory, byte[] photo, Float price, int quantity, float f, String base64Image, String createdBy, Date createdDate, Date modifiedDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Purchase(String name, String name0, String subcategory, String childsubcategory, byte[] photo, Float price, int quantity, float f, String base64Image, String createdBy, Date createdDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getChildsubcategory() {
        return childsubcategory;
    }

    public void setChildsubcategory(String childsubcategory) {
        this.childsubcategory = childsubcategory;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Float unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Float totalprice) {
        this.totalprice = totalprice;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
