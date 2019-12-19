/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.business.workflow;

/**
 *
 * @author lihang
 */
public class CleaningCompWorkRequest extends AbstractWorkRequest {

    public CleaningCompWorkRequest receiveRequest(AbstractWorkRequest wr) {
        return (CleaningCompWorkRequest) wr;
    }
    
}
