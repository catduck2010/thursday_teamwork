/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.identities;

/**
 *
 * @author lihang
 */
public class ApartmentUser extends User{
    
    public ApartmentUser(String username, char[] passwd, String name, String role) {
        super(username, passwd, name, role);
    }
    
    public class Roles{
        public static final String RESIDENT="RESIDENT";
        public static final String ADMIN="ADMIN";
        public static final String REPAIRPERSON="REPAIR PERSON";
    }
    
}
