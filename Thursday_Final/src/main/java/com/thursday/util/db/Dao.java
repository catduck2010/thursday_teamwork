/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util.db;

/**
 *
 * @author lihang
 */
public class Dao extends AbstractDao {

    private static AbstractDao business;

    public static AbstractDao getInstance() {
        if (business == null) {
            business = new Dao();
        }
        return business;
    }

    private Dao() {
        super(DBInfo.DBNAME);
    }
}
