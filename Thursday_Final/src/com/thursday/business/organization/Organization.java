/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.organization;




import com.thursday.business.identities.UserDirectory;
import com.thursday.business.role.Role;
import com.thursday.business.workflow.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author lihang
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
   
    private UserDirectory userDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        Admin("Admin Organization"), Doctor("Doctor Organization"), Lab("Lab Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
//        employeeDirectory = new EmployeeDirectory();
        userDirectory = new UserDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserDirectory getUserDirectory() {
        return userDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

//    public EmployeeDirectory getEmployeeDirectory() {
//        return employeeDirectory;
//    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
