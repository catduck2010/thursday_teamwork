/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.enterprise;

import com.thursday.business.enterprise.Company;
import com.thursday.util.dao.Dao;
import java.util.List;

/**
 *
 * @author lihang
 */
public class CompanyBiz {

    public static boolean add(Company c) {
        String sql = "insert into company(companyname,type) values(?,?)";
        Object[] params = {c.getCompanyName(), c.getType()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean delete(Company c) {
        String sql = "update company set state=0 where companyname=?";
        Object[] params = {c.getCompanyName()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean update(Company c) {
        String sql = "update company set companyname=?, type=? where id=?";
        Object[] params = {c.getCompanyName(), c.getType(), c.getId()};
        return Dao.getInstance().update(sql, params);
    }
    
    public static List getApartments(){
        String sql="select * from company where type=? order by companyname";
        Object[] params={Company.Type.APARTMENT};
        return Dao.getInstance().query(sql, Company.class, params);
    }
    
    public static List getCleaningCompanies(){
        String sql="select * from company where type=? order by companyname";
        Object[] params={Company.Type.CLEANING};
        return Dao.getInstance().query(sql, Company.class, params);
    }

}
