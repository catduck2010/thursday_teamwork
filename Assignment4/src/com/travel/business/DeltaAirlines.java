/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHEN JIEYING
 */
public class DeltaAirlines {
    
    private static DeltaAirlines daLists;

    public List<Flight> daList;
    
    public DeltaAirlines(){
        daList = new ArrayList<>();
        
        Flight flight1 = new Flight("DeltaAirlines", "#5101","Boston", "New York City", "2019/12/15 8:30am");
        Flight flight2 = new Flight("DeltaAirlines", "#5102","New York City", "Los Angeles", "2019/12/15 11:25am");
        Flight flight3 = new Flight("DeltaAirlines", "#5103","Houston", "Chicago", "2019/12/15 9:15am");
        Flight flight4 = new Flight("DeltaAirlines", "#5104","Chicago", "Phoenix", "2019/12/15 12:35pm");
        Flight flight5 = new Flight("DeltaAirlines", "#5105","Philadephia", "Dallas", "2019/12/15 6:50pm");
        Flight flight6 = new Flight("DeltaAirlines", "#5106","San Jose", "San Diego", "2019/12/15 10:15pm");

        daList.add(flight1);
        daList.add(flight2);
        daList.add(flight3);
        daList.add(flight4);
        daList.add(flight5);
        daList.add(flight6);
      
    }
    
}
