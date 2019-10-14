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
public class Flight {

    private String modelNum;
    private Date takeOffTime;
    private Date landTime;
    private String departure;
    private String arrival;
    private double ticketPrice;
    private int[][] seatTable;
    private Object[][] travelerTable;
    private String flightNum;
    private final ArrayList<Traveler> travelers;

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    private CustomerList onBoard;

    
    
    public Flight() {
        generateSeatTable();
        travelers=new ArrayList<>();
    }
    
    public ArrayList<Traveler> getTravelers(){
        return travelers;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }


    public Date getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(Date takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public Date getLandTime() {
        return landTime;
    }

    public void setLandTime(Date landTime) {
        this.landTime = landTime;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


 

    

    public void generateSeatTable() {
        seatTable = new int[25][6];
        travelerTable = new Object[25][6];
    }

    public int[][] getSeatTable() {
        return seatTable;
    }

    public void setValueToTable(int row, int col, int value) {
        seatTable[row][col] = value;
    }

    public void setOccupiedAt(int row, int col) {
        setValueToTable(row, col, 1);
    }

    public void setEmptyAt(int row, int col) {
        setValueToTable(row, col, 0);
    }

    public void pickSeat(String seat) {
        char[] s = seat.toCharArray();
        char col = s[s.length - 1];
        int row = Integer.parseInt(seat.substring(0, s.length - 1));
        int column = getColumn(col);
        if (col != -1) {
            setOccupiedAt(row, column);
        }
    }

    public void releaseSeat(String seat) {
        char[] s = seat.toCharArray();
        char col = s[s.length - 1];
        int row = Integer.parseInt(seat.substring(0, s.length - 1));
        int column = getColumn(col);
        if (col != -1) {
            setEmptyAt(row, column);
        }
    }

    private int getColumn(char c) {
        int column = -1;
        switch (c) {
            case 'A':
                column = 0;
                break;
            case 'B':
                column = 1;
                break;
            case 'C':
                column = 2;
                break;
            case 'H':
                column = 3;
                break;
            case 'J':
                column = 4;
                break;
            case 'K':
                column = 5;
                break;

        }
        return column;

    }
    
    @Override
    public String toString(){
        return flightNum;
    }

    public CustomerList getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(CustomerList onBoard) {
        this.onBoard = onBoard;
    }
    
    public void getTravelerSeat(){
        
    }
    
}
