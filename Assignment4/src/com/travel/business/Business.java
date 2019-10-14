/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

/**
 *
 * @author lihang
 */
public class Business {
    private static Business business;

    public Business() {
        
    }
    
    public static Business getInstance(){
        if(business==null){
            business=new Business();
        }
        return business;
    }
    
    
}
