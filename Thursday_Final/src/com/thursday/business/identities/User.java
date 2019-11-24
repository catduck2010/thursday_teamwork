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
public class User extends AbstractUser {

    private String name;
    private String role;

    public User(String username, char[] passwd, String name, String role) {
        super(username, passwd);
        this.name = name;
        this.role = role;
    }

}
