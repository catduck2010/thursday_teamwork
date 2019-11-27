/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util;

import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.ApartmentUserBiz;
import com.thursday.business.identities.CleaningCompUser;
import com.thursday.business.identities.CleaningCompUserBiz;
import com.thursday.business.identities.User;

/**
 *
 * @author lihang
 */
public class DirectSQL {
    public static void main(String[] args){
        //User u=new CleaningCompUser("admin", "admin".toCharArray(), "Zero", "Administrator", "ADMIN");
        //User u=CleaningCompUserBiz.getUser("admin");
        //CleaningCompUserBiz.add(u);
        System.out.println(ApartmentUser.existUsername("admin"));
        //System.out.println(ApartmentUser.Roles.ADMIN);
    }
}
