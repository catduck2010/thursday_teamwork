/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.workflow;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author lihang
 */
public class Task {

    private Integer id;
    private String title;
    private String message;
    private Timestamp createTime;
    private Timestamp resolveTime;
    private String status;

    public Task() {

    }

    public Task(String title, String message) {
        this();
        this.title = title;
        this.message = message;
        this.createTime = new Timestamp(new Date().getTime());
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getResolveTime() {
        return resolveTime;
    }

    public void setResolveTime(Timestamp resolveTime) {
        this.resolveTime = resolveTime;
    }

}
