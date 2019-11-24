/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.enterprise;

import com.thursday.business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author lihang
 */
public class Apartment extends Enterprise {

    public Apartment(String name) {
        super(name, EnterpriseType.Apartment);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
