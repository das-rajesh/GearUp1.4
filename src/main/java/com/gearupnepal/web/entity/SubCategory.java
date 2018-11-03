/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sub_categories")
public class SubCategory implements Serializable {

    @Column(name = "quantity")
    private Integer quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;


    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("subCategoryList")
    private Category categoriesId;

    @OneToMany(mappedBy = "subCategoriesId",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("subCategoriesId")
    private List<ChildSubcategory> childCategoryModelNameList;

    public SubCategory() {
    }

    public SubCategory(Integer quantity, long id, String name, String createdBy, Date createdDate, Date modifiedDate, Category categoriesId, List<ChildSubcategory> childCategoryModelNameList) {
        this.quantity = quantity;
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.categoriesId = categoriesId;
        this.childCategoryModelNameList = childCategoryModelNameList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Category getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Category categoriesId) {
        this.categoriesId = categoriesId;
    }

    public List<ChildSubcategory> getChildCategoryModelNameList() {
        return childCategoryModelNameList;
    }

    public void setChildCategoryModelNameList(List<ChildSubcategory> childCategoryModelNameList) {
        this.childCategoryModelNameList = childCategoryModelNameList;
    }

    
}
