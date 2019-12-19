/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

/**
 *
 * @author lihang
 */
public class Company {

    private Integer id;
    private String companyName;
    private String type;
    private String adminUser;

    public class Type {

        public final static String APARTMENT = "APT";
        public final static String CLEANING = "CLC";
    }

    public Company(String name, String type) {
        this();
        this.companyName = name;
        this.type = type;
    }

    public Company(String name, String type, String adminUser) {
        this();
        this.companyName = name;
        this.type = type;
        this.adminUser = adminUser;
    }

    public Company() {

    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getCompanyName();
    }

}
