/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.CleaningCompUser;
import com.thursday.business.identities.User;
import com.thursday.util.db.CompanyBiz;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lihang
 */
public class CompanyDirectory {

    //1 addadmin
    //2 add company
    //3 set admin's company
    public static boolean createApartment(String name, String admin, char[] pw) throws SQLException {
        if (getCompany(name) != null) {
            return false;
        }
        if (UserDirectory.createApartmentUser(admin, pw, "One", "Administrator", ApartmentUser.Roles.ADMIN)) {
            Company c = new Company(name, Company.Type.APARTMENT, admin);
            User u = UserDirectory.getUser(admin);
            if (CompanyBiz.add(c)) {
                if (u != null) {
                    u.setCompanyName(name);
                    return UserDirectory.updateUser(u);
                }
            } else {
                UserDirectory.deleteUser(u);
            }
        }
        return false;
    }

    public static boolean createCleaningComp(String name, String admin, char[] pw) throws SQLException {
        if (getCompany(name) != null) {
            return false;
        }
        if (UserDirectory.createCleaningCompUser(admin, pw, "One", "Administrator", CleaningCompUser.Roles.HR)) {
            Company c = new Company(name, Company.Type.CLEANING, admin);
            User u = UserDirectory.getUser(admin);
            if (CompanyBiz.add(c)) {
                if (u != null) {
                    u.setCompanyName(name);
                    return UserDirectory.updateUser(u);
                }
            } else {
                UserDirectory.deleteUser(u);
            }
        }
        return false;
    }

    public static Company getCompany(String name) throws SQLException {
        return CompanyBiz.getCompany(name);
    }

    public static boolean deleteCompany(String name) throws SQLException {
        Company c = CompanyBiz.getCompany(name);
        return c == null ? false : CompanyBiz.hardDelete(c);
    }

    public static boolean deleteCompany(Company comp) throws SQLException {
        return CompanyBiz.hardDelete(comp);
    }

    public static boolean updateCompany(Company c) throws SQLException {
        return CompanyBiz.update(c);
    }

    public static List<Company> getApartments() throws SQLException {
        return CompanyBiz.getApartments();
    }

    public static List<Company> getCleaningCompanies() throws SQLException {
        return CompanyBiz.getCleaningCompanies();
    }

    public static List<Company> getAllCompanies() throws SQLException {
        return CompanyBiz.getAllCompanies();
    }

    public static boolean checkCompanyExistance(String name) throws SQLException {
        return getCompany(name) != null;
    }
}
