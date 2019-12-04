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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lihang
 */
public class UserBiz {

    public static boolean add(User u) {
        String sql = "insert into user(username,passwd,firstname,lastname,role) values(?,?,?,?,?)";
        Object[] params = {u.getUsername(), u.getPasswd(), u.getFirstName(), u.getLastName(), u.getRole()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean addWithCompany(User u) {
        String sql = "insert into user(username,passwd,firstname,lastname,companyname,role) values(?,?,?,?,?,?)";
        Object[] params = {u.getUsername(), u.getPasswd(), u.getFirstName(), u.getLastName(), u.getCompanyName(), u.getRole()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean delete(User u) {
        //soft delete using column 'state'
        String sql = "update user set state=0 where username=?";
        Object[] params = {u.getUsername()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean update(User u) {
        //soft delete using column 'state'
        String sql = "update user set username=?, passwd=?, firstname=?, lastname=?, companyname=?, role=? where id=?";
        Object[] params = {u.getUsername(), u.getPasswd(), u.getFirstName(), u.getLastName(), u.getCompanyName(), u.getRole(), u.getId()};
        return Dao.getInstance().update(sql, params);
    }

    public static List<User> getAll() {
        String sql = "select * from user where state=1";
        return Dao.getInstance().query(sql, User.class);
    }

    public static User getUser(String username) {
        String sql = "select * from user where username=? and state=1";
        Object[] params = {username};
        return (User) Dao.getInstance().get(sql, User.class, params);
    }

    public void addApartment(ApartmentUser a) {
        UserBiz.add(a);
    }

    /*    
    public ApartmentUser addApartment(String uname, String pw,) {
        ApartmentUser a = new ApartmentUser(uname, pw);
        apartmentList.add(a);
        return a;
    }
     */
    public void deleteAdmin(ApartmentUser a) {
        UserBiz.delete(a);
    }

    public boolean isEmpty() {
        return getAll().isEmpty();
    }

}
