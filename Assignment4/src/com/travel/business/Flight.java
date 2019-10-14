/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import java.util.Date;

/**
 *
 * @author lihang
 */
public class Flight {

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
    private int[][] seatTable;
    

    private CustomerList onBoard;

    public Flight() {
        generateSeatTable();
    }

    public void generateSeatTable() {
        seatTable = new int[25][6];
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
    
    public Flight(String airliner, String flight, String from, String to, String date) {
        this.airliner = airliner;
        this.flightNo = flight;
        this.departure = from;
        this.arrival = to;
        this.flightDate = date;
           
    }
}
