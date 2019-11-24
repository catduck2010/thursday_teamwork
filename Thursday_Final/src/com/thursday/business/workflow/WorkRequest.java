/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.workflow;

import com.thursday.business.identities.User;
import java.util.Date;

/**
 *
 * @author lihang
 */
public abstract class WorkRequest {

    private String title;
    private String message;
    private User sender;
    private User receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;

    public class Status {

        public static final String PENDING = "PENDING";
        public static final String WORKING = "WORKING";
        public static final String FINISHED = "FINISHED";
        public static final String WAIT_FOR_RESPONSE = "WAIT_FOR_RESPONSE";

    }

    public WorkRequest() {
        requestDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        switch (status) {
            case Status.PENDING:
                return Status.PENDING;
            case Status.WORKING:
                return Status.WORKING;
            case Status.FINISHED:
                return Status.WORKING;
            case Status.WAIT_FOR_RESPONSE:
                return Status.WAIT_FOR_RESPONSE;
        }
        return "";
    }

    public void setStatus(String status) {
        status = status.toUpperCase();
        switch (status) {
            case Status.PENDING:
                this.status = Status.PENDING;
                break;
            case Status.WORKING:
                this.status = Status.WORKING;
                break;
            case Status.FINISHED:
                this.status = Status.WORKING;
                break;
            case Status.WAIT_FOR_RESPONSE:
                this.status = Status.WAIT_FOR_RESPONSE;
                break;
            default:
                this.status = "";
        }
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
}
