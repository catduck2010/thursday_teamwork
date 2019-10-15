/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import com.travel.users.Airliner;
import java.util.ArrayList;

/**
 *
 * @author lihang
 */
public class AirlinerList {

    private final ArrayList<Airliner> airlinerList;
    private String username;
    
  
    
    public AirlinerList() {
        this.airlinerList = new ArrayList<>();
    }

    public boolean isEmpty() {
        return airlinerList.isEmpty();
    }

    public ArrayList<Airliner> getAirlinerList() {
        return airlinerList;
    }
<<<<<<< HEAD
    
    public void addAirliner(String uname,String pw,String provider){
        Airliner a=new Airliner(uname, pw);
        a.setProviderName(provider);
        airlinerList.add(a);
    }
    
=======

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
>>>>>>> 050ab2de2493d123234d279cd41756a6bb2bbc20
    

}
