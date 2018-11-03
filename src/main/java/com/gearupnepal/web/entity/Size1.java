/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "size")
public class Size1 implements Serializable {

    @Size(max = 100)
    @Column(name = "size")
    private String size;
    @Size(max = 100)
    @Column(name = "quantity")
    private String quantity;
    @Size(max = 20)
    @Column(name = "created_by")
    private String createdBy;
    @OneToMany(mappedBy = "sizeId")
    @JsonIgnoreProperties("sizeId")
    private Collection<StockReport> stockReportCollection;
    @OneToMany(mappedBy = "sizeId")
    @JsonIgnoreProperties("sizeId")
    private List<SellReport> sellReportList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(mappedBy = "sizeId", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("sizeId")
    private List<Color> colorList;
    @JoinColumn(name = "child_sub_categories_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("size1List")
    private ChildSubcategory childSubCategoriesId;

    public Size1() {
    }

    public Size1(String quantity, Long id) {
        this.quantity = quantity;
        this.id = id;
    }

    public Size1(String size, String quantity, Long id, ChildSubcategory childSubCategoriesId) {
        this.size = size;
        this.quantity = quantity;
        this.id = id;
        this.childSubCategoriesId = childSubCategoriesId;
    }

    public Size1(String size, String quantity, String createdBy, Collection<StockReport> stockReportCollection, List<SellReport> sellReportList, Long id, Date createdDate, Date modifiedDate, List<Color> colorList, ChildSubcategory childSubCategoriesId) {
        this.size = size;
        this.quantity = quantity;
        this.createdBy = createdBy;
        this.stockReportCollection = stockReportCollection;
        this.sellReportList = sellReportList;
        this.id = id;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.colorList = colorList;
        this.childSubCategoriesId = childSubCategoriesId;
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

    public Collection<StockReport> getStockReportCollection() {
        return stockReportCollection;
    }

    public void setStockReportCollection(Collection<StockReport> stockReportCollection) {
        this.stockReportCollection = stockReportCollection;
    }

    public List<SellReport> getSellReportList() {
        return sellReportList;
    }

    public void setSellReportList(List<SellReport> sellReportList) {
        this.sellReportList = sellReportList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    public ChildSubcategory getChildSubCategoriesId() {
        return childSubCategoriesId;
    }

    public void setChildSubCategoriesId(ChildSubcategory childSubCategoriesId) {
        this.childSubCategoriesId = childSubCategoriesId;
    }

}
