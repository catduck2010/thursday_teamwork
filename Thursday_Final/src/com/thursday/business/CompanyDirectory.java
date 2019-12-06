/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import com.thursday.business.enterprise.Company;
import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.CleaningCompUser;
import com.thursday.business.identities.User;
import com.thursday.util.db.CompanyBiz;
import java.util.List;

/**
 *
 * @author lihang
 */
public class CompanyDirectory {

    //1 addadmin
    //2 add company
    //3 set admin's company
    public static boolean createApartment(String name, String admin, char[] pw) {
        if (getCompany(name) != null) {
            return false;
        }
        UserDirectory.createApartmentUser(admin, pw, "One", "Administrator", ApartmentUser.Roles.ADMIN);
        Company c = new Company(name, Company.Type.APARTMENT, admin);
        if (CompanyBiz.add(c)) {
            User u = UserDirectory.getUser(admin);
            if (u != null) {
                u.setCompanyName(name);
                return UserDirectory.updateUser(u);
            }
        }
        return false;
    }

    public static boolean createCleaningComp(String name, String admin, char[] pw) {
        if (getCompany(name) != null) {
            return false;
        }
        UserDirectory.createCleaningCompUser(admin, pw, "One", "Administrator", CleaningCompUser.Roles.HR);
        Company c = new Company(name, Company.Type.CLEANING, admin);
        if (CompanyBiz.add(c)) {
            User u = UserDirectory.getUser(admin);
            if (u != null) {
                u.setCompanyName(name);
                return UserDirectory.updateUser(u);
            }
        }
        return false;
    }

    public static Company getCompany(String name) {
        return CompanyBiz.getCompany(name);
    }

    public static List<Company> getApartments() {
        return CompanyBiz.getApartments();
    }

    public static List<Company> getCleaningCompanies() {
        return CompanyBiz.getCleaningCompanies();
    }
    
    public static List<Company> getAllCompanies(){
        return CompanyBiz.getAllCompanies();
    }
    
    
}
