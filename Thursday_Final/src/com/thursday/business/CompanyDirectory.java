/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import com.thursday.business.enterprise.Company;
import com.thursday.util.db.CompanyBiz;
import java.util.List;

/**
 *
 * @author lihang
 */
public class CompanyDirectory {

    public static boolean createApartment(String name) {
        if (getCompany(name) != null) {
            return false;
        }
        Company c = new Company(name, Company.Type.APARTMENT);
        return CompanyBiz.add(c);
    }

    public static boolean createCleaningComp(String name) {
        if (getCompany(name) != null) {
            return false;
        }
        Company c = new Company(name, Company.Type.CLEANING);
        return CompanyBiz.add(c);
    }

    public static Company getCompany(String name) {
        return CompanyBiz.getCompany(name);
    }

    public static List getApartments() {
        return CompanyBiz.getApartments();
    }

    public static List getCleaningCompanies() {
        return CompanyBiz.getCleaningCompanies();
    }
}
