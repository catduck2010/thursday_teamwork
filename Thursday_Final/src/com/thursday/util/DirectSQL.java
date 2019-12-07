/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util;

import com.thursday.business.Company;
import com.thursday.util.db.CompanyBiz;

/**
 *
 * @author lihang
 */
public class DirectSQL {

    public static void main(String[] args) {
//        System.out.println(CompanyDirectory.createCleaningComp("Elizabeth's Cleaning", "ecladmin", "admin".toCharArray()));
//        System.out.println(UserDirectory.createApartmentUser("AMY's Room","amyjoseph", "amyjoseph".toCharArray(), "Amy", "Joseph", ApartmentUser.Roles.RESIDENT))
        Company c = CompanyBiz.getCompany("LP clc");
        System.out.println(CompanyBiz.hardDelete(c));

    }
}
