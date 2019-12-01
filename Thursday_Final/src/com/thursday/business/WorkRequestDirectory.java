/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business;

import com.thursday.business.workflow.Task;
import com.thursday.util.db.TaskBiz;
import com.thursday.business.workflow.WorkRequest;
import com.thursday.util.db.WorkRequestBiz;

/**
 *
 * @author lihang
 */
public class WorkRequestDirectory {

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
    
    
}
