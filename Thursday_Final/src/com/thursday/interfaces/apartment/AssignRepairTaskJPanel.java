/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces.apartment;

import com.thursday.business.UserDirectory;
import com.thursday.business.WorkFlow;
import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.User;
import com.thursday.business.workflow.Task;
import com.thursday.business.workflow.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andy
 */
public class AssignRepairTaskJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AssignRepairTaskJPanel
     */
    private Task task;
    private JPanel rightPanel;
    private User admin;

    public AssignRepairTaskJPanel(JPanel rightPanel, Task task, User admin) {
        this.task = task;
        this.rightPanel = rightPanel;
        this.admin = admin;
        initComponents();
        populateRepairTable();
    }

    public void populateRepairTable() {

        DefaultTableModel dtm = (DefaultTableModel) tblRepairman.getModel();
        dtm.setRowCount(0);

        for (User u : UserDirectory.getCompanyStaff(admin.getCompanyName())) {

            if (u.getRole().equals(ApartmentUser.Roles.REPAIRPERSON)) {
                Object row[] = new Object[2];
                row[0] = u;
                row[1] = u.getUsername();

                dtm.addRow(row);
            }
        }
    }

    private void goBack() {
        CardLayout layout = (CardLayout) this.rightPanel.getLayout();
        this.rightPanel.remove(this);
        layout.previous(this.rightPanel);
    }

    public void sendRequest() {
        int selectedRow = tblRepairman.getSelectedRow();
        if (selectedRow >= 0) {
            String status = Task.Status.WAIT_FOR_RESPONSE;
            task.setStatus(status);
            WorkFlow.updateTask(task);
            User u = (User) tblRepairman.getValueAt(selectedRow, 0);
            WorkFlow.createRequest(task.getId(), task.getTitle(), task.getMessage(), admin.getUsername(), u.getUsername());
            JOptionPane.showMessageDialog(null, "Send Repair Task Request Successfully!");
            
            
            CardLayout layout =(CardLayout)this.rightPanel.getLayout();
            this.rightPanel.remove(this);
            layout.previous(this.rightPanel);
            }
        
        else {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRepairman = new javax.swing.JTable();
        btnSend = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        tblRepairman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Repair Man", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRepairman);

        btnSend.setText("Send Request");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.setToolTipText("");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRefresh)
                        .addGap(132, 132, 132)
                        .addComponent(btnSend))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(btnRefresh))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Assign Repair Task");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        sendRequest();
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateRepairTable();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRepairman;
    // End of variables declaration//GEN-END:variables
}
