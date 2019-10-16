/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.interfaces;

import com.travel.users.Airliner;
import com.travel.users.Customer;
import com.travel.users.User;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.travel.business.Business;

/**
 *
 * @author lihang
 */
public class MainMenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainMenuPanel
     */
    private final User user;

    public MainMenuPanel(JPanel rightPanel, User u) {
        initComponents();
        this.user = u;
        //this.lblUsername.setText(u.getUsername());
        detectUserType();
    }

    private void detectUserType() {
        switch (user.getUserType()) {
            case User.ADMINISTRATOR:

                lblUsername.setText(user.getUsername());
                btnAdmins.setEnabled(true);
                btnAirliner.setEnabled(true);
                btnCustomers.setEnabled(true);
                btnAircrafts.setEnabled(false);
                btnBookFlight.setEnabled(true);
                btnFlights.setEnabled(true);
                btnProfile.setEnabled(false);
                break;
            case User.AIRLINER:
                lblUsername.setText(((Airliner) user).getProviderName());
                btnAdmins.setEnabled(false);
                btnAirliner.setEnabled(false);
                btnCustomers.setEnabled(false);
                btnAircrafts.setEnabled(true);
                btnBookFlight.setEnabled(false);
                btnFlights.setEnabled(false);
                btnProfile.setEnabled(false);
                break;
            case User.CUSTOMER:
                lblUsername.setText(((Customer) user).getFullName());
                btnAdmins.setEnabled(false);
                btnAirliner.setEnabled(false);
                btnCustomers.setEnabled(false);
                btnAircrafts.setEnabled(false);
                btnBookFlight.setEnabled(true);
                btnFlights.setEnabled(true);
                break;
            default:
                break;

        }

    }

    public void setUsername(User u) {
        switch (user.getUserType()) {
            case User.ADMINISTRATOR:
                lblUsername.setText(user.getUsername());
                break;
            case User.AIRLINER:
                lblUsername.setText(((Airliner) user).getProviderName());
                break;
            case User.CUSTOMER:
                lblUsername.setText(((Customer) user).getFullName());
                break;
            default:
                break;
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        btnAdmins = new javax.swing.JButton();
        btnAirliner = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnBookFlight = new javax.swing.JButton();
        btnAircrafts = new javax.swing.JButton();
        btnFlights = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnUsernamePassword = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jSplitPane1.setBorder(null);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("*Username*");

        btnAdmins.setText("Show All Flights");
        btnAdmins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminsActionPerformed(evt);
            }
        });

        btnAirliner.setText("Manage Airliners");

        btnCustomers.setText("Manage Customers");

        btnBookFlight.setText("Search & Book A Flight");
        btnBookFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookFlightActionPerformed(evt);
            }
        });

        btnAircrafts.setText("Manage Aircrafts");
        btnAircrafts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlightsActionPerformed(evt);
            }
        });

        btnFlights.setText("Manage My Flights");
        btnFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlightsActionPerformed1(evt);
            }
        });

        btnProfile.setText("My Profile");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnUsernamePassword.setText("Username & Password");
        btnUsernamePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsernamePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAircrafts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdmins, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAirliner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCustomers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBookFlight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsernamePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(btnFlights, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdmins, btnBookFlight, btnFlights, btnProfile, btnUsernamePassword});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdmins)
                    .addComponent(btnProfile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAirliner)
                    .addComponent(btnUsernamePassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCustomers)
                    .addComponent(btnBookFlight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAircrafts)
                    .addComponent(btnFlights))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        bottomPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Click Buttons above to Continue");
        bottomPanel.add(jLabel2, "card2");

        jSplitPane1.setRightComponent(bottomPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookFlightActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.bottomPanel.getLayout();
        SearchFlightPanel panel = new SearchFlightPanel(this.bottomPanel);
        this.bottomPanel.add(panel);
        layout.next(this.bottomPanel);
    }//GEN-LAST:event_btnBookFlightActionPerformed

    private void btnFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightsActionPerformed
        Airliner airliner = (Airliner) user;
        AirlinerManagePanel airlinerManagePanel = new AirlinerManagePanel(bottomPanel, Business.getInstance().getAircraftList(), Business.getInstance().getFlightDirectory(), airliner);
        this.bottomPanel.add("AirlinerManagePanel", airlinerManagePanel);
        CardLayout cardLayout = (CardLayout) this.bottomPanel.getLayout();
        cardLayout.next(bottomPanel);
    }//GEN-LAST:event_btnFlightsActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        bottomPanel.add("MyProfilePanel", new MyProfilePanel(this, this.bottomPanel, user));
        layout.next(bottomPanel);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnUsernamePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsernamePasswordActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        bottomPanel.add("MyUsernamePswdPanel", new MyUsernamePswdPanel(bottomPanel, Business.getInstance().getMainFrame().getLoggedUser()));
        layout.next(this.bottomPanel);
    }//GEN-LAST:event_btnUsernamePasswordActionPerformed

    private void btnFlightsActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightsActionPerformed1
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        bottomPanel.add("EditFlightsPanel", new FlightsPanel(bottomPanel, Business.getInstance().getMainFrame().getLoggedUser()));
        layout.next(this.bottomPanel);
    }//GEN-LAST:event_btnFlightsActionPerformed1

    private void btnAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminsActionPerformed
        // Show all flights
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        bottomPanel.add("AdminShowAllFlightsPanel",new AdminShowAllFlightsPanel(bottomPanel));
        layout.next(this.bottomPanel);
    }//GEN-LAST:event_btnAdminsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton btnAdmins;
    private javax.swing.JButton btnAircrafts;
    private javax.swing.JButton btnAirliner;
    private javax.swing.JButton btnBookFlight;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnFlights;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnUsernamePassword;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
