/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.workflow;

import com.thursday.util.dao.ApartmentDao;
import java.sql.Timestamp;

/**
 *
 * @author lihang
 */
public class ApartmentWorkRequestBiz {

    public static boolean add(WorkRequest wr) {
        String sql = "insert into workrequest(title,message,senderid,receiverid,status,requestdate) values(?,?,?,?,?,?)";
        Object[] params = {wr.getTitle(), wr.getMessage(), wr.getSenderId(), wr.getReceiverId(),
            wr.getStatus(), wr.getRequestDate()};
        return ApartmentDao.getInstance().update(sql, params);
    }

    public static boolean delete(WorkRequest wr) {
        String sql = "update workrequest set state=0 where id=?";
        Object[] params = {wr.getId()};
        return ApartmentDao.getInstance().update(sql, params);
    }

    public static boolean update(WorkRequest wr) {
        return false;
    }

    public static WorkRequest getWorkRequest(Integer id) {
        String sql = "select * from workrequest where id=?";
        Object[] params = {id};
        return (WorkRequest) ApartmentDao.getInstance().get(sql, WorkRequest.class, params);
    }
}
