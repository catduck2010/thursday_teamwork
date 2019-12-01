/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util.db;

import com.thursday.business.workflow.WorkRequest;
import com.thursday.util.db.Dao;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author lihang
 */
public class WorkRequestBiz {

    public static boolean add(WorkRequest wr) {
        String sql = "insert into workrequest(taskid,title,message,sender,"
                + "receiver,requesttime) values(?,?,?,?,?,?)";
        Object[] params = {wr.getTaskId(), wr.getTitle(), wr.getMessage(),
            wr.getSender(), wr.getReceiver(), wr.getRequestTime()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean delete(WorkRequest wr) {
        String sql = "update workrequest set state=0 where id=?";
        Object[] params = {wr.getId()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean update(WorkRequest wr) {
        String sql = "update workrequest set isread=?, readtime=? where id=?";
        Object[] params = {wr.getIsRead(), wr.getReadTime(), wr.getId()};
        return Dao.getInstance().update(sql, params);
    }

    public static WorkRequest getWorkRequest(Integer id) {
        String sql = "select * from workrequest where id=? and state=1";
        Object[] params = {id};
        return (WorkRequest) Dao.getInstance().get(sql, WorkRequest.class, params);
    }

    public static boolean deleteRelatedWorkRequests(Integer taskId) {
        String sql = "update workrequest set state=0 where taskid=? and state=1";
        Object[] params = {taskId};
        return Dao.getInstance().update(sql, params);
    }

    public static WorkRequest getLatestWorkRequest(String sender) {
        String sql = "select * from workrequest where sender=? and state=1 "
                + "order by id desc limit 1";
        Object[] params = {sender};
        return (WorkRequest) Dao.getInstance().get(sql, WorkRequest.class, params);
    }

    public static List getAllWorkRequests(String receiver) {
        String sql = "select * from workrequest where receiver=? and state=1";
        Object[] params = {receiver};
        return Dao.getInstance().query(sql, WorkRequest.class, params);
    }
}
