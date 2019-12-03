/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.enterprise;

/**
 *
 * @author lihang
 */
public class Company {

    private Integer id;
    private String companyName;
    private String type;

    public class Type {

        public final static String APARTMENT = "APT";
        public final static String CLEANING = "CLC";
    }

    public Company(String name, String type) {
        this();
        this.companyName = name;
        this.type = type;
    }

    public Company() {

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
