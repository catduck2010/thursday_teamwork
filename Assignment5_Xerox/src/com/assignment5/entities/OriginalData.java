/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

/**
 *
 * @author andy
 */
public class OriginalData {
    int productID;
    double average;
    double target;
    double difference;

    public OriginalData(int productID, double average, double target, double difference) {
        this.productID = productID;
        this.average = average;
        this.target = target;
        this.difference = difference;
    }

    public OriginalData() {
    }
    

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }
    
    @Override
    public String toString(){
    return productID + "          |" + average + "      |" + target + "       |" + difference;
}
    
}
