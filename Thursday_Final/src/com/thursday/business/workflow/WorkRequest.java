/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.workflow;

import com.thursday.business.identities.AbstractUser;
import java.util.Date;

/**
 *
 * @author lihang
 */
public abstract class WorkRequest {

    private String message;
    private AbstractUser sender;
    private AbstractUser receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AbstractUser getSender() {
        return sender;
    }

    public void setSender(AbstractUser sender) {
        this.sender = sender;
    }

    public AbstractUser getReceiver() {
        return receiver;
    }

    public void setReceiver(AbstractUser receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
