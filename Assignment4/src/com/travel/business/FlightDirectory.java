/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lihang
 */
public class FlightDirectory {

    private final ArrayList<Flight> flightDir;

    public FlightDirectory() {
        this.flightDir = new ArrayList<>();
    }

    public ArrayList<Flight> getFlightDir() {
        return flightDir;
    }
    
    public Flight addFlight(){
        Flight newFlight = new Flight();
        flightDir.add(newFlight);
        return newFlight;
    }
    public void deleteFlight(Flight flight){
        flightDir.remove(flight);
        
    }
    
    public boolean sameFlightNum(String flightNum){
        boolean b = false;
        for(Flight flight : flightDir){
            if(flightDir.size() != 0){
                if(flight.getFlightNum() == flightNum)
                b = true;
                
            } 
        }
        return b;
    }
    
    public boolean checkTakeOffTime(Date takeOffTime, String modelNum){
        boolean b = true;
        for(Flight flight : flightDir){
            if(flightDir.size() != 0 && flight.getModelNum() == modelNum){
                if(takeOffTime.before(flight.getLandTime()) && takeOffTime.after(flight.getTakeOffTime()))
                b = false;
                
            } 
        }
        return b;
    }
    
    public boolean checkLandTime(Date landTime, String modelNum){
        boolean b = true;
        for(Flight flight : flightDir){
            if(flightDir.size() != 0 && flight.getModelNum() == modelNum){
                if(landTime.before(flight.getLandTime()) && landTime.after(flight.getTakeOffTime()))
                b = false;
                
            } 
        }
        return b;
    }
    

}
