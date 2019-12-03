/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.identities;

import com.thursday.util.db.UserBiz;
import java.util.List;

/**
 *
 * @author lihang
 */
public class ApartmentUser extends User {

    public ApartmentUser(String username, char[] passwd, String name, String last, String role) {
        super(username, passwd, name, last, role);
    }

    public class Roles {

        public static final String RESIDENT = "RESIDENT";
        public static final String ADMIN = "ADMIN";
        public static final String REPAIRPERSON = "REPAIR PERSON";

    }

    public static boolean existUsername(String uname) {
        return UserBiz.getUser(uname) != null;
    }
    
    @Override
    public String toString() {
        return "ApartmentUser{" + getUsername() + " " + getRole() + getFirstName() + getLastName()
                + "}";
    }

    @Override
    public String getUserType() {
        return "ApartmentUser";
    }

}
