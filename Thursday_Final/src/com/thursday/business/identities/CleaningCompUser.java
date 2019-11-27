/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.identities;

import java.util.List;

/**
 *
 * @author lihang
 */
public class CleaningCompUser extends User {

    public CleaningCompUser(String username, char[] passwd, String name, String last, String role) {
        super(username, passwd, name, last, role);
    }

    public class Role {

        public static final String CLEANER = "CLEANER";
        public static final String HR = "HUMAN RESOURCES";
        public static final String SCHEDULER = "SCHEDULE MAKER";
    }

    public static boolean existUsername(String uname) {
        return CleaningCompUserBiz.getUser(uname)!=null;
    }
}
