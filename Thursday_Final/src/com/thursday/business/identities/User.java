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

    private String firstName;
    private String lastName;
    private String role;

    public User(String username, char[] passwd, String name, String last, String role) {
        super(username, passwd);
        this.firstName = name;
        this.lastName = last;
        this.role = role;
    }

    public User() {
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "User{" + getUsername() + " " + role + firstName + lastName
                + "}";
    }
}
