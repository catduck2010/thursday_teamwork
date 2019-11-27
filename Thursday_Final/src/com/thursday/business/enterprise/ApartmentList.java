/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.enterprise;

import com.thursday.business.identities.ApartmentUser;
import java.util.ArrayList;

/**
 *
 * @author CHEN JIEYING
 */
public class ApartmentList {
    private final ArrayList<ApartmentUser> apartmentList;
    
    public ApartmentList() {
        this.apartmentList = new ArrayList<>();
    }
    
    public ArrayList<ApartmentUser> getApartmentList() {
        return apartmentList;
    }

    
    public void addApartment(ApartmentUser a) {
        apartmentList.add(a);
    }
/*    
    public ApartmentUser addApartment(String uname, String pw,) {
        ApartmentUser a = new ApartmentUser(uname, pw);
        apartmentList.add(a);
        return a;
    }
*/
    public void deleteAdmin(ApartmentUser a) {
        apartmentList.remove(a);
    }


    public boolean isEmpty() {
        return apartmentList.isEmpty();
    }
    
    public ApartmentUser getAdmin(String username){
        for(ApartmentUser a:apartmentList){
            if(a.getUsername().equals(username)){
                return a;
            }
        }
        return null;
    }
}
