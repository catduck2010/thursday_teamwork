/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.business.CompanyDirectory;
import com.thursday.business.UserDirectory;
import com.thursday.util.Validator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CHEN JIEYING
 */
public class CreateCompJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateCompJPanel
     */
    private JPanel rightPanel;

    public CreateCompJPanel(JPanel rightPanel) {
        initComponents();
        this.rightPanel = rightPanel;
    }

    private void clearAllFields() {
        this.CompNameTxt.setText("");
        this.adminNameTxt.setText("");
        this.passwordField.setText("");
        this.repasswordField.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnGoBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CompNameTxt = new javax.swing.JTextField();
        adminNameTxt = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        repasswordField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cleaningCompanyRBtn = new javax.swing.JRadioButton();
        apartmentRBtn = new javax.swing.JRadioButton();
        createBtn = new javax.swing.JButton();

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Add Company");

        adminNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminNameTxtActionPerformed(evt);
            }
        });

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Admin Username");

        jLabel3.setText("Password");

        jLabel4.setText("Comfirm password");

        jLabel1.setText("Comp. Name");

        buttonGroup1.add(cleaningCompanyRBtn);
        cleaningCompanyRBtn.setText("Cleaning company");

        buttonGroup1.add(apartmentRBtn);
        apartmentRBtn.setText("Apartment");
        apartmentRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apartmentRBtnActionPerformed(evt);
            }
        });

        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel1)
                    .addComponent(apartmentRBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cleaningCompanyRBtn)
                    .addComponent(repasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(adminNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CompNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cleaningCompanyRBtn)
                    .addComponent(apartmentRBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CompNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createBtn)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(651, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
        String adminName = adminNameTxt.getText().trim();
        String compName = CompNameTxt.getText().trim();
        char[] password = passwordField.getPassword();
        char[] repassword = repasswordField.getPassword();

        if (Validator.IsEmpty(compName)) {
            //CompNameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Company Name can't be empty");
            return;
        } else if (UserDirectory.checkUsernameExistance(compName)) {
            JOptionPane.showMessageDialog(this, "Company Name exists!",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
            //CompNameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else if (Validator.IsEmpty(adminName)) {
            //adminNameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Admin Name can't be empty");
            return;
        } else if (UserDirectory.checkUsernameExistance(adminName)) {
            JOptionPane.showMessageDialog(this, "Admin Name exists!",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
            //adminNameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
            //toMainScreen();
        } else if (!adminNameTxt.getText().toLowerCase().contains("admin")) {
            JOptionPane.showMessageDialog(this, "Admin's username should include words admin!",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
            //CompNameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else if (Validator.IsEmpty(password)) {
            //passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Password can't be empty");
            return;
        } else if (!Validator.IsPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password should be in the form of at least 6 letters and including numbers, Lowercase and Uppercase ");
            //passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            return;
        } else if (Validator.IsEmpty(repassword)) {
            //repasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Re-enter password can't be empty");
            return;
        } else if (!Validator.IsSamePassword(password, repassword)) {
            JOptionPane.showMessageDialog(null, "Re-enter password is not as same as previous password");
            //repasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            return;
        } else if (apartmentRBtn.isSelected()) {
            CompanyDirectory.createApartment(compName, adminName, password);
            JOptionPane.showMessageDialog(null, "New apartment created Successfully");
            clearAllFields();
            //toMainScreen();
        } else if (cleaningCompanyRBtn.isSelected()) {
            CompanyDirectory.createCleaningComp(compName, adminName, password);
            JOptionPane.showMessageDialog(null, "New cleaning company created Successfully");
            clearAllFields();
        } else {
            JOptionPane.showMessageDialog(null, "Please select company type");
        }


    }//GEN-LAST:event_createBtnActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void apartmentRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apartmentRBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apartmentRBtnActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.rightPanel.getLayout();
        this.rightPanel.remove(this);
        for (Component comp : this.getComponents()) {
            if (comp instanceof RootJPanel) {
                ((RootJPanel) comp).refreshTable();
                break;
            }
        }
        layout.previous(this.rightPanel);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void adminNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminNameTxtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_adminNameTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CompNameTxt;
    private javax.swing.JTextField adminNameTxt;
    private javax.swing.JRadioButton apartmentRBtn;
    private javax.swing.JButton btnGoBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cleaningCompanyRBtn;
    private javax.swing.JButton createBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField repasswordField;
    // End of variables declaration//GEN-END:variables
}
