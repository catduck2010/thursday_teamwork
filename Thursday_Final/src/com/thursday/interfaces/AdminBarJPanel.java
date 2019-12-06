/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.User;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author CHEN JIEYING
 */
public class AdminBarJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminBarJPanel
     */
    private final User user;
    private JPanel rightPanel;

    public AdminBarJPanel(JPanel rightPanel, User u) {
        initComponents();
        this.user = u;
        this.rightPanel = rightPanel;
    }

    private void manTaskPanel() {
        ManageTaskJPanel manageTaskJPanel = new ManageTaskJPanel(downPanel, user);
        CardLayout layout = (CardLayout) downPanel.getLayout();
        downPanel.add("ManageTaskJPanel", manageTaskJPanel);
        layout.next(downPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnManageReq = new javax.swing.JButton();
        btnManageStaff = new javax.swing.JButton();
        btnManageTnmt = new javax.swing.JButton();
        downPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        jLabel1.setText("Hi, ");

        btnManageReq.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        btnManageReq.setText("Manage Requests");
        btnManageReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageReqActionPerformed(evt);
            }
        });

        btnManageStaff.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        btnManageStaff.setText("Manage Staff");
        btnManageStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageStaffActionPerformed(evt);
            }
        });

        btnManageTnmt.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        btnManageTnmt.setText("Manage Tenements");
        btnManageTnmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageTnmtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnManageReq)
                        .addGap(31, 31, 31)
                        .addComponent(btnManageTnmt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnManageStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManageReq)
                    .addComponent(btnManageTnmt)
                    .addComponent(btnManageStaff))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        downPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setBackground(new java.awt.Color(153, 255, 102));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Click button to continue");
        downPanel.add(jLabel2, "card2");

        jSplitPane1.setRightComponent(downPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageStaffActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.downPanel.getLayout();
        JPanel panel = new AdminManageStaffJPanel(downPanel, user, ApartmentUser.Roles.REPAIRPERSON);
        this.downPanel.add("AdminManageStaffJPanel", panel);
        layout.next(this.downPanel);
    }//GEN-LAST:event_btnManageStaffActionPerformed

    private void btnManageTnmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageTnmtActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.downPanel.getLayout();
        this.downPanel.add("AdminManageResidentJPanel",new AdminManageStaffJPanel(downPanel, user, ApartmentUser.Roles.RESIDENT));
        layout.next(this.downPanel);
    }//GEN-LAST:event_btnManageTnmtActionPerformed

    private void btnManageReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageReqActionPerformed
        // TODO add your handling code here:
        manTaskPanel();
    }//GEN-LAST:event_btnManageReqActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageReq;
    private javax.swing.JButton btnManageStaff;
    private javax.swing.JButton btnManageTnmt;
    private javax.swing.JPanel downPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
