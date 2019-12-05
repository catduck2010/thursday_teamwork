/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.CleaningCompUser;
import com.thursday.util.db.UserBiz;
import com.thursday.business.identities.User;
import com.thursday.business.UserDirectory;
import com.thursday.util.Validator;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CHEN JIEYING
 */
public class CreateJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateJPanel
     */
    private JPanel rightPanel;
    private UserBiz uBiz;
 
    
    public CreateJPanel(JPanel rightPanel) {
        initComponents();
        this.rightPanel = rightPanel;
        
        
                
        ItemListener il = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(apartmentRBtn.isSelected()){
                    roleComboBox.removeAllItems();
                    roleComboBox.addItem(ApartmentUser.Roles.ADMIN);
                    roleComboBox.addItem(ApartmentUser.Roles.REPAIRPERSON);
                    roleComboBox.addItem(ApartmentUser.Roles.RESIDENT);
                }else if(cleaningCompanyRBtn.isSelected()){
                    roleComboBox.removeAllItems();
                    roleComboBox.addItem(CleaningCompUser.Roles.HR);
                    roleComboBox.addItem(CleaningCompUser.Roles.CLEANER);
                    roleComboBox.addItem(CleaningCompUser.Roles.SCHEDULER);
                }
            }
        };
        this.apartmentRBtn.addItemListener(il);
        this.cleaningCompanyRBtn.addItemListener(il);
        
    }
    
    
    private void clearAllFields() {
        this.fnameTxt.setText("");
        this.lnameTxt.setText("");
        this.passwordField.setText("");
        this.repasswordField.setText("");
        this.usernameTxt.setText("");
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
        backBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        apartmentRBtn = new javax.swing.JRadioButton();
        cleaningCompanyRBtn = new javax.swing.JRadioButton();
        createBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fnameTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lnameTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        repasswordField = new javax.swing.JPasswordField();

        backBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        backBtn.setText("< back");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel2.setText("Identity");

        roleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel4.setText("Comfirm password");

        buttonGroup1.add(apartmentRBtn);
        apartmentRBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        apartmentRBtn.setText("Apartment");

        buttonGroup1.add(cleaningCompanyRBtn);
        cleaningCompanyRBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        cleaningCompanyRBtn.setText("Cleaning company");

        createBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel5.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel6.setText("Last Name");

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel1.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(backBtn)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cleaningCompanyRBtn)
                                    .addComponent(apartmentRBtn)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(createBtn)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(apartmentRBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cleaningCompanyRBtn)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(repasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(createBtn)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void roleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleComboBoxActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
        String firstname = fnameTxt.getText().trim();
        String lastname = lnameTxt.getText().trim();
        String username = usernameTxt.getText();
        char[] password = passwordField.getPassword();
        char[] repassword = repasswordField.getPassword();
        String role = (String)roleComboBox.getSelectedItem();

        if (Validator.IsEmpty(username)) {
            usernameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Username can't be empty");
            return;
        }
        if (!Validator.IsUsername(username)) {
            JOptionPane.showMessageDialog(null, "Username should be in the form of Words and Number");
            usernameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
            return;
        }

        if (Validator.IsEmpty(lastname)) {
            lnameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Last Name can't be empty");
            return;
        }
        
        if (Validator.IsEmpty(firstname)) {
            fnameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "First Name can't be empty");
            return;
        }

        if (Validator.IsEmpty(password)) {
            passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Password can't be empty");
            return;
        }
        if (!Validator.IsPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password should be in the form of at least 6 letters and including numbers, Lowercase and Uppercase ");
            passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            return;
        }

        if (Validator.IsEmpty(repassword)) {
            repasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Re-enter password can't be empty");
            return;
        }
        if (!Validator.IsSamePassword(password, repassword)) {
            JOptionPane.showMessageDialog(null, "Re-enter password is not as same as previous password");
            repasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            return;
        }
        if (UserDirectory.checkUsernameExistance(username)) {
            JOptionPane.showMessageDialog(this, "Username exists!",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            usernameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else if (apartmentRBtn.isSelected()) {
            UserDirectory.createApartmentUser(username, password, firstname, lastname, role);
            JOptionPane.showMessageDialog(null, "Account created Successfully");
            clearAllFields();
            //toMainScreen();
        } else if (cleaningCompanyRBtn.isSelected()) {
            UserDirectory.createCleaningCompUser(username, password, firstname, lastname, role);
            JOptionPane.showMessageDialog(null, "Account created Successfully");
            clearAllFields();
            //toMainScreen();
        }

    }//GEN-LAST:event_createBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton apartmentRBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cleaningCompanyRBtn;
    private javax.swing.JButton createBtn;
    private javax.swing.JTextField fnameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField lnameTxt;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField repasswordField;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
