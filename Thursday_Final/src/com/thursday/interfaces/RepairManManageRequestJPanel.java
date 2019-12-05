/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.business.WorkFlow;
import com.thursday.business.identities.User;
import com.thursday.business.workflow.WorkRequest;
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

        for (WorkRequest wr : WorkFlow.getReceivedRequest(repairMan.getUsername())) {

            Object row[] = new Object[5];

            row[0] = wr.getIsRead() ? (char) 8730 : " ";
            row[1] = wr.getTaskId();
            row[2] = wr;
            row[3] = wr.getMessage();
            row[4] = wr.getSender();

            dtm.addRow(row);

        }
    }

    public void asRead() {

        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest wr = (WorkRequest) tblRequest.getValueAt(selectedRow, 2);
            if (wr.getIsRead()) {
                JOptionPane.showMessageDialog(null, "Already read!");
                return;
            } else if (WorkFlow.markAsRead(wr)){
                JOptionPane.showMessageDialog(null, "Set read successfully. Go to work now!");
            }
            populateRequestTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select any row");
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
                WorkFlow.createRequest(wr.getTaskId(), wr.getTitle(), wr.getMessage(), repairMan.getUsername(), wr.getSender());
                JOptionPane.showMessageDialog(null, "Set finished successfully");
                WorkFlow.withdrawWorkRequest(wr);
                populateRequestTable();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnRead)
                        .addGap(40, 40, 40)
                        .addComponent(btnFinished)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRead)
                    .addComponent(btnFinished))
                .addContainerGap(213, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinished;
    private javax.swing.JButton btnRead;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables
}