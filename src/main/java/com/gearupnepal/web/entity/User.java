/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "id")
    private long id;
   
    
    @Size(min = 1, max = 20)
    @Column(name = "user_name")
    private String userName;
   
    
    @Size(min = 1, max = 20)
    @Column(name = "full_name")
    private String fullName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
   
    
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
   
    
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
   
    
    @Size(min = 1, max = 20)
    @Column(name = "mobile_no")
    private String mobileNo;
    @Size(max = 20)
    @Column(name = "day")
    private String day;
    @Size(max = 20)
    @Column(name = "month")
    private String month;
    @Size(max = 20)
    @Column(name = "male")
    private String male;
    @Size(max = 20)
    @Column(name = "female")
    private String female;
   
    
    @Column(name = "created_date",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "modified_date",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "userId")
    private List<UserRole> userRoleList;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(long id, String userName, String fullName, String email, String password, String mobileNo, Date createdDate) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.createdDate = createdDate;
    }

    public User(long id, String rajeshgmailcom, String admin, boolean b) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public void setRoles(HashSet<Role> roles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
