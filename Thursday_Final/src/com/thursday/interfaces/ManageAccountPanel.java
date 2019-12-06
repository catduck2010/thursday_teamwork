/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.business.EcoSystem;
import com.thursday.business.UserDirectory;
import com.thursday.business.identities.User;
import com.thursday.util.PasswordUtil;
import com.thursday.util.Validator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author lihangzhou
 */
public class ManageAccountPanel extends JPanel {

    private final JPanel rightPanel;
    private final User user;
    private boolean adminEditMode = false;
    static final String OLDPSWD_HINT = "Old Password";
    static final String NEWPSWD_HINT = "New Password";
    static final String RENEWPSWD_HINT = "Confirm New Password";
    static char defaultChar;

    /**
     * Creates new form ManageAccountPanel
     *
     * @param rightPanel
     * @param user
     */
    public ManageAccountPanel(JPanel rightPanel, User user) {
        initComponents();
        this.rightPanel = rightPanel;
        this.user = user;
        defaultChar = txtPwOld.getEchoChar();
        txtPswdAddListener(txtPwOld, OLDPSWD_HINT);
        txtPswdAddListener(txtPwNew, NEWPSWD_HINT);
        txtPswdAddListener(txtPwConfirm, RENEWPSWD_HINT);

        setPasswordHint(txtPwOld, OLDPSWD_HINT);
        setPasswordHint(txtPwNew, NEWPSWD_HINT);
        setPasswordHint(txtPwConfirm, RENEWPSWD_HINT);
        fillTxt();
    }

    public ManageAccountPanel(User user, JPanel rightPanel) {
        this(rightPanel, user);
        this.txtPwOld.setEnabled(false);
        this.adminEditMode = true;
    }

    private void txtPswdAddListener(JPasswordField jpf, String hint) {
        jpf.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {// when focus lost
                setPasswordHint(jpf, hint);
            }

            @Override
            public void focusGained(FocusEvent e) {// when focus gained
                emptyPasswordField(jpf, hint);
            }
        });
    }

    private void setPasswordHint(JPasswordField jpf, String hint) {
        String pswd = new String(jpf.getPassword());
        if (pswd.equals("")) {// no password
            jpf.setEchoChar('\0');// plaintext
            jpf.setText(hint);
            jpf.setForeground(Color.LIGHT_GRAY);
        }
    }

    private void emptyPasswordField(JPasswordField jpf, String hint) {
        String pswd = new String(jpf.getPassword());
        if (pswd.equals(hint)) {
            jpf.setText("");
            jpf.setEchoChar(defaultChar);// ciphertext
            jpf.setForeground(Color.BLACK);

        }
    }

    private boolean adminPasswordReset(char[] newpw, char[] renewpw) {
        if (!Validator.IsSamePassword(newpw, renewpw)) {
            JOptionPane.showMessageDialog(this, "New Password and Confirm Password is not the same!", "WARNING", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!Validator.IsPassword(newpw)) {
            JOptionPane.showMessageDialog(this, "Password should be in the form of at least 6 letters and \nincluding numbers, Lowercase and Uppercase.", "WARNING", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        user.setPasswd(PasswordUtil.hash(newpw));
        if (!UserDirectory.updateUser(user)) {
            JOptionPane.showMessageDialog(this, "Reset failed", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "New password set for this user.",
                    "RESET PASSWORD", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    private boolean passwordReset(char[] old, char[] newpw, char[] renewpw) {
        if (user.authenticate(old)) {
            if (old.length == 0 || newpw.length == 0 || renewpw.length == 0) {
                JOptionPane.showMessageDialog(this, "Three of fields should not be empty", "WARNING", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (!Validator.IsSamePassword(newpw, renewpw)) {
                JOptionPane.showMessageDialog(this, "New Password and Confirm Password is not the same!", "WARNING", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (!Validator.IsPassword(newpw)) {
                JOptionPane.showMessageDialog(this, "Password should be in the form of at least 6 letters and \nincluding numbers, Lowercase and Uppercase.", "WARNING", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if (!(user.resetPasswd(old, newpw) ? UserDirectory.updateUser(user) : false)) {
                JOptionPane.showMessageDialog(this, "Reset failed", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else {
                if (this.adminEditMode) {
                    JOptionPane.showMessageDialog(this, "New password set for this user.",
                            "RESET PASSWORD", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "New password set, you have to "
                            + "log out due to safety reasons.",
                            "RESET PASSWORD", JOptionPane.INFORMATION_MESSAGE);
                }
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Wrong old password", "Security", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private void btnEditSaveDoings() {
        if (this.btnEditSave.getText().equals("Save")) {//Save
            String uname = txtUsername.getText();
            String oldname = user.getUsername();
            if (Validator.IsEmpty(uname) || uname.equals(oldname)) {
                txtUsername.setText(oldname);
            } else if (!Validator.IsUsername(uname)) {
                JOptionPane.showMessageDialog(this, "Username should be in the form of Words and Numbers.", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else if (UserDirectory.checkUsernameExistance(uname)) {
                JOptionPane.showMessageDialog(this, "Username used by other people.", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {

                user.setUsername(uname);
                if (UserDirectory.updateUser(user)) {
                    JOptionPane.showMessageDialog(this, "Username changed.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    user.setUsername(oldname);
                    JOptionPane.showMessageDialog(this, "Failed to change Username.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            fillTxt();
            this.txtUsername.setEditable(false);
            this.btnEditSave.setText("Edit");
        } else {//Edit
            if (Validator.IsAdminUser(user.getUsername())) {
                JOptionPane.showMessageDialog(this, "You cannot edit administrators' usernames.", "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }
            this.txtUsername.setEditable(true);
            this.btnEditSave.setText("Save");
        }
    }

    private void fillTxt() {
        this.txtUsername.setText(user.getUsername());
        this.txtFName.setText(user.getFirstName());
        this.txtLName.setText(user.getLastName());
    }

    private void goBack() {
        CardLayout layout = (CardLayout) this.rightPanel.getLayout();
        this.rightPanel.remove(this);
        layout.previous(this.rightPanel);
    }

    private void refreshLast() {
        for (Component comp : rightPanel.getComponents()) {
            if (comp instanceof AdminManageStaffJPanel) {
                ((AdminManageStaffJPanel) comp).refreshTable();
                return;
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnGoBack = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        basicPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtLName = new javax.swing.JTextField();
        btnOkBasic = new javax.swing.JButton();
        btnEditSave = new javax.swing.JButton();
        txtFName = new javax.swing.JTextField();
        securityPanel = new javax.swing.JPanel();
        txtPwConfirm = new javax.swing.JPasswordField();
        txtPwNew = new javax.swing.JPasswordField();
        txtPwOld = new javax.swing.JPasswordField();
        btnOkPasswd = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        jLabel3.setText("Name");

        txtUsername.setEditable(false);

        btnOkBasic.setText("OK");
        btnOkBasic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkBasicActionPerformed(evt);
            }
        });

        btnEditSave.setText("Edit");
        btnEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout basicPanelLayout = new javax.swing.GroupLayout(basicPanel);
        basicPanel.setLayout(basicPanelLayout);
        basicPanelLayout.setHorizontalGroup(
            basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basicPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(basicPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFName, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLName, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOkBasic, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basicPanelLayout.createSequentialGroup()
                        .addComponent(txtUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        basicPanelLayout.setVerticalGroup(
            basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkBasic)
                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Basic Information", basicPanel);

        btnOkPasswd.setText("OK");
        btnOkPasswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkPasswdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout securityPanelLayout = new javax.swing.GroupLayout(securityPanel);
        securityPanel.setLayout(securityPanelLayout);
        securityPanelLayout.setHorizontalGroup(
            securityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(securityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(securityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPwOld, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addComponent(txtPwNew)
                    .addComponent(txtPwConfirm)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, securityPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOkPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        securityPanelLayout.setVerticalGroup(
            securityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, securityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPwOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPwNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPwConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(btnOkPasswd)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reset Password", securityPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGoBack)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkPasswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkPasswdActionPerformed
        // TODO add your handling code here:
        if (this.adminEditMode
                ? adminPasswordReset(txtPwNew.getPassword(), txtPwConfirm.getPassword())
                : passwordReset(txtPwOld.getPassword(), txtPwNew.getPassword(), txtPwConfirm.getPassword())) {
            if (!this.adminEditMode) {
                EcoSystem.logout();
                return;
            }
        }
        txtPwOld.setText("");
        txtPwNew.setText("");
        txtPwConfirm.setText("");
        setPasswordHint(txtPwOld, OLDPSWD_HINT);
        setPasswordHint(txtPwNew, NEWPSWD_HINT);
        setPasswordHint(txtPwConfirm, RENEWPSWD_HINT);

    }//GEN-LAST:event_btnOkPasswdActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        goBack();
        if (this.adminEditMode)
            refreshLast();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSaveActionPerformed
        // TODO add your handling code here:
        btnEditSaveDoings();
    }//GEN-LAST:event_btnEditSaveActionPerformed

    private void btnOkBasicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkBasicActionPerformed
        // TODO add your handling code here:
        String fName = txtFName.getText(),
                lName = txtLName.getText();
        if (Validator.IsEmpty(lName) || Validator.IsEmpty(fName)) {
            JOptionPane.showMessageDialog(this, "Either one of the names cannot be empty!", "Add Staff", JOptionPane.INFORMATION_MESSAGE);
        } else {
            user.setFirstName(fName);
            user.setLastName(lName);
            if (UserDirectory.updateUser(user)) {
                JOptionPane.showMessageDialog(this, "Information changed.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to change information.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnOkBasicActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basicPanel;
    private javax.swing.JButton btnEditSave;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnOkBasic;
    private javax.swing.JButton btnOkPasswd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel securityPanel;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JPasswordField txtPwConfirm;
    private javax.swing.JPasswordField txtPwNew;
    private javax.swing.JPasswordField txtPwOld;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
