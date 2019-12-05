/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.business.WorkFlow;
import com.thursday.business.identities.User;

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
public void asRead(){
    
     int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest wr = (WorkRequest)tblRequest.getValueAt(selectedRow, 2);
            if(wr.getIsRead())
            {
                JOptionPane.showMessageDialog(null, "Already read!");
                return;
            }
            else if (WorkFlow.markAsRead(wr)){
                JOptionPane.showMessageDialog(null, "Set read successfully. Go to work now!");
            }
            populateRequestTable();
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Please select any row");
        }    

    }
public void SendCleaningRequest(){
     int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest wr = (WorkRequest)tblRequest.getValueAt(selectedRow, 2);
            if (!wr.getIsRead()) {
                JOptionPane.showMessageDialog(null, "set read first!");
                return;
            }
            else if(!wr.getSender().equals("aptadmin")){
                JOptionPane.showMessageDialog(null, "please select request from apartment admin!");
            }
            else{
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
    
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest wr = (WorkRequest) tblRequest.getValueAt(selectedRow, 2);
            if (!wr.getIsRead()) {
                JOptionPane.showMessageDialog(null, "set read and go to work first!");
                return;
            }
            else if(wr.getSender().equals("aptadmin")){
                JOptionPane.showMessageDialog(null, "please select request from cleaner!");
            }
            else{
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to send back?", "Warning", selectionButton);
            if (selectionResult == JOptionPane.YES_OPTION) {
                WorkFlow.createRequest(wr.getTaskId(), wr.getTitle(), wr.getMessage(), admin.getUsername(), "aptadmin");
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
        btnAsRead = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        btnSendCleaningRequest = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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
                .addContainerGap(132, Short.MAX_VALUE))
        );
        SendBoxJPanelLayout.setVerticalGroup(
            SendBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SendBoxJPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Send ", SendBoxJPanel);

        btnAsRead.setText("Set as Read ");
        btnAsRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsReadActionPerformed(evt);
            }
        });

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

        jButton3.setText("Send Back to Apartment Admin");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                        .addComponent(btnAsRead, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendCleaningRequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        receiveBoxJPanelLayout.setVerticalGroup(
            receiveBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiveBoxJPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(receiveBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsRead)
                    .addComponent(btnSendCleaningRequest)
                    .addComponent(jButton3))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Receive", receiveBoxJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsReadActionPerformed
        // TODO add your handling code here:
        asRead();
    }//GEN-LAST:event_btnAsReadActionPerformed

    private void btnSendCleaningRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendCleaningRequestActionPerformed
        // TODO add your handling code here:
        SendCleaningRequest();
    }//GEN-LAST:event_btnSendCleaningRequestActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SendBack();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SendBoxJPanel;
    private javax.swing.JButton btnAsRead;
    private javax.swing.JButton btnSendCleaningRequest;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel receiveBoxJPanel;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTable tblSend;
    // End of variables declaration//GEN-END:variables
}