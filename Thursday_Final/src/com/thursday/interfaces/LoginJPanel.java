/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.interfaces.bar.TenementBarJPanel;
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
import javax.swing.JTextField;

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
        txtUsernameAddListener();
        txtPswdAddListener();
        setPasswordHint();
        setUsernameHint(usernameTxt);
    }

    private void txtUsernameAddListener() {
        usernameTxt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                emptyUsernameField(usernameTxt);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setUsernameHint(usernameTxt);
            }
        });
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

    private void setUsernameHint(JTextField jtf) {
        String content = jtf.getText();
        if (content.equals("") && jtf.getForeground().equals(Color.BLACK)) {
            jtf.setText("Username");
            jtf.setForeground(Color.LIGHT_GRAY);
        }
    }

    private void emptyUsernameField(JTextField jtf) {
        String content = jtf.getText();
        if (content.equals("Username") && jtf.getForeground().equals(Color.LIGHT_GRAY)) {
            jtf.setText("");
            jtf.setForeground(Color.BLACK);
        }
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
        btnGoBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        usernameTxt = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        userIconPanel1 = new com.thursday.resources.UserIconPanel();

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Login");

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userIconPanel1Layout = new javax.swing.GroupLayout(userIconPanel1);
        userIconPanel1.setLayout(userIconPanel1Layout);
        userIconPanel1Layout.setHorizontalGroup(
            userIconPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        userIconPanel1Layout.setVerticalGroup(
            userIconPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(passwordField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginBtn)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(userIconPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(userIconPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn))
                .addContainerGap())
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
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        char[] pswd = passwordField.getPassword();
        String uname = usernameTxt.getText();
        //User u = UserBiz.getUser(uname);

        if (Validator.IsEmpty(pswd)) {
            JOptionPane.showMessageDialog(this, "Please Enter Password", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (usernameTxt.getForeground().equals(Color.LIGHT_GRAY)||Validator.IsEmpty(uname)) {
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
        EcoSystem.resetPressTime();
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordField;
    private com.thursday.resources.UserIconPanel userIconPanel1;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
