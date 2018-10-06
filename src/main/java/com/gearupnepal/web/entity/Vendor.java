/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "vendors")
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_no")
    private String contactNo;
    @Size(max = 100)
    @Column(name = "website")
    private String website;

    @Column(name = "type")
    private String type;

    @Column(name = "country")
    private String country;
    @Column(name = "sub_category_model_name_id")
    private Long subCategoryModelNameId;

    @Size(min = 1, max = 20)
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @OneToMany(mappedBy = "vendorId")
    private List<ChildSubcategory> childCategoryModelNameList;

    public Vendor() {
    }

    public Vendor(long id, String name, String email, String contactNo, String website, String type, String country, Long subCategoryModelNameId, String createdBy, Date createdDate, Date modifiedDate, List<ChildSubcategory> childCategoryModelNameList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.website = website;
        this.type = type;
        this.country = country;
        this.subCategoryModelNameId = subCategoryModelNameId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.childCategoryModelNameList = childCategoryModelNameList;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSubCategoryModelNameId() {
        return subCategoryModelNameId;
    }

    public void setSubCategoryModelNameId(Long subCategoryModelNameId) {
        this.subCategoryModelNameId = subCategoryModelNameId;
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

    public List<ChildSubcategory> getChildCategoryModelNameList() {
        return childCategoryModelNameList;
    }

    public void setChildCategoryModelNameList(List<ChildSubcategory> childCategoryModelNameList) {
        this.childCategoryModelNameList = childCategoryModelNameList;
    }

}
