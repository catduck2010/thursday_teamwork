/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

/**
 *
 * @author lihang
 */
public class AbstractEcoSystem {

    private static AbstractEcoSystem business;

    public static AbstractEcoSystem getInstance() {
        if (business == null) {
            business = new AbstractEcoSystem();
        }
        return business;
    }

    private AbstractEcoSystem() {

    }
}
