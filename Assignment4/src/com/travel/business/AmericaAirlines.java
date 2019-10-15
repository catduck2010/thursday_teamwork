/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CHEN JIEYING
 */
public class AmericaAirlines {
    
    private static AmericaAirlines aaLists;

    public List<Flight> aaList;
    
    public AmericaAirlines(){
        aaList = new ArrayList<>();
        
        Flight flight1 = new Flight("AmericaAirlines", "#4001","Boston", "New York City", "2019/12/15 8:30am");
        Flight flight2 = new Flight("AmericaAirlines", "#4002","New York City", "Los Angeles", "2019/12/15 11:25am");
        Flight flight3 = new Flight("AmericaAirlines", "#4003","Houston", "Chicago", "2019/12/15 9:15am");
        Flight flight4 = new Flight("AmericaAirlines", "#4004","Chicago", "Phoenix", "2019/12/15 12:35pm");
        Flight flight5 = new Flight("AmericaAirlines", "#4005","Philadephia", "Dallas", "2019/12/15 6:50pm");
        Flight flight6 = new Flight("AmericaAirlines", "#4006","San Jose", "San Diego", "2019/12/15 10:15pm");

        aaList.add(flight1);
        aaList.add(flight2);
        aaList.add(flight3);
        aaList.add(flight4);
        aaList.add(flight5);
        aaList.add(flight6);
      
    }
 /*   
    public Date(date time){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current = sdf.format(System.currentTimeMillis());
        String flightTime = current + 30*60*1000;
        //lblUpdateTime.setText(String.valueOf(flightTime));
        return Date(flightTime);
    }
  */  
}
