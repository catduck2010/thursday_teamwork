/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.interfaces;

import com.travel.business.Business;
import static com.travel.interfaces.LoginPanel.TXTPSWD_HINT;
import com.travel.users.*;
import com.travel.util.Validator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lihang
 */
public class MyUsernamePswdPanel extends javax.swing.JPanel {

    /**
     * Creates new form MyUsernamePswd
     */
    private final JPanel bottomPanel;
    private final User user;
    private boolean isEditing = false;

    private boolean noUser;
    static final String PWOLD_HINT = "Old Password";
    static final String PWNEW_HINT = "New Password";
    static final String PWCONF_HINT = "Confirm New Password";
    static char defaultChar;

    public MyUsernamePswdPanel(JPanel jp, User u) {
        initComponents();
        this.bottomPanel = jp;
        this.user = u;
        this.txtUsername.setText(user.getUsername());
        defaultChar = pwOld.getEchoChar();
        pwOld.setEchoChar('\0');
        pwNew.setEchoChar('\0');
        pwConfirmNew.setEchoChar('\0');
        pwOld.setForeground(Color.LIGHT_GRAY);
        pwNew.setForeground(Color.LIGHT_GRAY);
        pwConfirmNew.setForeground(Color.LIGHT_GRAY);
        pwOld.setText(PWOLD_HINT);
        pwNew.setText(PWNEW_HINT);
        pwConfirmNew.setText(PWCONF_HINT);
        this.pwOld.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {// when focus lost
                String pswd = new String(pwOld.getPassword()).trim();
                if (pswd.equals("")) {// no password
                    pwOld.setEchoChar('\0');// plaintext
                    pwOld.setText(PWOLD_HINT);
                    pwOld.setForeground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {// when focus gained
                String pswd = new String(pwOld.getPassword()).trim();
                if (pswd.equals(PWOLD_HINT)) {
                    pwOld.setText("");
                    pwOld.setEchoChar(defaultChar);// ciphertext
                    pwOld.setForeground(Color.BLACK);
                }
            }
        });
        this.pwNew.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {// when focus lost
                String pswd = new String(pwNew.getPassword()).trim();
                if (pswd.equals("")) {// no password
                    pwNew.setEchoChar('\0');// plaintext
                    pwNew.setText(PWNEW_HINT);
                    pwNew.setForeground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {// when focus gained
                String pswd = new String(pwNew.getPassword()).trim();
                if (pswd.equals(PWNEW_HINT)) {
                    pwNew.setText("");
                    pwNew.setEchoChar(defaultChar);// ciphertext
                    pwNew.setForeground(Color.BLACK);
                }
            }
        });
        this.pwConfirmNew.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {// when focus lost
                String pswd = new String(pwConfirmNew.getPassword()).trim();
                if (pswd.equals("")) {// no password
                    pwConfirmNew.setEchoChar('\0');// plaintext
                    pwConfirmNew.setText(PWCONF_HINT);
                    pwConfirmNew.setForeground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {// when focus gained
                String pswd = new String(pwConfirmNew.getPassword()).trim();
                if (pswd.equals(PWCONF_HINT)) {
                    pwConfirmNew.setText("");
                    pwConfirmNew.setEchoChar(defaultChar);// ciphertext
                    pwConfirmNew.setForeground(Color.BLACK);
                }
            }
        });
    }

    private boolean isValidUsername(String username) {
        int type = user.getUserType();
        switch (user.getUserType()) {
            case User.ADMINISTRATOR:
                if (Business.getInstance().getAdmins().getAdmin(username) == null
                        || Business.getInstance().getAdmins().getAdmin(username).equals((Admin) user)) {
                    return true;
                }
                break;
            case User.AIRLINER:
                if (Business.getInstance().getAirliners().getAirliner(username) == null
                        || Business.getInstance().getAirliners().getAirliner(username).equals((Airliner) user)) {
                    return true;
                }
                break;
            case User.CUSTOMER:
                if (Business.getInstance().getCustomers().getCustomer(username) == null
                        || Business.getInstance().getCustomers().getCustomer(username).equals((Customer) user)) {
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        btnEditSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pwOld = new javax.swing.JPasswordField();
        pwNew = new javax.swing.JPasswordField();
        pwConfirmNew = new javax.swing.JPasswordField();
        btnSavePw = new javax.swing.JButton();

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Username"));

        txtUsername.setEditable(false);

        btnEditSave.setText("Edit");
        btnEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditSave)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Password"));

        btnSavePw.setText("Save");
        btnSavePw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwOld)
                    .addComponent(pwNew)
                    .addComponent(pwConfirmNew))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSavePw, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pwOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwConfirmNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSavePw))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGoBack)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        this.bottomPanel.remove(this);
        layout.previous(this.bottomPanel);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnSavePwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePwActionPerformed
        // TODO add your handling code here:
        String oldPw = new String(this.pwOld.getPassword());
        String newPw = new String(this.pwNew.getPassword());
        String confirm = new String(this.pwConfirmNew.getPassword());

        if (!user.verify(oldPw)) {
            JOptionPane.showMessageDialog(this, "Old Password is Incorrect!",
                    "WARNING", JOptionPane.WARNING_MESSAGE);

        } else {
            if (Validator.IsEmpty(newPw)) {
                JOptionPane.showMessageDialog(this, "New Password cannot be Empty!",
                        "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!Validator.IsPassword(newPw)) {
                JOptionPane.showMessageDialog(this,
                        "Password should be in the form of at least 6 "
                        + "letters and including numbers, "
                        + "Lowercase and Uppercase ",
                        "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (Validator.IsEmpty(confirm)) {
                JOptionPane.showMessageDialog(this, "Confirm Password cannot be Empty!",
                        "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!Validator.IsSamePassword(newPw, confirm)) {
                JOptionPane.showMessageDialog(this, "Re-enter password is "
                        + "not as same as previous password",
                        "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }
            user.setPasswd(newPw);
            JOptionPane.showMessageDialog(this, "New Password is set and "
                    + "you are going to log out for safety reasons.",
                    "New Password Set", JOptionPane.INFORMATION_MESSAGE);
            Business.getInstance().getMainFrame().logOut();
        }
    }//GEN-LAST:event_btnSavePwActionPerformed

    private void btnEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSaveActionPerformed
        // TODO add your handling code here:
        if (user.getUsername().equals("Administrator")) {
            JOptionPane.showMessageDialog(this, "Superuser's username "
                    + "is not allowed to edit.",
                    "Administrator", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!isEditing) {
            this.txtUsername.setEditable(true);
            isEditing = true;
            this.btnEditSave.setText("Save");
        } else {
            String uname = this.txtUsername.getText().trim();
            if (!isValidUsername(uname)) {
                JOptionPane.showMessageDialog(this, "New Username has been used by another account!",
                        "WARNING", JOptionPane.WARNING_MESSAGE);
                this.txtUsername.setText(user.getUsername());
            } else {
                if (Validator.IsUsername(uname)) {
                    this.user.setUsername(uname);
                    JOptionPane.showMessageDialog(this, "Username is set!",
                            "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "New Username is invalid!",
                            "WARNING", JOptionPane.WARNING_MESSAGE);
                    this.txtUsername.setText(user.getUsername());
                }
            }
            this.txtUsername.setEditable(false);
            isEditing = false;
            this.btnEditSave.setText("Edit");
        }
    }//GEN-LAST:event_btnEditSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditSave;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSavePw;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pwConfirmNew;
    private javax.swing.JPasswordField pwNew;
    private javax.swing.JPasswordField pwOld;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
