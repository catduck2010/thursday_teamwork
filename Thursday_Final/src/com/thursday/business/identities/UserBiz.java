/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.identities;

import com.thursday.util.dao.Dao;
import java.util.List;

/**
 *
 * @author lihang
 */
public class UserBiz {

    public static boolean add(User u) {
        String sql = "insert into user(username,password) values(?,?)";
        Object[] params = {u.getUsername(), u.getPasswd()};
        return Dao.update(sql, params);
    }

    public static boolean delete(User u) {
        //soft delete using column 'state'
        String sql = "update user set state=0 where id=?";
        Object[] params = {u.getId()};
        return Dao.update(sql, params);
    }

    public static List getAll() {
        String sql = "select * from user where state=1";
        return Dao.query(sql, User.class);
    }

    public static User getUser(String username) {
        String sql = "select * from user where username=? and state=1";
        Object[] params = {username};
        return (User) Dao.get(sql, User.class, params);
    }

}
