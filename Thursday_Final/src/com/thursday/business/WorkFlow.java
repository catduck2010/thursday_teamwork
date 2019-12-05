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
import java.util.List;

/**
 *
 * @author lihang
 */
public class WorkFlow {

    public static boolean createRequest(int taskId, String title, String message, String from, String to) {
        WorkRequest wr = new WorkRequest(taskId, title, message, from, to);
        return WorkRequestBiz.add(wr);
    }

    public static Task createTask(String from, String title, String message) {
        Task t = new Task(title, message, from);
        if (TaskBiz.add(t)) {
            return TaskBiz.getLatestTask(from);
        }
        return null;
    }

    public static boolean deleteTask(Task t) {
        boolean okay = WorkRequestBiz.deleteRelatedWorkRequests(t.getId());
        return TaskBiz.delete(t) && okay;
    }

    public static boolean updateTask(Task t) {
        return TaskBiz.update(t);
    }

    public static boolean markAsRead(WorkRequest wr) {
        wr.markRead();
        return updateWorkRequest(wr);
    }

    public static boolean markAsUnread(WorkRequest wr) {
        wr.markUnread();
        return updateWorkRequest(wr);
    }

    public static boolean updateWorkRequest(WorkRequest wr) {
        return WorkRequestBiz.update(wr);
    }

    public static boolean withdrawWorkRequest(WorkRequest wr) {
        return WorkRequestBiz.delete(wr);
    }

    public static List<WorkRequest> getReceivedRequest(String username) {
        return WorkRequestBiz.getAllReceivedWorkRequests(username);
    }

    public static List<WorkRequest> getSentRequest(String username) {
        return WorkRequestBiz.getAllSentWorkRequests(username);
    }

    public static List<Task> getAllTasks(String username) {
        return TaskBiz.getUserTask(username);
    }

    public static Task getTask(int taskId) {
        return TaskBiz.getTask(taskId);
    }

    public static List<Task> getAllTasksOfOneUser(String username) {
        return TaskBiz.getUserTask(username);
    }

    public static List<Task> getAllTasks() {
        return TaskBiz.getAllTasks();
    }

    public static List<ViewTaskCompany> getTaskCompany() {
        return TaskBiz.getTaskCompany();
    }
}
