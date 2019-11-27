/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.identities;

import com.thursday.util.dao.CleanCompDao;
import java.util.List;

/**
 *
 * @author lihang
 */
public class CleaningCompUserBiz {

    public static boolean add(User u) {
        String sql = "insert into user(username,passwd,firstname,lastname,role) values(?,?,?,?,?)";
        Object[] params = {u.getUsername(), u.getPasswd(), u.getFirstName(), u.getLastName(), u.getRole()};
        return CleanCompDao.getInstance().update(sql, params);
    }

    public static boolean delete(User u) {
        //soft delete using column 'state'
        String sql = "update user set state=0 where username=?";
        Object[] params = {u.getUsername()};
        return CleanCompDao.getInstance().update(sql, params);
    }

    public static List getAll() {
        String sql = "select * from user where state=1";
        return CleanCompDao.getInstance().query(sql, User.class);
    }

    public static User getUser(String username) {
        String sql = "select * from user where username=? and state=1";
        Object[] params = {username};
        return (User) CleanCompDao.getInstance().get(sql, User.class, params);
    }
    
    public static List getAllUsernames(){
        String sql="select username from user where state=1";
        return CleanCompDao.getInstance().query(sql, String.class);
    }

    
/*    
    public void addCleaningComp(CleaningCompUser c) {
        CleaningCompUserBiz.add(c);
    }
   
    public ApartmentUser addApartment(String uname, String pw,) {
        ApartmentUser a = new ApartmentUser(uname, pw);
        apartmentList.add(a);
        return a;
    }

    public void deleteAdmin(CleaningCompUser c) {
        CleaningCompUserBiz.delete(c);
    }

*/
    public boolean isEmpty() {
        return getAll().isEmpty();
    }
  
    
}