/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import com.travel.users.Admin;
import java.util.Date;

/**
 *
 * @author lihang
 */
public class Business {

    private static Business business = null;
    private final AdminList admins = new AdminList();
    private final AirlinerList airliners = new AirlinerList();
    private final CustomerList customers = new CustomerList();

    public Business() {
        this.admins.addAdmin(new Admin("Administrator", "admin",
                this.airliners, this.customers));
        this.customers.addCustomer("Lwh", "lwh", "Lynn", "Appleseed");
        this.airliners.addAirliner("Delta", "delta", "Delta");
    }

    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }

    public AdminList getAdmins() {
        return admins;
    }

    public AirlinerList getAirliners() {
        return airliners;
    }

    public CustomerList getCustomers() {
        return customers;
    }
    
    public Date getNow(){
        return new Date();
    }
    
    public Date getToday(){
        Date today=new Date();
        
        
    }

}
