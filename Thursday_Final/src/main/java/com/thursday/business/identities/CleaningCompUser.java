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
public class CleaningCompUser extends User {

    public CleaningCompUser(String username, char[] passwd, String name, String last, String role) {
        super(username, passwd, name, last, role);
    }

    public CleaningCompUser(String company, String username, char[] passwd, String name, String last, String role) {
        super(company, username, passwd, name, last, role);
    }

    public CleaningCompUser() {
    }

    public static class Roles {

        public static final String HR = "HUMAN RESOURCES";
        public static final String CLEANER = "CLEANER";
        public static final String SCHEDULER = "SCHEDULE MAKER";
    }

    @Override
    public String toString() {
        return "CleaningCompUser{" + getUsername() + " " + getRole() + getFirstName() + getLastName()
                + "}";
    }

    @Override
    public String getUserType() {
        return "CleaningCompUser";
    }

}
