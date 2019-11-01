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

    private String firstName;
    private String lastName;
    private String ID;
    private User orderPlacedBy;
    private Flight flight;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public Traveler(String firstName, String lastName, String ID, User orderPlacedBy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.orderPlacedBy = orderPlacedBy;
    }

    public Traveler(String firstName, String lastName, String ID, User orderPlacedBy, Flight f) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.orderPlacedBy = orderPlacedBy;
        this.flight = f;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public User getOrderPlacedBy() {
        return orderPlacedBy;
    }

    public void setOrderPlacedBy(User orderPlacedBy) {
        this.orderPlacedBy = orderPlacedBy;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
   

}
