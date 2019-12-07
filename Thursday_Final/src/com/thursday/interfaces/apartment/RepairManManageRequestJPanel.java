/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces.apartment;

import com.thursday.business.WorkFlow;
import com.thursday.business.identities.User;
import com.thursday.business.workflow.Task;
import com.thursday.business.workflow.WorkRequest;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andy
 */
public class RepairManManageRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RepairManManageRequestJPanel
     */
    private JPanel rightPanel;
    private User repairMan;

    public RepairManManageRequestJPanel(JPanel rightPanel, User repairMan) {
        this.rightPanel = rightPanel;
        this.repairMan = repairMan;
        initComponents();
        populateRequestTable();
    }

    public void populateRequestTable() {

        DefaultTableModel dtm = (DefaultTableModel) tblRequest.getModel();
        dtm.setRowCount(0);
        try {
            for (WorkRequest wr : WorkFlow.getReceivedRequest(repairMan.getUsername())) {

                Object row[] = new Object[5];

                row[0] = wr.getIsRead() ? (char) 8730 : " ";
                row[1] = wr.getTaskId();
                row[2] = wr;
                row[3] = wr.getMessage();
                row[4] = wr.getSender();

                dtm.addRow(row);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void asRead() {
        try {
            int count =0;
            for(WorkRequest wr : WorkFlow.getReceivedRequest(repairMan.getUsername())){
                if(wr.getIsRead()){
                    count = count +1;
                }
            }
            if(count>0){
                JOptionPane.showMessageDialog(null, "Finished your current task first!");
                return;
            }
            int selectedRow = tblRequest.getSelectedRow();
            if (selectedRow >= 0) {
                WorkRequest wr = (WorkRequest) tblRequest.getValueAt(selectedRow, 2);
                try {
                    if (wr.getIsRead()) {
                        JOptionPane.showMessageDialog(null, "Already read!");
                        return;
                    } else if (WorkFlow.markAsRead(wr)) {
                        JOptionPane.showMessageDialog(null, "Set read successfully. Go to work now!");
                        for (Task t : WorkFlow.getAllTasks()) {
                            if (t.getId() == wr.getTaskId()) {
                                String status = Task.Status.WORKING;
                                t.setStatus(status);
                                WorkFlow.updateTask(t);
                            }
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                populateRequestTable();
            } else {
                JOptionPane.showMessageDialog(null, "Please select any row");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setFinished() {
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest wr = (WorkRequest) tblRequest.getValueAt(selectedRow, 2);
            if (!wr.getIsRead()) {
                JOptionPane.showMessageDialog(null, "set read and go to work first!");
                return;
            }
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure you are finished?", "Warning", selectionButton);

            if (selectionResult == JOptionPane.YES_OPTION) {
                try {
                    WorkFlow.createRequest(wr.getTaskId(), wr.getTitle(), wr.getMessage(), repairMan.getUsername(), wr.getSender());
                    for (Task t : WorkFlow.getAllTasks()) {
                        if (t.getId() == wr.getTaskId()) {
                            String status = Task.Status.FINISHED;
                            t.setStatus(status);
                            WorkFlow.updateTask(t);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Set finished successfully");
                    WorkFlow.withdrawWorkRequest(wr);
                    populateRequestTable();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        btnRead = new javax.swing.JButton();
        btnFinished = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(tblRequest);

        btnRead.setText("As Read & Go to Work");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnFinished.setText("Finished Work");
        btnFinished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishedActionPerformed(evt);
            }
        });

        btnGoBack.setText("←");
        btnGoBack.setEnabled(false);
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Manage My Requests");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinished))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(jLabel2)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRead)
                    .addComponent(btnFinished))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        // TODO add your handling code here:
        asRead();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnFinishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishedActionPerformed
        // TODO add your handling code here:
        setFinished();
    }//GEN-LAST:event_btnFinishedActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinished;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables
}
