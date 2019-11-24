/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.identities;

import com.thursday.util.PasswordUtil;

/**
 *
 * @author lihang
 */
public abstract class AbstractUser {
    private String id;
    private String username;
    private String passwd;

    public AbstractUser(String username, char[] passwd) {
        this.username = username;
        this.passwd = PasswordUtil.hash(passwd);
    }

    public String getId() {
        return id;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean setPasswd(char[] oldpw, char[] newpw) {
        if (this.authenticate(oldpw)) {
            this.passwd = PasswordUtil.hash(newpw);
            return true;
        }
        return false;
    }

    public boolean authenticate(char[] passwd) {
        return PasswordUtil.authenticate(passwd, this.passwd);
    }
    
    
}
