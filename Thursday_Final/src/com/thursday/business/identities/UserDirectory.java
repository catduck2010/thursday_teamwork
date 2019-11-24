/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.identities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lihang
 */
public class UserDirectory {

    private final List<User> userDirectory;

    public UserDirectory() {
        userDirectory = new ArrayList<>();
    }

    public List<User> getUserDirectory() {
        return userDirectory;
    }

    public User authenticateUser(String uname, char[] passwd) {
        for (User u : userDirectory) {
            if (u.getUsername().equals(uname) && u.authenticate(passwd)) {
                return u;
            }
        }
        return null;
    }
    

    public boolean checkIfUsernameIsUnique(String username) {
        if (!username.toLowerCase().equals(username)) {
            return false;
        }
        for (User u : userDirectory) {
            if (u.getUsername().toLowerCase().equals(username)) {
                return false;
            }
        }
        return true;
    }
}
