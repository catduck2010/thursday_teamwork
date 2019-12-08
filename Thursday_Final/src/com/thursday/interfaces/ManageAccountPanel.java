/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;

import com.thursday.business.Company;
import com.thursday.business.CompanyDirectory;
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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author lihangzhou
 */
public class ManageAccountPanel extends JPanel {

    private JPanel rightPanel;
    private User user;
    private boolean adminEditMode = false;
    private boolean rootEditMode = false;
    private String companyOldName = "";
    static final String OLDPSWD_HINT = "Old Password";
    static final String NEWPSWD_HINT = "New Password";
    static final String RENEWPSWD_HINT = "Confirm New Password";
    static char defaultChar;

    private ManageAccountPanel() {
        initComponents();
        defaultChar = txtPwOld.getEchoChar();
        txtPswdAddListener(txtPwOld, OLDPSWD_HINT);
        txtPswdAddListener(txtPwNew, NEWPSWD_HINT);
        txtPswdAddListener(txtPwConfirm, RENEWPSWD_HINT);

        setPasswordHint(txtPwOld, OLDPSWD_HINT);
        setPasswordHint(txtPwNew, NEWPSWD_HINT);
        setPasswordHint(txtPwConfirm, RENEWPSWD_HINT);
    }

    /**
     * Creates new form ManageAccountPanel
     *
     * @param rightPanel
     * @param user
     */
    public ManageAccountPanel(JPanel rightPanel, User user) {
        this();
        this.rightPanel = rightPanel;
        this.user = user;
        this.btnGoBack.setEnabled(false);
        this.tabPane.remove(0);
        fillTxt();
    }

    public ManageAccountPanel(User user, JPanel rightPanel) {
        this();
        this.rightPanel = rightPanel;
        this.user = user;
        this.txtPwOld.setEnabled(false);
        this.adminEditMode = true;
        this.btnGoBack.setEnabled(true);
        this.tabPane.remove(0);
        fillTxt();
    }

    public ManageAccountPanel(JPanel rightPanel, String company, User user) {
        this();
        this.rightPanel = rightPanel;
        this.user = user;
        this.lblTitle.setText("Manage Company");
        this.txtCompany.setText(company);
        this.txtPwOld.setEnabled(false);
        this.adminEditMode = true;
        this.rootEditMode = true;
        this.btnGoBack.setEnabled(true);
        fillTxt();
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
        try {
            if (!UserDirectory.updateUser(user)) {
                JOptionPane.showMessageDialog(this, "Reset failed", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "New password set for this user.",
                        "RESET PASSWORD", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
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
            try {
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
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
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
            try {
                if (Validator.IsEmpty(uname) || uname.equals(oldname)) {
                    txtUsername.setText(oldname);
                } else if (!Validator.IsUsername(uname)) {
                    JOptionPane.showMessageDialog(this, "Username should be in the form of Words and Numbers.", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else if (UserDirectory.checkUsernameExistance(uname)) {
                    JOptionPane.showMessageDialog(this, "Username used by other people.", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else if (rootEditMode && !uname.toLowerCase().contains("admin")) {
                    JOptionPane.showMessageDialog(this, "Administrators' username should contain string \"admin\".", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else {

                    user.setUsername(uname);
                    if (UserDirectory.updateUser(user)) {
                        JOptionPane.showMessageDialog(this, "Username changed.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        user.setUsername(oldname);
                        JOptionPane.showMessageDialog(this, "Failed to change Username.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            } finally {
                fillTxt();
                this.txtUsername.setEditable(false);
                this.btnEditSave.setText("Edit");
            }
        } else {//Edit
            if (Validator.IsAdminUser(user.getUsername()) && !rootEditMode) {
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
            }
            if (comp instanceof RootJPanel) {
                ((RootJPanel) comp).refreshTable();
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
        tabPane = new javax.swing.JTabbedPane();
        companyPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtCompany = new javax.swing.JTextField();
        btnCompanySave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        basicPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtLName = new javax.swing.JTextField();
        btnOkBasic = new javax.swing.JButton();
        btnEditSave = new javax.swing.JButton();
        txtFName = new javax.swing.JTextField();
        userIconPanel1 = new com.thursday.resources.UserIconPanel();
        securityPanel = new javax.swing.JPanel();
        txtPwConfirm = new javax.swing.JPasswordField();
        txtPwNew = new javax.swing.JPasswordField();
        txtPwOld = new javax.swing.JPasswordField();
        btnOkPasswd = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        jTextField3.setText("jTextField3");

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        btnCompanySave.setText("Edit");
        btnCompanySave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompanySaveActionPerformed(evt);
            }
        });

        jLabel4.setText("Company Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCompanySave))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompanySave))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout companyPanelLayout = new javax.swing.GroupLayout(companyPanel);
        companyPanel.setLayout(companyPanelLayout);
        companyPanelLayout.setHorizontalGroup(
            companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        companyPanelLayout.setVerticalGroup(
            companyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        tabPane.addTab("Company Info", companyPanel);

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

        javax.swing.GroupLayout basicPanelLayout = new javax.swing.GroupLayout(basicPanel);
        basicPanel.setLayout(basicPanelLayout);
        basicPanelLayout.setHorizontalGroup(
            basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userIconPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basicPanelLayout.createSequentialGroup()
                        .addComponent(txtFName, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLName, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOkBasic, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(basicPanelLayout.createSequentialGroup()
                        .addComponent(txtUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        basicPanelLayout.setVerticalGroup(
            basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicPanelLayout.createSequentialGroup()
                .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basicPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditSave)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOkBasic)
                            .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(basicPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userIconPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(256, Short.MAX_VALUE))
        );

        tabPane.addTab("Basic Information", basicPanel);

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
                    .addComponent(txtPwOld, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOkPasswd)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        tabPane.addTab("Reset Password", securityPanel);

        lblTitle.setText("Manage Account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPane))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            try {
                if (UserDirectory.updateUser(user)) {
                    JOptionPane.showMessageDialog(this, "Information changed.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to change information.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error on SQL actions: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnOkBasicActionPerformed

    private void btnCompanySaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompanySaveActionPerformed
        // TODO add your handling code here:
        String s = btnCompanySave.getText();
        if (s.equals("Edit")) {
            this.companyOldName = this.txtCompany.getText();
            this.txtCompany.setEditable(true);
            this.btnCompanySave.setText("Save");
        } else {//save
            try {
                String newname = this.txtCompany.getText();
                if (Validator.IsEmpty(newname)) {
                    JOptionPane.showMessageDialog(this, "Company name should not be empty!", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else if (CompanyDirectory.checkCompanyExistance(newname)) {
                    JOptionPane.showMessageDialog(this, "This Company name is Used!", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else {
                    Company c = CompanyDirectory.getCompany(this.companyOldName);
                    if (c != null) {
                        c.setCompanyName(newname);
                        if (CompanyDirectory.updateCompany(c)) {
                            companyOldName = newname;
                            JOptionPane.showMessageDialog(this, "Company Name Changed.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                            User updatedUser = UserDirectory.getUser(user.getUsername());
                            if (updatedUser != null) {
                                this.user = updatedUser;
                                fillTxt();
                            } else {
                                goBack();
                                refreshLast();
                                return;
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to change this company's!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to get this company's information!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {

            } finally {

                this.txtCompany.setText(companyOldName);
                this.txtCompany.setEditable(false);
                this.btnCompanySave.setText("Edit");
            }
        }
    }//GEN-LAST:event_btnCompanySaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basicPanel;
    private javax.swing.JButton btnCompanySave;
    private javax.swing.JButton btnEditSave;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnOkBasic;
    private javax.swing.JButton btnOkPasswd;
    private javax.swing.JPanel companyPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel securityPanel;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JPasswordField txtPwConfirm;
    private javax.swing.JPasswordField txtPwNew;
    private javax.swing.JPasswordField txtPwOld;
    private javax.swing.JTextField txtUsername;
    private com.thursday.resources.UserIconPanel userIconPanel1;
    // End of variables declaration//GEN-END:variables
}
