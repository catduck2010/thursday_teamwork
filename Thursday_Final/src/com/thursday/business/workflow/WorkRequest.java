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
public abstract class WorkRequest {

    private Integer id;
    private String title;
    private String message;
    private Integer senderId;
    private Integer receiverId;
    private Integer senderCompanyId;
    private Integer receiverCompanyId;
    private String status;
    private Timestamp requestDate;
    private Timestamp resolveDate;
    //use TimeStamp

    public class Status {

        public static final String PENDING = "PENDING";
        public static final String WORKING = "WORKING";
        public static final String FINISHED = "FINISHED";
        public static final String WAIT_FOR_RESPONSE = "WAIT_FOR_RESPONSE";

    }

    public WorkRequest(String[] args) {
        requestDate = new Timestamp(new Date().getTime());
    }

    public WorkRequest(String title, String message, Integer sid, Integer rid) {
        this();
        this.title = title;
        this.message = message;
        this.senderId = sid;
        this.receiverId = rid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getSenderCompanyId() {
        return senderCompanyId;
    }

    public void setSenderCompanyId(Integer senderCompanyId) {
        this.senderCompanyId = senderCompanyId;
    }

    public Integer getReceiverCompanyId() {
        return receiverCompanyId;
    }

    public void setReceiverCompanyId(Integer receiverCompanyId) {
        this.receiverCompanyId = receiverCompanyId;
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

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public Date getDateOfRequest() {
        return new Date(requestDate.getTime());
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = new Timestamp(requestDate.getTime());
    }

    public void setRequestDate(Timestamp timeStamp) {
        this.requestDate = timeStamp;
    }

    public Timestamp getResolveDate() {
        return resolveDate;
    }

    public Date getDateofResolve() {
        return new Date(resolveDate.getTime());
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = new Timestamp(resolveDate.getTime());
    }

    public void setResolveDate(Timestamp timeStamp) {
        this.resolveDate = timeStamp;
    }

    public WorkRequest() {

    }

}
