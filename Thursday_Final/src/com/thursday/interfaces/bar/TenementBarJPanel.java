/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces.bar;

import com.thursday.interfaces.apartment.TenementTaskJPanel;
import com.thursday.business.identities.User;
import com.thursday.interfaces.ManageAccountPanel;
import com.thursday.interfaces.apartment.ManageMyRequestsJPanel;
import com.thursday.interfaces.apartment.TenementTaskJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author CHEN JIEYING
 */
public class TenementBarJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TenementJPanel
     */
    private final User user;
    private final JPanel rightPanel;

    public TenementBarJPanel(JPanel rightPanel, User u) {
        initComponents();
        this.rightPanel = rightPanel;
        this.user = u;
    }
private void taskPanel(){
        TenementTaskJPanel tenementTaskJPanel = new TenementTaskJPanel(downPanel,user);
        CardLayout layout = (CardLayout) downPanel.getLayout();
        downPanel.add("TenementTaskJPanel", tenementTaskJPanel);
        layout.next(downPanel);
}
private void ManageMyTaskPanel(){
    ManageMyRequestsJPanel manageMyRequestsJPanel = new ManageMyRequestsJPanel(downPanel,user);
        CardLayout layout = (CardLayout) downPanel.getLayout();
        downPanel.add("ManageMyRequestsJPanel", manageMyRequestsJPanel);
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
        manageReqBtn = new javax.swing.JButton();
        manageAccountBtn = new javax.swing.JButton();
        btnManageMyRequests = new javax.swing.JButton();
        downPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jSplitPane1.setBorder(null);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        manageReqBtn.setText("Make Requests");
        manageReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageReqBtnActionPerformed(evt);
            }
        });

        manageAccountBtn.setText("Manage Account");
        manageAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAccountBtnActionPerformed(evt);
            }
        });

        btnManageMyRequests.setText("Manage My Requests");
        btnManageMyRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageMyRequestsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(manageReqBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManageMyRequests)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageAccountBtn)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageAccountBtn)
                    .addComponent(manageReqBtn)
                    .addComponent(btnManageMyRequests))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        downPanel.setLayout(new java.awt.CardLayout());

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
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageReqBtnActionPerformed
        // TODO add your handling code here:
        taskPanel();
    }//GEN-LAST:event_manageReqBtnActionPerformed

    private void manageAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountBtnActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.downPanel.getLayout();
        this.downPanel.add("ManageAccountPanel", new ManageAccountPanel(downPanel, user));
        layout.next(downPanel);
    }//GEN-LAST:event_manageAccountBtnActionPerformed

    private void btnManageMyRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageMyRequestsActionPerformed
        // TODO add your handling code here:
        ManageMyTaskPanel();
    }//GEN-LAST:event_btnManageMyRequestsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageMyRequests;
    private javax.swing.JPanel downPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageAccountBtn;
    private javax.swing.JButton manageReqBtn;
    // End of variables declaration//GEN-END:variables
}
