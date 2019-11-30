/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.workflow;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<AbstractWorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<AbstractWorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}