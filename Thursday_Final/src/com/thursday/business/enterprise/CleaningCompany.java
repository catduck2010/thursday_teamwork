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
public class CleaningCompany extends Enterprise {

    public CleaningCompany(String name) {
        super(name, EnterpriseType.CleaningCompany);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
