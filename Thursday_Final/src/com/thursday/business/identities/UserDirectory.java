/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.identities;

import java.util.ArrayList;
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

    public static boolean createCleaningCompUser(String username, char[] passwd, String name, String last, String role) {
        User u = new CleaningCompUser(username, passwd, name, last, role);
        return UserBiz.add(u);
    }

    public static User authenticateUser(String uname, char[] passwd) {
        User u = UserBiz.getUser(uname);
        if (u != null && u.authenticate(passwd)) {
            return u;
        }
        return null;
    }

    public static boolean checkUsernameExistance(String username) {
        return UserBiz.getUser(username) == null;
        //true: username available
        //false: username exists
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
}
