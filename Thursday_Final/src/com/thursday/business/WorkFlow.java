/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.workflow.Task;
import com.thursday.business.workflow.ViewTaskCompany;
import com.thursday.util.db.TaskBiz;
import com.thursday.business.workflow.WorkRequest;
import com.thursday.util.db.WorkRequestBiz;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lihang
 */
public class WorkFlow {

    public static boolean createRequest(int taskId, String title, String message, String from, String to) throws SQLException {
        WorkRequest wr = new WorkRequest(taskId, title, message, from, to);
        return WorkRequestBiz.add(wr);
    }

    public static Task createTask(String from, String title, String message) throws SQLException {
        Task t = new Task(title, message, from);
        if (TaskBiz.add(t)) {
            return TaskBiz.getLatestTask(from);
        }
        return null;
    }

    public static boolean deleteTask(Task t) throws SQLException {
        boolean okay = WorkRequestBiz.deleteRelatedWorkRequests(t.getId());
        return TaskBiz.delete(t) && okay;
    }

    public static boolean updateTask(Task t) throws SQLException {
        return TaskBiz.update(t);
    }

    public static boolean markAsRead(WorkRequest wr) throws SQLException {
        wr.markRead();
        return updateWorkRequest(wr);
    }

    public static boolean markAsUnread(WorkRequest wr) throws SQLException {
        wr.markUnread();
        return updateWorkRequest(wr);
    }

    public static boolean updateWorkRequest(WorkRequest wr) throws SQLException {
        return WorkRequestBiz.update(wr);
    }

    public static boolean withdrawWorkRequest(WorkRequest wr) throws SQLException {
        return WorkRequestBiz.delete(wr);
    }

    public static List<WorkRequest> getReceivedRequest(String username) throws SQLException {
        return WorkRequestBiz.getAllReceivedWorkRequests(username);
    }

    public static List<WorkRequest> getSentRequest(String username) throws SQLException {
        return WorkRequestBiz.getAllSentWorkRequests(username);
    }

    public static List<Task> getAllTasks(String username) throws SQLException {
        return TaskBiz.getUserTask(username);
    }

    public static Task getTask(int taskId) throws SQLException {
        return TaskBiz.getTask(taskId);
    }

    public static List<Task> getAllTasksOfOneUser(String username) throws SQLException {
        return TaskBiz.getUserTask(username);
    }

    public static List<Task> getAllTasks() throws SQLException {
        return TaskBiz.getAllTasks();
    }

    public static List<ViewTaskCompany> getTaskCompany() throws SQLException {
        return TaskBiz.getTaskCompany();
    }
}
