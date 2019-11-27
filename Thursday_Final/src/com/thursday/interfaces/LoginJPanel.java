/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces;



import com.thursday.business.identities.ApartmentUserBiz;
import com.thursday.business.identities.CleaningCompUserBiz;
import com.thursday.business.identities.User;
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
    
    private ApartmentUserBiz apBiz;
    private CleaningCompUserBiz ccBiz;

    private final MainFrame mFrame;
    private final JPanel rightPanel;
    private User user;
    private boolean noUser;
    static final String TXTPSWD_HINT = "Password";
    static char defaultChar;
    private String username;
    
    public LoginJPanel(MainFrame f, ApartmentUserBiz apBiz, CleaningCompUserBiz ccBiz) {
        initComponents();
        this.mFrame = f;
        this.rightPanel = f.getRightPanel();
        this.apBiz = apBiz;
        this.ccBiz = ccBiz;
        this.username = username;
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

        this.apartmentRBtn.addItemListener(il);
        this.cleaningCompanyRBtn.addItemListener(il);
        defaultChar = this.passwordField.getEchoChar();
        //fillUserBox();
        //set empty password
//        txtPswd.setText(TXTPSWD_HINT);
//        txtPswd.setEchoChar('\0');
//        txtPswd.setForeground(Color.GRAY);

        //set user "Administrator" default password
        passwordField.setText("admin");

        txtPswdAddListener();
    }

/*    
    private void fillUserBox() {
        noUser = true;

        if (apartmentRBtn.isSelected()) {
            if (apartment.isEmpty()) {
                //set no user
                setUserBoxEmpty();
            } else {
                //fill the box
                noUser = false;
                loadBoxWithAdmins(apartment.getApartmentList());
            }
        } else if (cleaningCompanyRBtn.isSelected()) {
            if (cleaningComp.isEmpty()) {
                setUserBoxEmpty();
            } else {
                noUser = false;
                loadBoxWithAirliners(cleaningComp.getCleaningCompList());
            }
        } else {

        }
    }

    private void setUserBoxEmpty() {
        this.boxUsers.removeAllItems();
        this.boxUsers.addItem("No Users");
    }
//////////////////////////////////////////////////////////////////////////////////////////////
    private void loadBoxWithAdmins(ArrayList<Admin> al) {
        this.boxUsers.removeAllItems();
        for (Admin a : al) {
            this.boxUsers.addItem(a);
        }
    }

    private void loadBoxWithAirliners(ArrayList<Airliner> al) {
        this.boxUsers.removeAllItems();
        for (Airliner a : al) {
            this.boxUsers.addItem(a);
        }
    }

    private void loadBoxWithCustomers(ArrayList<Customer> al) {
        this.boxUsers.removeAllItems();
        for (Customer a : al) {
            this.boxUsers.addItem(a);
        }
    }
*/
    private void txtPswdAddListener() {
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {// when focus lost
                String pswd = new String(passwordField.getPassword());
                if (pswd.equals("")) {// no password
                    passwordField.setEchoChar('\0');// plaintext
                    passwordField.setText(TXTPSWD_HINT);
                    passwordField.setForeground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {// when focus gained
                String pswd = new String(passwordField.getPassword());
                if (pswd.equals(TXTPSWD_HINT)) {
                    passwordField.setText("");
                    passwordField.setEchoChar(defaultChar);// ciphertext
                    passwordField.setForeground(Color.BLACK);
                }
            }
        });
    }

    private void grantAccess() {
        if(apartmentRBtn.isSelected()){
            User u=ApartmentUserBiz.getUser(usernameTxt.getText());
            if(u.authenticate(passwordField.getPassword())){
                CardLayout layout = (CardLayout) this.rightPanel.getLayout();
                AdminBarJPanel panel = new AdminBarJPanel(rightPanel,user);
                this.rightPanel.add("AdminBarJPanel", panel);
                layout.next(rightPanel);
            }else{
                JOptionPane.showMessageDialog(this, "Wrong Password", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            User u=CleaningCompUserBiz.getUser(usernameTxt.getText());
            if(u.authenticate(passwordField.getPassword())){
                CardLayout layout = (CardLayout) this.rightPanel.getLayout();
                HRBarJPanel panel = new HRBarJPanel(rightPanel,user);
                this.rightPanel.add("HRBarJPanel", panel);
                layout.next(rightPanel);
            }else{
                JOptionPane.showMessageDialog(this, "Wrong Password", "WARNING", JOptionPane.WARNING_MESSAGE);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        apartmentRBtn = new javax.swing.JRadioButton();
        cleaningCompanyRBtn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();

        jLabel1.setText("Login as:");

        buttonGroup1.add(apartmentRBtn);
        apartmentRBtn.setSelected(true);
        apartmentRBtn.setText("Apartment");

        buttonGroup1.add(cleaningCompanyRBtn);
        cleaningCompanyRBtn.setText("Cleaning company");

        jLabel3.setText("Password");

        jButton1.setText("Login");

        jLabel5.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addGap(419, 419, 419))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cleaningCompanyRBtn)
                            .addComponent(apartmentRBtn)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(apartmentRBtn)
                .addGap(18, 18, 18)
                .addComponent(cleaningCompanyRBtn)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(103, 103, 103))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton apartmentRBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cleaningCompanyRBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
