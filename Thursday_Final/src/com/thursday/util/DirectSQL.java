/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.util;

import com.thursday.business.CompanyDirectory;
import com.thursday.business.identities.ApartmentUser;
import com.thursday.util.db.UserBiz;
import com.thursday.business.identities.CleaningCompUser;
import com.thursday.business.identities.CleaningCompUser;
import com.thursday.business.identities.User;
import com.thursday.business.UserDirectory;
import com.thursday.business.workflow.WorkRequest;
import com.thursday.business.workflow.Task;
import com.thursday.util.db.TaskBiz;
import com.thursday.business.workflow.AbstractWorkRequest;
import com.thursday.util.db.DBInfo;
import com.thursday.util.db.WorkRequestBiz;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lihang
 */
public class DirectSQL {

    public static void main(String[] args) {
//        System.out.println(CompanyDirectory.createCleaningComp("Elizabeth's Cleaning", "ecladmin", "admin".toCharArray()));
        System.out.println(TaskBiz.getTaskCompany());
    }
}
