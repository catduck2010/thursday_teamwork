/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lihang
 */
public class Validator {

    public static boolean IsEngName(String str) {
        String regex = "^[a-zA-Z]{1,}$";
        return Match(regex, str);
    }

    public static boolean IsChineseChar(String str) {
        String regex = "^[\\u4E00-\\u9FA5]{1,4}$";
        return Match(regex, str);
    }

    public static boolean IsLatLon(String str) {
        //Latitude, Longitude
        String regex = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$";
        return Match(regex, str);
    }

    public static boolean IsSameDay(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return false;
        }
        //return getOnlyDate(d1).equals(getOnlyDate(d2));
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
    }

    public static boolean IsBetweenNums(String str) {
        //a, b or a,b
        String regex = "^[+]{0,1}(\\d+),\\s*[+]{0,1}(\\d+)$";
        return Match(regex, str);
    }

    public static boolean IsYear(String str) {
        String regex = "^\\d{4}$";
        return Match(regex, str);
    }

    public static boolean IsPositiveInt(String str) {
        String regex = "^[1-9]\\d*$";
        return Match(regex, str);
    }

    public static boolean IsNotEmpty(String str) {
        return !(str == null || str.length() <= 0);
    }

    public static boolean IsNotEmpty(char[] c) {
        return !(c == null || c.length <= 0);
    }

    public static boolean IsEmpty(String str) {
        return !IsNotEmpty(str);
    }

    public static boolean IsEmpty(char[] c) {
        return !IsNotEmpty(c);
    }

    public static boolean IsEmail(String str) {
        String regex = "^[a-zA-Z0-9]+_[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+$";
        return Match(regex, str);
    }

    public static boolean IsPassword(String str) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[$*#&])[A-Za-z\\d$*#&]{6,}$";
        return Match(regex, str);
    }

    public static boolean IsPassword(char[] c) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[$*#&])[A-Za-z\\d$*#&]{6,}$";
        return Match(regex, new String(c));
    }

    public static boolean IsSamePassword(String str1, String str2) {
        return str1.equals(str2);
    }

    public static boolean IsSamePassword(char[] pw1, char[] pw2) {
        if (pw1.length != pw2.length) {
            return false;
        }
        for (int i = 0; i < pw1.length; i++) {
            if (pw1[i] != pw2[i]) {
                return false;
            }
        }
        return true;

    }

    public static boolean IsUsername(String str) {
        String regex = "^[a-zA-Z0-9]+$";
        return Match(regex, str);
    }

    public static boolean IsDay(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour < 16 && hour >= 8) {
            return true;
        }
        return false;
    }

    public static boolean IsEvening(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour <= 23 && hour >= 16) {
            return true;
        }
        return false;
    }

    public static boolean IsNight(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour < 8 && hour >= 0) {
            return true;
        }
        return false;
    }

    public static boolean IsAdminUser(String username) {
        return username.toLowerCase().contains("admin");
    }

    private static boolean Match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    
    public boolean IncludeAdmin(String username){
        return username.contains("admin");
    }
}
