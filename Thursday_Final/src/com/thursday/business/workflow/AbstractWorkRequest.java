/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.workflow;

import com.thursday.business.identities.User;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author lihang
 */
public abstract class AbstractWorkRequest {

    private Integer id;
    private Integer taskId;
    private String title;
    private String message;
    private String sender;
    private String receiver;
    private Boolean isRead;
    private Timestamp requestTime;
    private Timestamp readTime;
    //use TimeStamp

    public AbstractWorkRequest(int taskId, String title, String message, String sender, String receiver) {
        this();
        this.taskId = taskId;
        this.title = title;
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.requestTime = new Timestamp(new Date().getTime());
        this.isRead = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public Date getRequestDate() {
        return requestTime != null ? new Date(requestTime.getTime()) : null;
    }

    public void setRequestDate(Date requestDate) {
        this.requestTime = new Timestamp(requestDate.getTime());
    }

    public void setRequestTime(Timestamp timeStamp) {
        this.requestTime = timeStamp;
    }

    public Timestamp getReadTime() {
        return readTime;
    }

    public Date getReadDate() {
        return readTime != null ? new Date(readTime.getTime()) : null;
    }

    public void setReadDate(Date resolveDate) {
        this.readTime = new Timestamp(resolveDate.getTime());
    }

    public void setReadTime(Timestamp timeStamp) {
        this.readTime = timeStamp;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public void markRead() {
        this.isRead = true;
        this.readTime = (readTime == null) ? new Timestamp(new Date().getTime()) : readTime;
        //you can set readTime only once
    }

    public void markUnread() {
        this.isRead = false;
    }

    public AbstractWorkRequest() {

    }

}
