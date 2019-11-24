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

    private Employee employee;

    public User(String username, char[] passwd, Employee e) {
        super(username, passwd);
        this.employee = e;
    }
    
    
    

}
