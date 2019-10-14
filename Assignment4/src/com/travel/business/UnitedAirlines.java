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
public class UnitedAirlines {
    private static DeltaAirlines utLists;

    public List<Flight> utList;
    
    public UnitedAirlines(){
        utList = new ArrayList<>();
        
        Flight flight1 = new Flight("UnitedAirlines", "#6701","Boston", "New York City", "2019/12/15 8:30am");
        Flight flight2 = new Flight("UnitedAirlines", "#6702","New York City", "Los Angeles", "2019/12/15 11:25am");
        Flight flight3 = new Flight("UnitedAirlines", "#6703","Houston", "Chicago", "2019/12/15 9:15am");
        Flight flight4 = new Flight("UnitedAirlines", "#6704","Chicago", "Phoenix", "2019/12/15 12:35pm");
        Flight flight5 = new Flight("UnitedAirlines", "#6705","Philadephia", "Dallas", "2019/12/15 6:50pm");
        Flight flight6 = new Flight("UnitedAirlines", "#6706","San Jose", "San Diego", "2019/12/15 10:15pm");

        utList.add(flight1);
        utList.add(flight2);
        utList.add(flight3);
        utList.add(flight4);
        utList.add(flight5);
        utList.add(flight6);
      
    }
}
