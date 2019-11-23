/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import com.thursday.util.PasswordUtil;

/**
 *
 * @author lihang
 */
public abstract class User {

    private String username;
    private String passwdHash;

    public User(String username, char[] passwd) {
        this.username = username;
        this.passwdHash = PasswordUtil.hash(passwd);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean setPasswd(char[] oldpw, char[] passwd) {
        if (this.authenticate(oldpw)) {
            this.passwdHash = PasswordUtil.hash(passwd);
            return true;
        }
        return false;
    }

    public boolean authenticate(char[] passwd) {
        return PasswordUtil.authenticate(passwd, passwdHash);
    }
}
