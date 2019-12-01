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
public class EcoSystem extends AbstractEcoSystem {

    private static EcoSystem business;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }
}
