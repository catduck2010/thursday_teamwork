/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.CleaningCompUser;
import com.thursday.business.identities.User;
import com.thursday.util.db.UserBiz;
import java.util.List;

/**
 *
 * @author lihang
 */
public class UserDirectory {

    //it doesn't include any lists anymore
    //it becomes a set of actions that manipulates users
    public static boolean createApartmentUser(String username, char[] passwd, String name, String last, String role) {
        User u = new ApartmentUser(username, passwd, name, last, role);
        return UserBiz.add(u);
    }

    public static boolean createApartmentUser(String company, String username, char[] passwd, String name, String last, String role) {
        User u = new ApartmentUser(company, username, passwd, name, last, role);
        return UserBiz.addWithCompany(u);
    }

    public static boolean createCleaningCompUser(String username, char[] passwd, String name, String last, String role) {
        User u = new CleaningCompUser(username, passwd, name, last, role);
        return UserBiz.add(u);
    }

    public static boolean createCleaningCompUser(String company, String username, char[] passwd, String name, String last, String role) {
        User u = new CleaningCompUser(company, username, passwd, name, last, role);
        return UserBiz.addWithCompany(u);
    }

    public static User authenticateUser(String uname, char[] passwd) {
        User u = UserBiz.getUser(uname);
        if (u != null && u.authenticate(passwd)) {
            return u;
        }
        return null;
    }

    public static boolean updateUser(User u) {
        return UserBiz.update(u);
    }

    public static boolean deleteUser(User u) {
        return UserBiz.delete(u);
    }

    public static boolean checkUsernameExistance(String username) {
        return UserBiz.getUser(username) != null;
        //false: username available
        //true: username exists
    }

    public static boolean isApartmentUser(User u) {
        String role = u.getRole();
        switch (role) {
            case ApartmentUser.Roles.ADMIN:
                return true;
            case ApartmentUser.Roles.REPAIRPERSON:
                return true;
            case ApartmentUser.Roles.RESIDENT:
                return true;
        }
        return false;
    }

    public static boolean isCleaningCompUser(User u) {
        String role = u.getRole();
        switch (role) {
            case CleaningCompUser.Roles.CLEANER:
                return true;
            case CleaningCompUser.Roles.HR:
                return true;
            case CleaningCompUser.Roles.SCHEDULER:
                return true;
        }
        return false;
    }

    public static User getUser(String username) {
        return UserBiz.getUser(username);
    }
    public static List<User> getUserOf(String role){
        return UserBiz.getUserOf(role);
    }
    
    public static List<User> getCompanyStaff(String company){
        return UserBiz.getUserWithCondition("companyname=?", company);
    }
}
