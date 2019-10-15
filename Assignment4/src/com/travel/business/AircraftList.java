/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import java.util.ArrayList;

/**
 *
 * @author andy
 */
public class AircraftList {
    private final ArrayList<Aircraft> aircraftDir;
    
    public AircraftList() {
        this.aircraftDir = new ArrayList<>();
    }

    public ArrayList<Aircraft> getAircraftDir() {
        return aircraftDir;
    }
    public Aircraft addAircraft(){
        Aircraft newAircraft = new Aircraft();
        aircraftDir.add(newAircraft);
        return newAircraft;
    }
    public void deleteAircraft(Aircraft aircraft){
        aircraftDir.remove(aircraft);
        
    }
    public boolean sameModelNum(String modelNum){
        boolean b = false;
        for(Aircraft aircraft : aircraftDir){
            
                if(aircraft.getModelNum().equals(modelNum))
                { 
                    b = true;
                    break;
                }               
            
        }
        return b;
    }
    
    
    
    
}
