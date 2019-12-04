/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.identities;

import com.thursday.business.WorkFlow;
import com.thursday.business.workflow.Task;
import com.thursday.util.db.TaskBiz;
import com.thursday.util.db.WorkRequestBiz;
import java.util.List;

/**
 *
 * @author lihang
 */
public class User extends AbstractUser {

    private String firstName;
    private String lastName;
    private String role;
    private String companyName;

    public User(String username, char[] passwd, String name, String last, String role) {
        super(username, passwd);
        this.firstName = name;
        this.lastName = last;
        this.role = role;
    }

    public User(String company, String username, char[] passwd, String name, String last, String role) {
        super(username, passwd);
        this.firstName = name;
        this.lastName = last;
        this.role = role;
        this.companyName = company;
    }

    public User() {
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    //database related actions
    public boolean sendRequest(String toUser, String title, String message, Integer taskId) {
        return WorkFlow.createRequest(taskId, title, message, this.getUsername(), toUser);
    }

    public boolean createTask(String toAdmin, String title, String message) {
        if (!role.equals(ApartmentUser.Roles.RESIDENT)) {
            return false;
            //only residents can create tasks
        }
        Task t = WorkFlow.createTask(this.getUsername(), title, message);
        return (t != null) ? sendRequest(toAdmin, title, message, t.getId()) : false;
    }

    public List getReceivedRequests() {
        return WorkFlow.getReceivedRequest(this.getUsername());
    }

    public List getSentRequests() {
        return WorkFlow.getSentRequest(this.getUsername());
    }

    @Override
    public String toString() {
        return role + "Name:" + firstName +" " + lastName;
    }

    @Override
    public String getUserType() {
        return "User";
    }

}
