/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author lihang
 */
public class AbstractEcoSystem {
    public String sessionId;
    public AbstractEcoSystem() {
        byte[] bytes=new byte[10];
        ThreadLocalRandom.current().nextBytes(bytes);
        sessionId=new String(bytes);
    }
    
    public String sessionId(){
        return sessionId;
    }
}
