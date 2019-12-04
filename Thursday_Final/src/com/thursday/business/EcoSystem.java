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

    private EcoSystem() {
        super();
    }

    public static EcoSystem newInstance() {
        business = new EcoSystem();
        System.out.println(business);
        return business;
    }
    
    public static String getSessionId(){
        return business.sessionId();
    }

}
