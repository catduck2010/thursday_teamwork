/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;


import com.thursday.business.CompanyDirectory;
import javax.swing.table.DefaultTableModel;
import com.thursday.business.WorkFlow;
import com.thursday.business.enterprise.Company;
import com.thursday.business.identities.User;

/**
 *
 * @author andy
 */
import com.thursday.business.workflow.Task;
import com.thursday.business.workflow.WorkRequest;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class ManageTaskJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageTaskJPanel
     */
    private JPanel rightPanel;
    private User admin;
    public ManageTaskJPanel(JPanel rightPanel, User admin) {
        this.rightPanel = rightPanel;
        this.admin = admin;
        initComponents(); 
        loadComboBox();
        populateTable();
        populateRequestTable();
        populateSendTable();
    }
    public void loadComboBox(){
        comboBoxCc.removeAllItems();
        for(Company c: CompanyDirectory.getCleaningCompanies()){
            comboBoxCc.addItem(c);
        }
    }
    public void populateTable(){
        
        DefaultTableModel dtm = (DefaultTableModel)tblTask.getModel();
        dtm.setRowCount(0);
        
        
        for( Task t : WorkFlow.getAllTasks()){
            
            
            Object row[] = new Object [6];
            row[0] = t.getId();
            row[1] = t;
            row[2] = t.getMessage();
            row[3] = t.getCreator();
            row[4] = t.getCreateTime();
            row[5] = t.getStatus();
            dtm.addRow(row);
        
        }
        
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
    public void setStatus(){
        int selectedRow = tblTask.getSelectedRow();
        String status =Task.Status.PENDING;
        if (selectedRow >= 0) {
            
            Task task = (Task)tblTask.getValueAt(selectedRow, 1);
            if(task.getTitle().indexOf("Cleaning") == -1){
                JOptionPane.showMessageDialog(null, "Repair task can change status automatically");
                return;
            }
            if(task.getStatus().equals(Task.Status.PENDING)){
                
                JOptionPane.showMessageDialog(null, "Please assign this task first");
                return;
            }
            if(task.getStatus().equals(Task.Status.WAIT_FOR_RESPONSE)){
                status = Task.Status.WORKING;
            }
            if(task.getStatus().equals(Task.Status.WORKING)){
                status = Task.Status.FINISHED;
            }
            if(task.getStatus().equals(Task.Status.FINISHED)){
                 JOptionPane.showMessageDialog(null, "The task already finished!");
                 return;
            }
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to change task status?","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
            task.setStatus(status);
            WorkFlow.updateTask(task);
            populateTable();
                
            }  
            
            }
        
        else {
            JOptionPane.showMessageDialog(null, "Please select any row");
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
                JOptionPane.showMessageDialog(null, "Set read successfully.");
            }
            populateRequestTable();
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Please select any row");
        }    

    }
    public void assignRepair(){
        int selectedRow = tblTask.getSelectedRow();
        if (selectedRow >= 0) {
            Task task = (Task)tblTask.getValueAt(selectedRow, 1);
            if(!task.getStatus().equals(Task.Status.PENDING) || task.getTitle().indexOf("Repair") == -1){
            JOptionPane.showMessageDialog(null, "Please select valid task");
            return;
            }
            else{
            AssignRepairTaskJPanel assignRepairTaskJPanel = new AssignRepairTaskJPanel(rightPanel,task,admin);
            CardLayout layout = (CardLayout) rightPanel.getLayout();
            rightPanel.add("AssignRepairTaskJPanel", assignRepairTaskJPanel);
            layout.next(rightPanel);
            }
        }
        else 
            JOptionPane.showMessageDialog(null, "Please select any row");   
    }
public void assignCleaning(){
        int selectedRow = tblTask.getSelectedRow();
        if (selectedRow >= 0) {
            Task task = (Task)tblTask.getValueAt(selectedRow, 1);
            if(!task.getStatus().equals(Task.Status.PENDING) || task.getTitle().indexOf("Cleaning") == -1){
            JOptionPane.showMessageDialog(null, "Please select valid task");
            return;
            }
            else{
             String status =Task.Status.WAIT_FOR_RESPONSE;  
             task.setStatus(status);
             WorkFlow.updateTask(task);
             populateTable();
             
             Company c=(Company) comboBoxCc.getSelectedItem();
             WorkFlow.createRequest(task.getId(), task.getTitle(), task.getMessage(),admin.getUsername(),c.getAdminUser());
             populateSendTable();
             JOptionPane.showMessageDialog(null, "Send Cleaning Task Request Successfully!");
             
            }
        }
        else 
            JOptionPane.showMessageDialog(null, "Please select any row");   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTask = new javax.swing.JTable();
        btnAssignRepairTask = new javax.swing.JButton();
        btnSendCleaning = new javax.swing.JButton();
        btnStatus = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        SendBoxJPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSend = new javax.swing.JTable();
        receiveBoxJPanel = new javax.swing.JPanel();
        btnAsRead = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        comboBoxCc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        tblTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task Id", "Title", "Message", "Creator", "Date Created", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTask);

        btnAssignRepairTask.setText("Assign Repair Task");
        btnAssignRepairTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignRepairTaskActionPerformed(evt);
            }
        });

        btnSendCleaning.setText("Send Cleaning Request");
        btnSendCleaning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendCleaningActionPerformed(evt);
            }
        });

        btnStatus.setText("Change Status");
        btnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusActionPerformed(evt);
            }
        });

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

        btnAsRead.setText("Set as Read");
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

        javax.swing.GroupLayout receiveBoxJPanelLayout = new javax.swing.GroupLayout(receiveBoxJPanel);
        receiveBoxJPanel.setLayout(receiveBoxJPanelLayout);
        receiveBoxJPanelLayout.setHorizontalGroup(
            receiveBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receiveBoxJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAsRead, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        receiveBoxJPanelLayout.setVerticalGroup(
            receiveBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiveBoxJPanelLayout.createSequentialGroup()
                .addGroup(receiveBoxJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receiveBoxJPanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnAsRead))
                    .addGroup(receiveBoxJPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Receive", receiveBoxJPanel);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setText("Cleaning Company:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSendCleaning)
                                    .addComponent(comboBoxCc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel1))
                                    .addComponent(btnAssignRepairTask)
                                    .addComponent(btnStatus))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAssignRepairTask)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(comboBoxCc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendCleaning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStatus))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignRepairTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignRepairTaskActionPerformed
        // TODO add your handling code here:
        assignRepair();
    }//GEN-LAST:event_btnAssignRepairTaskActionPerformed

    private void btnSendCleaningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendCleaningActionPerformed
        // TODO add your handling code here:
        assignCleaning();
    }//GEN-LAST:event_btnSendCleaningActionPerformed

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
        // TODO add your handling code here:
        setStatus();
    }//GEN-LAST:event_btnStatusActionPerformed

    private void btnAsReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsReadActionPerformed
        // TODO add your handling code here:
        asRead();
    }//GEN-LAST:event_btnAsReadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SendBoxJPanel;
    private javax.swing.JButton btnAsRead;
    private javax.swing.JButton btnAssignRepairTask;
    private javax.swing.JButton btnSendCleaning;
    private javax.swing.JButton btnStatus;
    private javax.swing.JComboBox<Object> comboBoxCc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel receiveBoxJPanel;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTable tblSend;
    private javax.swing.JTable tblTask;
    // End of variables declaration//GEN-END:variables
}
