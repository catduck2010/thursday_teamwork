/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import com.travel.interfaces.MainFrame;
import com.travel.users.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        this.airliners.addAirliner("Korean", "korean", "Korean Air");
        //default aircraft
        Airliner k = this.airliners.getAirliner("Korean");
        Aircraft aircraft = aircraftList.addAircraft();
        aircraft.setModelNum("KA900");
        aircraft.setAirliner(k.getProviderName());
        aircraft.setModel("BE787");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            //default flight
            Date takeOfftime = sdf.parse("2019-11-01 14:00");
            Date landtime = sdf.parse("2019-11-02 02:00");
            Flight flight = flightDirectory.addFlight();
            flight.setArrival("Seoul");
            flight.setDeparture("Boston");
            flight.setFlightNum("KE689");
            flight.setLandTime(landtime);
            flight.setModelNum("KA900");
            flight.setTakeOffTime(takeOfftime);
            flight.setTicketPrice(Double.parseDouble("900"));
            flight.setAirliner(k.getProviderName());
        } catch (NumberFormatException | ParseException e) {
            System.err.println(e);
        }
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
