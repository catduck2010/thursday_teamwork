/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util.db;

import com.thursday.business.Company;
import com.thursday.business.Company;
import com.thursday.util.db.Dao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lihang
 */
public class CompanyBiz {

    public static boolean add(Company c) throws SQLException{
        String sql = "insert into company(companyname,type,adminuser) values(?,?,?)";
        Object[] params = {c.getCompanyName(), c.getType(), c.getAdminUser()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean delete(Company c) throws SQLException{
        String sql = "update company set state=0 where companyname=?";
        Object[] params = {c.getCompanyName()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean hardDelete(Company c)throws SQLException {
        String sql1 = "update workrequest set state=0 where sender in ("
                + "select username from apartment.`user` where companyname=?"
                + ") or receiver in ("
                + "SELECT username from apartment.`user` where companyname=?)";
        String sql2 = "update task set state=0 WHERE creator in("
                + "select username from apartment.`user` where companyname=?)";
        String sql3 = "update apartment.`user` set state=0 WHERE companyname=?";
        String sql4 = "update company set state=0 where companyname=?";
        String[] sqls={sql1,sql2,sql3,sql4};
        Object[][] params = {{c.getCompanyName(), c.getCompanyName()},{c.getCompanyName()},{c.getCompanyName()},{c.getCompanyName()}};

        return Dao.getInstance().commit(sqls, params);
    }

    public static boolean update(Company c) throws SQLException{
        String sql = "update company set companyname=?, type=?, adminuser=? where id=?";
        Object[] params = {c.getCompanyName(), c.getType(), c.getAdminUser(), c.getId()};
        return Dao.getInstance().update(sql, params);
    }

    public static List<Company> getApartments()throws SQLException {
        String sql = "select * from company where type=? and state=1 "
                + "order by companyname";
        Object[] params = {Company.Type.APARTMENT};
        return Dao.getInstance().query(sql, Company.class,
                 params);
    }

    public static List<Company> getAllCompanies()throws SQLException {
        String sql = "select * from company where state=1 "
                + "order by companyname";
        return Dao.getInstance().query(sql, Company.class
        );
    }

    public static List<Company> getCleaningCompanies() throws SQLException{
        String sql = "select * from company where type=? and state=1 "
                + "order by companyname";
        Object[] params = {Company.Type.CLEANING};
        return Dao.getInstance().query(sql, Company.class,
                 params);
    }

    public static Company getCompany(String name) throws SQLException{
        String sql = "select * from company where companyname=? and state=1";
        Object[] params = {name};
        return (Company) Dao.getInstance().get(sql, Company.class,
                 params);
    }

}
