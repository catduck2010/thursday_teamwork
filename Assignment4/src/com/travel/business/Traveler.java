/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import com.travel.users.User;

/**
 *
 * @author lihang
 */
public class Traveler {
    String firstName;
    String lastName;
    String ID;
    User orderPlacedBy;
    
    @Override
    public String toString(){
        return firstName+" "+lastName;
    }

    public Traveler(String firstName, String lastName, String ID, User orderPlacedBy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.orderPlacedBy = orderPlacedBy;
    }
    
    
}
