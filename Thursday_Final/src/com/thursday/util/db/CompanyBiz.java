/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util.db;

import com.thursday.business.enterprise.Company;
import com.thursday.business.enterprise.Company;
import com.thursday.util.db.Dao;
import java.util.List;

/**
 *
 * @author lihang
 */
public class CompanyBiz {

    public static boolean add(Company c) {
        String sql = "insert into company(companyname,type,adminuser) values(?,?,?)";
        Object[] params = {c.getCompanyName(), c.getType(), c.getAdminUser()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean delete(Company c) {
        String sql = "update company set state=0 where companyname=?";
        Object[] params = {c.getCompanyName()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean update(Company c) {
        String sql = "update company set companyname=?, type=?, adminuser=? where id=?";
        Object[] params = {c.getCompanyName(), c.getType(), c.getAdminUser(), c.getId()};
        return Dao.getInstance().update(sql, params);
    }

    public static List<Company> getApartments() {
        String sql = "select * from company where type=? and state=1 "
                + "order by companyname";
        Object[] params = {Company.Type.APARTMENT};
        return Dao.getInstance().query(sql, Company.class, params);
    }

    public static List<Company> getCleaningCompanies() {
        String sql = "select * from company where type=? and state=1 "
                + "order by companyname";
        Object[] params = {Company.Type.CLEANING};
        return Dao.getInstance().query(sql, Company.class, params);
    }

    public static Company getCompany(String name) {
        String sql = "select * from company where companyname=? and state=1";
        Object[] params = {name};
        return (Company) Dao.getInstance().get(sql, Company.class, params);
    }

}
