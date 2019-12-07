/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import com.thursday.business.identities.User;
import com.thursday.interfaces.MainFrame;

/**
 *
 * @author lihang
 */
public class EcoSystem extends AbstractEcoSystem {

    private static EcoSystem business;
    private static User currentUser;
    private static boolean loggedIn = false;
    private static MainFrame mainFrame;

    private EcoSystem() {
        super();
    }

    public static EcoSystem newInstance() {
        business = new EcoSystem();
        System.out.println(business);
        return business;
    }

    public static String getSessionId() {
        return business.sessionId();
    }

    public static void login(User u) {
        currentUser = u;
        loggedIn = true;
        mainFrame.setLoggedIn(loggedIn);
    }

    public static void logout() {
        currentUser = null;
        loggedIn = false;
        mainFrame.setLoggedIn(loggedIn);
        mainFrame.logOut();
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setMainFrame(MainFrame mf) {
        mainFrame = mf;
    }
    
    public static void resetPressTime(){
        mainFrame.resetPressTime();
    }

    public static User getCurrentUser() {
        return currentUser;
    }

}
