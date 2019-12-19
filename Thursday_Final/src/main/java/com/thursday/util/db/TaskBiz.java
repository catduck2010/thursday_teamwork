/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util.db;

import com.thursday.business.workflow.Task;
import com.thursday.business.workflow.ViewTaskCompany;
import com.thursday.util.db.Dao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lihang
 */
public class TaskBiz {

    public static boolean add(Task t) throws SQLException{
        String sql = "insert into task(title,message,creator,createtime,status) values(?,?,?,?,?)";
        Object[] params = {t.getTitle(), t.getMessage(), t.getCreator(), t.getCreateTime(), t.getStatus()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean delete(Task t) throws SQLException{
        String sql = "update task set state=0 where id=?";
        Object[] params = {t.getId()};
        return Dao.getInstance().update(sql, params);
    }

    public static boolean update(Task t) throws SQLException{
        String sql = "update task set title=?,message=?,status=?,resolvetime=? where id=?";
        Object[] params = {t.getTitle(), t.getMessage(), t.getStatus(), t.getResolveTime(), t.getId()};
        return Dao.getInstance().update(sql, params);
    }

    public static Task getTask(int id) throws SQLException{
        String sql = "select * from task where id=? and state=1";
        Object[] params = {id};
        return (Task) Dao.getInstance().get(sql, Task.class, params);
    }

    public static List<Task> getUserTask(String username) throws SQLException{
        String sql = "select * from task where creator=? and state=1 order by id desc";
        Object[] params = {username};
        return Dao.getInstance().query(sql, Task.class, params);
    }
    
    public static List<Task> getAllTasks() throws SQLException{
        String sql = "select * from task where state=1 order by id desc";
        return Dao.getInstance().query(sql, Task.class);
    }

    public static Task getLatestTask(String username) throws SQLException{
        String sql="select * from task where creator=? and state=1 order by id desc limit 1";
        Object[] params = {username};
        return (Task)Dao.getInstance().get(sql, Task.class, params);
    }
    
    public static List<ViewTaskCompany> getTaskCompany()throws SQLException{
        String sql="select * from view_taskcompany order by taskid desc";
        return Dao.getInstance().query(sql, ViewTaskCompany.class);
    }
}
