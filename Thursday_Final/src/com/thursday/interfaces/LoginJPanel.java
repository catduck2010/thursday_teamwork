/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.interfaces.apartment.TenementBarJPanel;
import com.thursday.interfaces.bar.RepairBarJPanel;
import com.thursday.interfaces.bar.CleanerBarJPanel;
import com.thursday.interfaces.bar.AdminBarJPanel;
import com.thursday.interfaces.bar.HRBarJPanel;
import com.thursday.business.EcoSystem;
import com.thursday.business.identities.AbstractUser;
import com.thursday.util.db.UserBiz;
import com.thursday.business.identities.User;
import com.thursday.business.UserDirectory;
import com.thursday.business.identities.ApartmentUser;
import com.thursday.business.identities.CleaningCompUser;
import com.thursday.util.Validator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CHEN JIEYING
 */
public class LoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginJPanel
     */
    private UserBiz apBiz;

    private final MainFrame mFrame;
    private final JPanel rightPanel;
    //private User user;
    static final String TXTPSWD_HINT = "Password";
    static char defaultChar;

    public LoginJPanel(MainFrame f, UserBiz apBiz) {
        initComponents();
        this.mFrame = f;
        this.rightPanel = f.getRightPanel();
        this.apBiz = apBiz;

        ItemListener il = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //System.out.println(e.getSource());
                //fillUserBox();
                passwordField.setText(TXTPSWD_HINT);
                passwordField.setEchoChar('\0');
                passwordField.setForeground(Color.GRAY);
            }
        };

        defaultChar = this.passwordField.getEchoChar();
        //set user "Administrator" default password

        txtPswdAddListener();
        setPasswordHint();
    }

    private void txtPswdAddListener() {
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {// when focus lost
                setPasswordHint();
            }

            @Override
            public void focusGained(FocusEvent e) {// when focus gained
                emptyPasswordField();
            }
        });
    }

    private void setPasswordHint() {
        String pswd = new String(passwordField.getPassword());
        if (pswd.equals("")) {// no password
            passwordField.setEchoChar('\0');// plaintext
            passwordField.setText(TXTPSWD_HINT);
            passwordField.setForeground(Color.LIGHT_GRAY);
        }
    }

    private void emptyPasswordField() {
        String pswd = new String(passwordField.getPassword());
        if (pswd.equals(TXTPSWD_HINT)) {
            passwordField.setText("");
            passwordField.setEchoChar(defaultChar);// ciphertext
            passwordField.setForeground(Color.BLACK);

        }
    }

    private void grantAccess(User user) {
        if (UserDirectory.isApartmentUser(user)) {
            CardLayout layout = (CardLayout) this.rightPanel.getLayout();
            JPanel panel = swicthPanel(user);
            this.rightPanel.add("AdminBarJPanel", panel);
            layout.next(rightPanel);

        } else if (UserDirectory.isCleaningCompUser(user)) {
            CardLayout layout = (CardLayout) this.rightPanel.getLayout();
            JPanel panel = swicth2Panel(user);
            this.rightPanel.add("HRBarJPanel", panel);
            layout.next(rightPanel);
        }
        EcoSystem.login(user);
        this.passwordField.setText("");
        this.usernameTxt.setText("");
    }

    private JPanel swicthPanel(User u) {
        String role = u.getRole();
        switch (role) {
            case ApartmentUser.Roles.ADMIN:
                return new AdminBarJPanel(rightPanel, u);
            case ApartmentUser.Roles.REPAIRPERSON:
                return new RepairBarJPanel(rightPanel, u);
            case ApartmentUser.Roles.RESIDENT:
                return new TenementBarJPanel(rightPanel, u);
        }
        return null;
    }

    private JPanel swicth2Panel(User u) {
        String role = u.getRole();
        switch (role) {
            case CleaningCompUser.Roles.HR:
                return new HRBarJPanel(rightPanel, u);
            case CleaningCompUser.Roles.CLEANER:
                return new CleanerBarJPanel(rightPanel, u);
            case CleaningCompUser.Roles.SCHEDULER:
                return new CleanerBarJPanel(rightPanel, u);
        }
        return null;
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
        jLabel3 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        btnGoBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel3.setText("Password");

        loginBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel5.setText("Username");

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTxt)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(loginBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(jLabel1))
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(loginBtn)
                .addContainerGap(192, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        char[] pswd = passwordField.getPassword();
        String uname = usernameTxt.getText();
        //User u = UserBiz.getUser(uname);

        if (Validator.IsEmpty(pswd)) {
            JOptionPane.showMessageDialog(this, "Please Enter Password", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (Validator.IsEmpty(uname)) {
            JOptionPane.showMessageDialog(this, "Please Enter Username", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            User u = UserDirectory.authenticateUser(usernameTxt.getText(), passwordField.getPassword());
            if (u == null) {
                JOptionPane.showMessageDialog(this, "Incorrect Username or Password", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else if (u.getRole().equals("SUPERUSER") && u.getUsername().equals("root")) {
                RootJPanel panel = new RootJPanel(rightPanel);
                rightPanel.add("RootJPanel", panel);
                CardLayout layout = (CardLayout) this.rightPanel.getLayout();
                layout.next(rightPanel);
                EcoSystem.login(u);
                this.passwordField.setText("");
                this.usernameTxt.setText("");
            } else {
                System.out.println("pass");
                grantAccess(u);
            }
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.rightPanel.getLayout();
        this.rightPanel.remove(this);
        layout.previous(this.rightPanel);
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
