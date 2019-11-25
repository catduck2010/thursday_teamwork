/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util;

import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.ApartmentUserBiz;
import com.thursday.business.identities.User;

/**
 *
 * @author lihang
 */
public class DirectSQL {
    public static void main(String[] args){
        //User u=new ApartmentUser("admin", "admin".toCharArray(), "Zero", "Administrator", "ADMIN");
        //ApartmentUserBiz.add(u);
        User u=ApartmentUserBiz.getUser("admin");
        System.out.println(u.getPasswd());
        System.out.println(u.authenticate("admin".toCharArray()));
    }
}
