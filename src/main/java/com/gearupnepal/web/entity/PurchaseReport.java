/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "purchase_report")
public class PurchaseReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "size")
    private String size;
    @Size(max = 100)
    @Column(name = "quantity")
    private String quantity;
    @Size(max = 20)
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "child_sub_categories_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnoreProperties("purchaseReportList")
    private ChildSubcategory childSubCategoriesId;

    public PurchaseReport() {
    }

    public PurchaseReport(Long id) {
        this.id = id;
    }

    public PurchaseReport(String size, String quantity, ChildSubcategory childSubCategoriesId) {
        this.size = size;
        this.quantity = quantity;
        this.childSubCategoriesId = childSubCategoriesId;
    }

    public PurchaseReport(Long id, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public PurchaseReport(Long id, String size, String quantity, String createdBy, Date createdDate, Date modifiedDate, ChildSubcategory childSubCategoriesId) {
        this.id = id;
        this.size = size;
        this.quantity = quantity;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.childSubCategoriesId = childSubCategoriesId;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
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

    public ChildSubcategory getChildSubCategoriesId() {
        return childSubCategoriesId;
    }

    public void setChildSubCategoriesId(ChildSubcategory childSubCategoriesId) {
        this.childSubCategoriesId = childSubCategoriesId;
    }

  

}
