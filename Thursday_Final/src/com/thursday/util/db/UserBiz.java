/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util.db;

import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.User;
import com.thursday.util.db.Dao;
import com.thursday.util.db.AbstractDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lihang
 */
public class UserBiz {

    public static boolean add(User u)throws SQLException{
        String sql = "insert into user(username,passwd,firstname,lastname,role) values(?,?,?,?,?)";
        Object[] params = {u.getUsername(), u.getPasswd(), u.getFirstName(), u.getLastName(), u.getRole()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean addWithCompany(User u) throws SQLException{
        String sql = "insert into user(username,passwd,firstname,lastname,companyname,role) values(?,?,?,?,?,?)";
        Object[] params = {u.getUsername(), u.getPasswd(), u.getFirstName(), u.getLastName(), u.getCompanyName(), u.getRole()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean delete(User u)throws SQLException {
        //soft delete using column 'state'
        String sql = "update user set state=0 where username=?";
        Object[] params = {u.getUsername()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean update(User u)throws SQLException {
        //soft delete using column 'state'
        String sql = "update user set username=?, passwd=?, firstname=?, lastname=?, companyname=?, role=? where id=?";
        Object[] params = {u.getUsername(), u.getPasswd(), u.getFirstName(), u.getLastName(), u.getCompanyName(), u.getRole(), u.getId()};
        return Dao.getInstance().update(sql, params);
    }

    public static List<User> getAll()throws SQLException {
        String sql = "select * from user where state=1";
        return Dao.getInstance().query(sql, User.class);
    }
    
    public static List<User> getUserWithCondition(String condition, String val)throws SQLException{
        String sql = "select * from user where "+condition+" and state=1";
        Object[] params = {val};
        return Dao.getInstance().query(sql, User.class, params);
    }
    
    public static List<User> getUserOf(String role)throws SQLException{
        String sql = "select * from user where role=? and state=1";
        Object[] params = {role};
        return Dao.getInstance().query(sql, User.class, params);
    }

    public static User getUser(String username) throws SQLException{
        String sql = "select * from user where username=? and state=1";
        Object[] params = {username};
        return (User) Dao.getInstance().get(sql, User.class, params);
    }

    public void addApartment(ApartmentUser a)throws SQLException {
        UserBiz.add(a);
    }

    /*    
    public ApartmentUser addApartment(String uname, String pw,) {
        ApartmentUser a = new ApartmentUser(uname, pw);
        apartmentList.add(a);
        return a;
    }
     */
    public void deleteAdmin(ApartmentUser a) throws SQLException{
        UserBiz.delete(a);
    }

    public boolean isEmpty() throws SQLException{
        return getAll().isEmpty();
    }

}
