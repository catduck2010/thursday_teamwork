/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import com.travel.users.User;
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
    private Traveler[][] travelerTable;
    private String flightNum;
    private final ArrayList<Traveler> travelers = new ArrayList<>();

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public Flight() {
        generateSeatTable();

    }

    public Object[][] getTravelerTable() {
        return this.travelerTable;
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

    private void generateSeatTable() {
        travelerTable = new Traveler[ROW][COL];
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

    private void setValueToTable(int row, int col, Traveler value) {
        travelerTable[row][col] = value;
    }

    private void setOccupiedAt(int row, int col, Traveler traveler) {
        setValueToTable(row, col, traveler);
    }

    private void setEmptyAt(int row, int col) {
        setValueToTable(row, col, null);
    }

    public void pickSeat(String seat, Traveler traveler) {
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

    private char returnColumn(int c) {
        switch (c) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'H';
            case 4:
                return 'J';
            case 5:
                return 'K';

        }
        return '\0';
    }

    @Override
    public String toString() {
        return flightNum;
    }



    public String getTravelerSeat(Traveler t) {
        int i = 0, j = 0;
        for (Traveler[] row : travelerTable) {
            j = 0;
            for (Traveler s : row) {
                if (s != null) {
                    if (s.equals(t)) {
                        return String.valueOf(i + 1)
                                + String.valueOf(returnColumn(j));
                    }
                }
                j++;
            }
            i++;
        }
        return "";
    }

    public ArrayList<Traveler> getTravelers(User u) {
        ArrayList<Traveler> tr = new ArrayList<>();

        for (Traveler[] row : travelerTable) {
            for (Traveler t : row) {
                if (t != null) {
                    if (t.getOrderPlacedBy().equals(u)) {
                        tr.add(t);
                    }
                }
            }
        }
        return tr;
    }

    public Flight(String airliner, String flight, String from, String to, String date) {
        this.airliner = airliner;
        this.flightNo = flight;
        this.departure = from;
        this.arrival = to;
        this.flightDate = date;

    }
}
