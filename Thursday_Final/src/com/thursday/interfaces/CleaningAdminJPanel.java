/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.business.CompanyDirectory;
import com.thursday.business.UserDirectory;
import com.thursday.business.WorkFlow;
import com.thursday.business.enterprise.Company;
import com.thursday.business.identities.CleaningCompUser;
import com.thursday.business.identities.User;
import com.thursday.business.workflow.Task;
import com.thursday.business.workflow.ViewTaskCompany;

import com.thursday.business.workflow.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andy
 */
public class CleaningAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CleaningAdminJPanel
     */
    private JPanel rightPanel;
    private User admin;
    public CleaningAdminJPanel(JPanel rightPanel, User admin) {
        this.rightPanel = rightPanel;
        this.admin = admin;
        initComponents();
        populateRequestTable();
        populateSendTable();
        
    }
public void populateRequestTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblRequest.getModel();
        dtm.setRowCount(0);
        
        
        for( WorkRequest wr : WorkFlow.getReceivedRequest(admin.getUsername())){
            
            
            Object row[] = new Object [5];
            
            row[0] = wr.getIsRead()? (char)8730:" ";
            row[1] = wr.getTaskId();
            row[2] = wr;
            row[3] = wr.getMessage();
            row[4] = wr.getSender();
            
            
            dtm.addRow(row);
    }
    }
public void populateSendTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblSend.getModel();
        dtm.setRowCount(0);
        
        for( WorkRequest wr : WorkFlow.getSentRequest(admin.getUsername())){
            
            Object row[] = new Object [5];
            
            row[0] = wr.getIsRead()? (char)8730:" ";
            row[1] = wr.getTaskId();
            row[2] = wr;
            row[3] = wr.getMessage();
            row[4] = wr.getReceiver();
            
            
            dtm.addRow(row);
    }
    }
/*public void asRead(){
    
     int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest wr = (WorkRequest)tblRequest.getValueAt(selectedRow, 2);
            if(wr.getIsRead())
            {
                JOptionPane.showMessageDialog(null, "Already read!");
                return;
            }
            else if (WorkFlow.markAsRead(wr)){
                JOptionPane.showMessageDialog(null, "Set read successfully.");
            }
            populateRequestTable();
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Please select any row");
        }    

    }*/
public void SendCleaningRequest(){
     boolean validation = true;
     int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest wr = (WorkRequest)tblRequest.getValueAt(selectedRow, 2);
            
            for( User u : UserDirectory.getCompanyStaff(admin.getCompanyName())){
            
            if(u.getRole().equals(CleaningCompUser.Roles.CLEANER) && wr.getSender().equals(u.getUsername())){
              validation =false;
              break;
            }
        }
            
            if (wr.getIsRead()) {
                JOptionPane.showMessageDialog(null, "You already assign this task!");
                return;
            }
            else if(validation == false){
                JOptionPane.showMessageDialog(null, "please select request from apartment admin!");
            }
            else{
            WorkFlow.markAsRead(wr);
            populateRequestTable();
            AssignCleaningTaskJPanel assignCleaningTaskJPanel = new AssignCleaningTaskJPanel(rightPanel,wr,admin);
            CardLayout layout = (CardLayout) rightPanel.getLayout();
            rightPanel.add("AssignCleaningTaskJPanel", assignCleaningTaskJPanel);
            layout.next(rightPanel);
            }
        }
        else 
            JOptionPane.showMessageDialog(null, "Please select any row");
}
public void SendBack(){
     
        boolean validation = false;
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest wr = (WorkRequest) tblRequest.getValueAt(selectedRow, 2);
            for( User u : UserDirectory.getCompanyStaff(admin.getCompanyName())){
            
            if(u.getRole().equals(CleaningCompUser.Roles.CLEANER) && wr.getSender().equals(u.getUsername())){
              validation =true;
              break;
            }
        }
            if (!wr.getIsRead()) {
                JOptionPane.showMessageDialog(null, "send task first!");
                return;
            }
            else if(validation == false){
                JOptionPane.showMessageDialog(null, "please select request from cleaner!");
            }
            else{
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to send the feedback?", "Warning", selectionButton);
            if (selectionResult == JOptionPane.YES_OPTION) {
                String companyName = new String();
                String adminusername = new String();
                for(Task t : WorkFlow.getAllTasks()){
                    if(t.getId() == wr.getTaskId()){
                        for(ViewTaskCompany vtc : WorkFlow.getTaskCompany())
                        {
                            if(vtc.getTaskId() == t.getId()){
                                companyName = vtc.getCompany(); 
                            }
                            
                        }
                    }
                }
                for(Company c : CompanyDirectory.getApartments()){
                    if(c.getCompanyName().equals(companyName)){
                        adminusername = c.getAdminUser();
                        break;
                    }
                }
                
                WorkFlow.createRequest(wr.getTaskId(), wr.getTitle(), wr.getMessage(), admin.getUsername(), adminusername);
                JOptionPane.showMessageDialog(null, "Send Back Successfully!");
                populateRequestTable();
            }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select any row");
        }
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        SendBoxJPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSend = new javax.swing.JTable();
        receiveBoxJPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        btnSendCleaningRequest = new javax.swing.JButton();
        btnSendback = new javax.swing.JButton();

        tblSend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Read Status", "Task Id", "Task Title", "Task Message", "Receiver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblSend);

        javax.swing.GroupLayout SendBoxJPanelLayout = new javax.swing.GroupLayout(SendBoxJPanel);
        SendBoxJPanel.setLayout(SendBoxJPanelLayout);
        SendBoxJPanelLayout.setHorizontalGroup(
            SendBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SendBoxJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        SendBoxJPanelLayout.setVerticalGroup(
            SendBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SendBoxJPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Send ", SendBoxJPanel);

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Read Status", "Task Id", "Task Title", "Task Message", "Sender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblRequest);

        btnSendCleaningRequest.setText("Send Cleaning Request ");
        btnSendCleaningRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendCleaningRequestActionPerformed(evt);
            }
        });

        btnSendback.setText("Send Back to Apartment Admin");
        btnSendback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receiveBoxJPanelLayout = new javax.swing.GroupLayout(receiveBoxJPanel);
        receiveBoxJPanel.setLayout(receiveBoxJPanelLayout);
        receiveBoxJPanelLayout.setHorizontalGroup(
            receiveBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiveBoxJPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(receiveBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receiveBoxJPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnSendCleaningRequest)
                        .addGap(26, 26, 26)
                        .addComponent(btnSendback))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        receiveBoxJPanelLayout.setVerticalGroup(
            receiveBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiveBoxJPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(receiveBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSendCleaningRequest)
                    .addComponent(btnSendback))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Receive", receiveBoxJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendCleaningRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendCleaningRequestActionPerformed
        // TODO add your handling code here:
        SendCleaningRequest();
    }//GEN-LAST:event_btnSendCleaningRequestActionPerformed

    private void btnSendbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendbackActionPerformed
        // TODO add your handling code here:
        SendBack();
    }//GEN-LAST:event_btnSendbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SendBoxJPanel;
    private javax.swing.JButton btnSendCleaningRequest;
    private javax.swing.JButton btnSendback;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel receiveBoxJPanel;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTable tblSend;
    // End of variables declaration//GEN-END:variables
}
