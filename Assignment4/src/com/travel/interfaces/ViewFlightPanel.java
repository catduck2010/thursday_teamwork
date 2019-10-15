/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.interfaces;

import com.travel.business.Flight;
import com.travel.business.FlightDirectory;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author andy
 */
public class ViewFlightPanel extends javax.swing.JPanel {

    private Flight flight;
    private FlightDirectory flightDirectory;
    private JPanel bottomPanel;
    public ViewFlightPanel(JPanel bottomPanel, FlightDirectory flightDirectory, Flight flight) {
        initComponents();
        this.bottomPanel = bottomPanel;
        this.flightDirectory = flightDirectory;
        this.flight = flight;
        displayFlight(flight);
        setFieldEnabled(false);
        btnConfirm.setEnabled(false);
    }
    private void displayFlight(Flight flight){
        txtArrival.setText(flight.getArrival());
        txtPrice.setText(String.valueOf(flight.getTicketPrice()));
        txtDeparture.setText(flight.getDeparture());
        txtFlightNum.setText(flight.getFlightNum());
        txtTakeOffTime.setText(String.valueOf(flight.getTakeOffTime()));
        txtLandTime.setText(String.valueOf(flight.getLandTime()));
          
     }
      private void setFieldEnabled(boolean b){
       txtArrival.setEnabled(b);
       txtPrice.setEnabled(b);
       txtDeparture.setEnabled(b);
       txtTakeOffTime.setEnabled(b);
       txtFlightNum.setEnabled(b);
       txtLandTime.setEnabled(b);
      
    }
      private boolean checkLetter(String input){
        Pattern pattern = Pattern.compile("^[A-Za-z]+$");
        Matcher m = pattern.matcher(input);
        if(!m.matches()){
            return false;
        }
        return true;
    }
    
    private boolean checkFlightNum(String input){
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Z\\d]$");
        Matcher m = pattern.matcher(input);
        if(!m.matches()){
            return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        depLabel = new javax.swing.JLabel();
        txtDeparture = new javax.swing.JTextField();
        arrivalLabel = new javax.swing.JLabel();
        txtArrival = new javax.swing.JTextField();
        takeOffLabel = new javax.swing.JLabel();
        landLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtTakeOffTime = new javax.swing.JTextField();
        txtLandTime = new javax.swing.JTextField();
        flightNumLabel = new javax.swing.JLabel();
        txtFlightNum = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel1.setText("View Details");

        depLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        depLabel.setText("Departure:");

        txtDeparture.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtDeparture.setEnabled(false);

        arrivalLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        arrivalLabel.setText("Arrival:");

        txtArrival.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtArrival.setEnabled(false);
        txtArrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArrivalActionPerformed(evt);
            }
        });

        takeOffLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        takeOffLabel.setText("Take off Time:");

        landLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        landLabel.setText("Land Time:");

        priceLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        priceLabel.setText("TIcket Price:");

        txtPrice.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtPrice.setEnabled(false);

        txtTakeOffTime.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtTakeOffTime.setEnabled(false);
        txtTakeOffTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTakeOffTimeActionPerformed(evt);
            }
        });

        txtLandTime.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtLandTime.setEnabled(false);

        flightNumLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        flightNumLabel.setText("Flight Number:");

        txtFlightNum.setEnabled(false);

        btnBack.setText("←");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(depLabel)
                            .addComponent(arrivalLabel)
                            .addComponent(takeOffLabel)
                            .addComponent(landLabel)
                            .addComponent(priceLabel)
                            .addComponent(flightNumLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDeparture)
                            .addComponent(txtArrival)
                            .addComponent(txtPrice)
                            .addComponent(txtTakeOffTime)
                            .addComponent(txtLandTime)
                            .addComponent(txtFlightNum, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirm)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightNumLabel)
                    .addComponent(txtFlightNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depLabel)
                    .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arrivalLabel)
                    .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(takeOffLabel)
                    .addComponent(txtTakeOffTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(landLabel)
                    .addComponent(txtLandTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnConfirm))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtArrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArrivalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArrivalActionPerformed

    private void txtTakeOffTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTakeOffTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTakeOffTimeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        this.bottomPanel.remove(this);
        CardLayout cardLayout =(CardLayout)bottomPanel.getLayout();
        Component[] comps = this.bottomPanel.getComponents();
        for(Component comp : comps){
            if(comp instanceof ManageAirCraftPanel){
                ManageAirCraftPanel manageAirCraftPanel = (ManageAirCraftPanel) comp;
                manageAirCraftPanel.populateTable(flightDirectory.getFlightDir());
            }
        }
        cardLayout.previous(bottomPanel);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        boolean validation = true;
        
        String flightNum = txtFlightNum.getText();
        
        if("".equals(flightNum)){
                JOptionPane.showMessageDialog(this, "Flight Number cannot be empty!");
                flightNumLabel.setForeground(Color.red);
                validation = false;
                return;
            }
         if(!checkFlightNum(flightNum)){
            JOptionPane.showMessageDialog(this, "Flight Number Must contain Upper Case letter and numbers!");
                flightNumLabel.setForeground(Color.red);
                validation = false;
                return;
        }
        if(flightDirectory.sameFlightNum(flightNum) == true){
            JOptionPane.showMessageDialog(this, "Flight Number Already existed!");
            flightNumLabel.setForeground(Color.red);
            validation = false;
                return;
        }
             else{
            flightNumLabel.setForeground(Color.black);
            validation = true;
        }
        
        String departure = txtDeparture.getText();
        if("".equals(departure)){
                JOptionPane.showMessageDialog(this, "Departure City cannot be empty!");
                depLabel.setForeground(Color.red);
                validation = false;
                return;
            }
        else if(!checkLetter(departure)){
            JOptionPane.showMessageDialog(this, "Departure City can only be letters!");
                depLabel.setForeground(Color.red);
                validation = false;
                return;
        }
             else{
            depLabel.setForeground(Color.black);
            validation = true;
        }
        
        String arrival = txtArrival.getText();
        if("".equals(arrival)){
                JOptionPane.showMessageDialog(this, "Arrival City cannot be empty!");
                arrivalLabel.setForeground(Color.red);
                validation = false;
                return;
            }
        else if(!checkLetter(arrival)){
            JOptionPane.showMessageDialog(this, "Arrival City can only be letters!");
                arrivalLabel.setForeground(Color.red);
                validation = false;
                return;
        }
             else{
            arrivalLabel.setForeground(Color.black);
            validation = true;
        }
        
        try {
            priceLabel.setForeground(Color.black);           
            Double price = Double.parseDouble(txtPrice.getText());
                
        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(this, "Please enter correct value for the ticket Price");
            priceLabel.setForeground(Color.red);           
            validation = false;
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(txtTakeOffTime.getText());
            Date takeOfftime = Date.valueOf(txtTakeOffTime.getText());
            takeOffLabel.setForeground(Color.black);
            if(flightDirectory.checkLandTime(takeOfftime,flight.getModelNum())== false)
            {
                JOptionPane.showMessageDialog(this, "Take Off time is unreasonalbe!");
                takeOffLabel.setForeground(Color.red);
                validation = false;
                return;
            }
              
        } catch (ParseException e) {
            
            JOptionPane.showMessageDialog(this, "Please enter correct value for take off time! The format is yyyy-MM-dd HH:mm");
            takeOffLabel.setForeground(Color.red);
            validation = false;
            return;
        }
        
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(txtLandTime.getText());
            Date landtime = Date.valueOf(txtLandTime.getText());
            landLabel.setForeground(Color.black);
            if(flightDirectory.checkLandTime(landtime,flight.getModelNum())== false)
            {
                JOptionPane.showMessageDialog(this, "Land time is unreasonalbe!");
                landLabel.setForeground(Color.red);
                validation = false;
                return;
            }
              
        } catch (ParseException e) {
            
            JOptionPane.showMessageDialog(this, "Please enter correct value for Land time! The format is yyyy-MM-dd HH:mm");
            landLabel.setForeground(Color.red);
            validation = false;
            return;
        }
        
        if(validation == true) {            
              flight.setArrival(arrival);
              flight.setDeparture(departure);
              flight.setFlightNum(flightNum);
              flight.setLandTime(Date.valueOf(txtLandTime.getText()));
              flight.setTakeOffTime(Date.valueOf(txtTakeOffTime.getText()));
              flight.setTicketPrice(Double.parseDouble(txtPrice.getText()));
              

        JOptionPane.showMessageDialog(null, "Flight information updated successfully!");
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
           setFieldEnabled(true);
           btnConfirm.setEnabled(true);
           btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrivalLabel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel depLabel;
    private javax.swing.JLabel flightNumLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel landLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel takeOffLabel;
    private javax.swing.JTextField txtArrival;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtFlightNum;
    private javax.swing.JTextField txtLandTime;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTakeOffTime;
    // End of variables declaration//GEN-END:variables
}
