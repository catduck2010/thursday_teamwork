/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util.dao;

import com.thursday.util.DBInfo;

/**
 *
 * @author lihang
 */
public class CleanCompDao extends Dao {

    private static Dao dao;

    public static Dao getInstance() {
        if (dao == null) {
            dao = new CleanCompDao();
        }
        return dao;
    }

    private CleanCompDao() {
        super(DBInfo.CLEANCOMP);
    }

}
