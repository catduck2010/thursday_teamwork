/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.users;

/**
 *
 * @author lihang
 */
public abstract class User {

    public final static int ADMINISTRATOR = 0;
    public final static int AIRLINER = 1;
    public final static int CUSTOMER = 2;

    private String username;
    private String passwd;
    private final int userType;

    public User(String uname, String pw, int type) {
        this.username = uname;
        this.passwd = pw;
        this.userType = type;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public int getUserType() {
        return userType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean verify(String txtuser, String txtPswd) {
        return this.username.equals(txtuser) && this.passwd.equals(txtPswd);
    }

    public boolean verify(String pswd) {
        return this.passwd.equals(pswd);
    }

    public boolean isCustomer() {
        return userType == User.CUSTOMER;
    }

    public boolean isAdmin() {
        return userType == User.ADMINISTRATOR;
    }

    public boolean isAirliner() {
        return userType == User.AIRLINER;
    }
}
