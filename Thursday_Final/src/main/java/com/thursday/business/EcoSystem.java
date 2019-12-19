/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import com.thursday.business.identities.User;
import com.thursday.interfaces.MainFrame;
import java.awt.Font;
import javax.swing.UIManager;

/**
 *
 * @author lihang
 */
public class EcoSystem extends AbstractEcoSystem {

    private static EcoSystem business;
    private static User currentUser;
    private static boolean loggedIn = false;
    private static MainFrame mainFrame;
    private final static javax.swing.plaf.FontUIResource macFontUIResource
            = new javax.swing.plaf.FontUIResource(
                    "SF Pro Text",
                    Font.PLAIN,
                    13);
    private final static javax.swing.plaf.FontUIResource winFontUIResource
            = new javax.swing.plaf.FontUIResource(
                    "Microsoft Yahei UI",
                    Font.PLAIN,
                    13);

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

    public static void resetPressTime() {
        mainFrame.resetPressTime();
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, f);
            }
        }
    }

    public static void setUIFont() {
        String osname = System.getProperty("os.name");
        if (osname.contains("OS X")) {
            setUIFont(macFontUIResource);
        } else {
            setUIFont(winFontUIResource);
        }

    }

}
