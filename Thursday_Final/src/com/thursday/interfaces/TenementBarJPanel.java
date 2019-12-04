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
public class TenementBarJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TenementJPanel
     */
    private final User user;
    private JPanel rightPanel;
    
    public TenementBarJPanel(JPanel rightPanel,User u) {
        initComponents();
        this.user = u;
        this.rightPanel =rightPanel;
    }
private void taskPanel(){
        TenementTaskJPanel tenementTaskJPanel = new TenementTaskJPanel(rightPanel,user);
        CardLayout layout = (CardLayout) jPanel2.getLayout();
        jPanel2.add("TenementTaskJPanel", tenementTaskJPanel);
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
        manageAccountBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        jLabel1.setText("Hi, ");

        manageReqBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        manageReqBtn.setText("Make Requests");
        manageReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageReqBtnActionPerformed(evt);
            }
        });

        manageAccountBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 22)); // NOI18N
        manageAccountBtn.setText("Manage Account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(manageReqBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(manageAccountBtn)
                .addGap(126, 126, 126))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageReqBtn)
                    .addComponent(manageAccountBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel2.setText("Click button to continue");
        jPanel2.add(jLabel2, "card2");

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton manageAccountBtn;
    private javax.swing.JButton manageReqBtn;
    // End of variables declaration//GEN-END:variables
}
