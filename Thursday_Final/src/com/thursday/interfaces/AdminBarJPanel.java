/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

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
    
    public AdminBarJPanel(JPanel rightPanel,User u) {
        initComponents();
        this.user = u;
        this.rightPanel = rightPanel;
               
    }
private void manTaskPanel(){
        ManageTaskJPanel manageTaskJPanel = new ManageTaskJPanel(rightPanel);
        CardLayout layout = (CardLayout) jPanel2.getLayout();
        jPanel2.add("ManageTaskJPanel", manageTaskJPanel);
        layout.next(jPanel2);
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
        manageReqBtn = new javax.swing.JButton();
        manageStaffBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        jLabel1.setText("Hi, ");

        manageReqBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        manageReqBtn.setText("Manage Requests");
        manageReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageReqBtnActionPerformed(evt);
            }
        });

        manageStaffBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        manageStaffBtn.setText("Manage Staff");

        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        jButton1.setText("Manage Tenement");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(manageReqBtn)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(manageStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageReqBtn)
                    .addComponent(jButton1)
                    .addComponent(manageStaffBtn))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel2.setBackground(new java.awt.Color(153, 255, 102));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel2.setText("Click button to continue");
        jPanel2.add(jLabel2, "card2");

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void manageReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageReqBtnActionPerformed
        // TODO add your handling code here:
        manTaskPanel();
    }//GEN-LAST:event_manageReqBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageReqBtn;
    private javax.swing.JButton manageStaffBtn;
    // End of variables declaration//GEN-END:variables
}
