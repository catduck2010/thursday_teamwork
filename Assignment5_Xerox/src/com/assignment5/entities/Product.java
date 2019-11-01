/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

/**
 *
 * @author kasai
 */
public class Product {

    private int min;
    private int max;
    private int target;

    public Product(int min, int max, int tg) {
        this.min = min;
        this.max = max;
        this.target = tg;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String toString() {
        return super.toString() + "{max: " + max + ", min: "
                + min + ", target: " + target + "}";
    }
}

