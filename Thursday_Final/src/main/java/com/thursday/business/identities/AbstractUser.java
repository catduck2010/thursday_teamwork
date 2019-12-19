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
    private Integer id;
    private String username;
    private String passwd;

    public AbstractUser() {

    }

    
    public AbstractUser(String username, char[] passwd) {
        this.username = username;
        this.passwd = PasswordUtil.hash(passwd);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setPasswd(String pw) {
        this.passwd = pw;
    }

    public boolean resetPasswd(char[] oldpw, char[] newpw) {
        if (this.authenticate(oldpw)) {
            this.passwd = PasswordUtil.hash(newpw);
            return true;
        }
        return false;
    }

    public boolean authenticate(char[] passwd) {
        return PasswordUtil.authenticate(passwd, this.passwd);
    }
    
    public abstract String getUserType();

}
