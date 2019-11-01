/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.interfaces;

import com.travel.business.Business;
import com.travel.business.Flight;
import com.travel.business.Traveler;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lihang
 */
public class AddViewEditPersonOnBoardPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddViewEditPersonOnBoardPanel
     */
    public final static int ADD_MODE = 0;
    public final static int VIEW_EDIT_MODE = 1;

    private final Flight flight;
    private final JPanel bottomPanel;
    private Traveler traveler;
    private String prevSeat;
    private final int mode;

    public AddViewEditPersonOnBoardPanel(JPanel b, Flight f) {
        initComponents();
        flight = f;
        bottomPanel = b;
        btnSeatChooser.setSeatTable(f.getIntSeatTable());
        mode = ADD_MODE;
        this.btnUnenroll.setVisible(false);
        this.btnUnenroll.setEnabled(false);
    }

    public AddViewEditPersonOnBoardPanel(JPanel b, Traveler t) {
        initComponents();
        flight = t.getFlight();
        traveler = t;
        bottomPanel = b;
        prevSeat = flight.getTravelerSeat(traveler);
        flight.releaseSeat(prevSeat);
        btnSeatChooser.setSeat(prevSeat);
        btnSeatChooser.setSeatTable(flight.getIntSeatTable());
        mode = VIEW_EDIT_MODE;
        fillTxtFields();
        flight.pickSeat(prevSeat, traveler);
    }

    private void backToMainMenu() {
        CardLayout layout = (CardLayout) this.bottomPanel.getLayout();
        for (int i = bottomPanel.getComponentCount() - 1; i > 0; i--) {
            bottomPanel.remove(i);
        }
        layout.first(bottomPanel);
    }

    private void fillTxtFields() {
        this.txtFirstName.setText(traveler.getFirstName());
        this.txtLastName.setText(traveler.getLastName());
        this.txtID.setText(traveler.getID());
        this.btnUnenroll.setVisible(true);
        this.btnUnenroll.setEnabled(true);
    }
    
    private void goBack(){
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        this.bottomPanel.remove(this);
        for (Component comp : bottomPanel.getComponents()) {
            if (comp instanceof FlightsPanel) {
                if (((FlightsPanel) comp).getMode() == FlightsPanel.VIEW_EDIT_MODE) {
                    ((FlightsPanel) comp).loadUserFlights();
                }
            }
        }
        layout.previous(this.bottomPanel);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSeatChooser = new com.travel.util.SeatChooserJButton();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnUnenroll = new javax.swing.JButton();

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Edit Traveler");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Seat");

        jLabel5.setText("Passport No.");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnUnenroll.setText("Unenroll");
        btnUnenroll.setEnabled(false);
        btnUnenroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnenrollActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLastName)
                                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSeatChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUnenroll)))))
                        .addGap(6, 6, 6))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSubmit, btnUnenroll});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(jLabel1)
                    .addComponent(btnSubmit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnSeatChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUnenroll))
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String fName = txtFirstName.getText().trim(),
                lName = this.txtLastName.getText().trim(),
                id = this.txtID.getText().trim(),
                seat = this.btnSeatChooser.getSeat();

        //validate
        //add
        if (JOptionPane.showConfirmDialog(this, "Are you sure to \nenroll?",
                "Confirm",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (mode == VIEW_EDIT_MODE) {
                flight.releaseSeat(prevSeat);
            }
            Traveler t = new Traveler(fName, lName, id,
                    Business.getInstance().getMainFrame().getLoggedUser(),
                    flight);
            flight.pickSeat(seat, t);
            JOptionPane.showMessageDialog(this, "Ordered successfully.",
                    "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            backToMainMenu();
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnUnenrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnenrollActionPerformed
        // TODO add your handling code here:
        if (mode == VIEW_EDIT_MODE) {
            if(JOptionPane.showConfirmDialog(this, "Are you sure to \nunenroll?",
                "Confirm",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                flight.releaseSeat(prevSeat);
                JOptionPane.showMessageDialog(this, "Unenrolled successfully.",
                    "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                goBack();
            }
        }
    }//GEN-LAST:event_btnUnenrollActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private com.travel.util.SeatChooserJButton btnSeatChooser;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUnenroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}
