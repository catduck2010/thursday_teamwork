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

    private static int ROW = 25;
    private static int COL = 6;

    private String modelNum;
    private int seats;
    private String planeModel;
    private String airliner;
    private String flightNo;
    private String flightDate;
    private Date takeOffTime;
    private Date landTime;
    private String departure;
    private String arrival;
    private double ticketPrice;
    private Object[][] travelerTable;
    private String flightNum;
    private final ArrayList<Traveler> travelers = new ArrayList<>();

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    private CustomerList onBoard;

    public Flight() {
        generateSeatTable();

    }

    public ArrayList<Traveler> getTravelers() {
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

    public String getAirliner() {
        return airliner;
    }

    public void setAirliner(String airliner) {
        this.airliner = airliner;
    }

    public void generateSeatTable() {
        travelerTable = new Object[ROW][COL];
    }

    public int[][] getIntSeatTable() {
        int[][] table = new int[ROW][COL];
        int i = 0;
        for (Object[] row : travelerTable) {
            int j = 0;
            for (Object o : row) {
                table[i][j++] = (o == null) ? 0 : 1;
            }
            i++;
        }

        return table;
    }

    public void setValueToTable(int row, int col, Object value) {
        travelerTable[row][col] = value;
    }

    public void setOccupiedAt(int row, int col, Object traveler) {
        setValueToTable(row, col, 1);
    }

    public void setEmptyAt(int row, int col) {
        setValueToTable(row, col, null);
    }

    public void pickSeat(String seat, Object traveler) {
        char[] s = seat.toCharArray();
        char col = s[s.length - 1];
        int row = Integer.parseInt(seat.substring(0, s.length - 1)) - 1;
        int column = getColumn(col);
        if (column != -1) {
            setOccupiedAt(row, column, traveler);
        }
    }

    public void releaseSeat(String seat) {
        char[] s = seat.toCharArray();
        char col = s[s.length - 1];
        int row = Integer.parseInt(seat.substring(0, s.length - 1)) - 1;
        int column = getColumn(col);
        if (column != -1) {
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
    public String toString() {
        return flightNum;
    }

    public CustomerList getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(CustomerList onBoard) {
        this.onBoard = onBoard;
    }

    public void getTravelerSeat() {

    }

    public Flight(String airliner, String flight, String from, String to, String date) {
        this.airliner = airliner;
        this.flightNo = flight;
        this.departure = from;
        this.arrival = to;
        this.flightDate = date;

    }
}
