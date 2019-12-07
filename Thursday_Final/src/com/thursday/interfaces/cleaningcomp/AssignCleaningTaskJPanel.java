/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces.cleaningcomp;

import com.thursday.business.UserDirectory;
import com.thursday.business.WorkFlow;
import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.CleaningCompUser;
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
public class AssignCleaningTaskJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AssignRepairTaskJPanel
     */
    private WorkRequest wr;
    private JPanel rightPanel;
    private User admin;

    public AssignCleaningTaskJPanel(JPanel rightPanel, WorkRequest wr, User admin) {
        this.wr = wr;
        this.rightPanel = rightPanel;
        this.admin = admin;
        initComponents();
        populateCleaningTable();
    }

    public void populateCleaningTable() {

        DefaultTableModel dtm = (DefaultTableModel) tblCleaningman.getModel();
        dtm.setRowCount(0);

        for (User u : UserDirectory.getCompanyStaff(admin.getCompanyName())) {

            if (u.getRole().equals(CleaningCompUser.Roles.CLEANER)) {
                Object row[] = new Object[2];
                row[0] = u;
                row[1] = u.getUsername();

                dtm.addRow(row);
            }
        }
    }

    public void sendRequest() {
        int selectedRow = tblCleaningman.getSelectedRow();
        if (selectedRow >= 0) {
            
            User u = (User)tblCleaningman.getValueAt(selectedRow, 0);
            WorkFlow.createRequest(wr.getTaskId(), wr.getTitle(), wr.getMessage(),admin.getUsername(),u.getUsername());
            WorkFlow.markAsRead(wr);
            JOptionPane.showMessageDialog(null, "Send Cleaning Task Request Successfully!");
            
            CardLayout layout =(CardLayout)this.rightPanel.getLayout();
            this.rightPanel.remove(this);
            layout.previous(this.rightPanel);
            }
        
        else {
            JOptionPane.showMessageDialog(null, "Please select any row");
        }
    }

    private void goBack() {
        CardLayout layout = (CardLayout) this.rightPanel.getLayout();
        this.rightPanel.remove(this);
        layout.previous(this.rightPanel);
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
        tblCleaningman = new javax.swing.JTable();
        btnSend = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        tblCleaningman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cleaner", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCleaningman);

        btnSend.setText("Send Request");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(129, 129, 129)
                        .addComponent(btnSend))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGoBack)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnRefresh)))
                .addContainerGap(255, Short.MAX_VALUE))
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
        populateCleaningTable();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCleaningman;
    // End of variables declaration//GEN-END:variables
}
