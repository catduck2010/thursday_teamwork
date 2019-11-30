/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.workflow;

/**
 *
 * @author lihang
 */
public class WorkRequest extends AbstractWorkRequest {

    public WorkRequest(int taskId, String title, String message, String sender, String receiver) {
        super(taskId, title, message, sender, receiver);
    }

    public WorkRequest() {
        super();
    }

}
