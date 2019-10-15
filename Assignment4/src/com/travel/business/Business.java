/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import com.travel.interfaces.MainFrame;
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
    private final FlightDirectory flightDirectory = new FlightDirectory();
    private final AircraftList aircraftList = new AircraftList();
    private MainFrame mFrame;

    public Business() {
        this.admins.addAdmin(new Admin("Administrator", "admin",
                this.airliners, this.customers));
        this.customers.addCustomer("Lwh", "lwh", "Lynn", "Appleseed");
        this.airliners.addAirliner("Delta", "delta", "Delta");
        this.airliners.addAirliner("Test", "test", "test");
        
        
    }

    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }

    public FlightDirectory getFlightDirectory() {
        return flightDirectory;
    }

    

    public AircraftList getAircraftList() {
        return aircraftList;
    }

    

    public AdminList getAdmins() {
        return admins;
    }

    public MainFrame getMainFrame() {
        return mFrame;
    }

    public void setMainFrame(MainFrame mf) {
        mFrame = mf;
    }

    public AirlinerList getAirliners() {
        return airliners;
    }

    public CustomerList getCustomers() {
        return customers;
    }

    public Date getNow() {
        return new Date();
    }

    public Date getToday() {
        Date today = new Date();

        return today;
    }

}
