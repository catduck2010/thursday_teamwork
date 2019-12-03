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
//        User u=new User("admin", "admin".toCharArray(), "Zero", "Administrator", "ADMIN");
//        System.out.println(u.getUserType());
//
//        System.out.println(u.getUserType());
        //User u=CleaningCompUserBiz.getUser("admin");
        //CleaningCompUserBiz.add(u);

        //System.out.println(TaskBiz.update(t));
        //System.out.println(ApartmentUser.Roles.ADMIN);
//        WorkRequest wr = new WorkRequest(1,"Hello","again","admin","123");
//        System.out.println(WorkRequestBiz.add(wr));
//        wr=WorkRequestBiz
//        System.out.println(wr.getIsRead());
//        wr.markRead();
//        System.out.println(WorkRequestBiz.update(wr));
        CompanyDirectory.createCleaningComp("Carrie Lam 777");
        List c = CompanyDirectory.getCleaningCompanies();
        System.out.println(c);
    }
}
