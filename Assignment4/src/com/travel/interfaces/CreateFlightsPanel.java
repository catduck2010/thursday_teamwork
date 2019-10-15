/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.interfaces;

import com.travel.business.Flight;
import com.travel.business.FlightDirectory;
import com.travel.users.Airliner;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
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
public class CreateFlightsPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateFlightsPanel
     */
    private FlightDirectory flightDirectory;
    private JPanel bottomPanel;
    private String modelNum;
    private Airliner airliner;
    public CreateFlightsPanel(JPanel bottomPanel, FlightDirectory flightDirectory, String modelNum, Airliner airliner) {
        initComponents();
        this.flightDirectory = flightDirectory;
        this.bottomPanel = bottomPanel;
        this.modelNum = modelNum;
        this.airliner = airliner;
        titleLabel.setText(modelNum);
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
        Pattern pattern = Pattern.compile("^[A-Z0-9]+$");
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

        jSpinner1 = new javax.swing.JSpinner();
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
        btnCreate = new javax.swing.JButton();
        flightNumLabel = new javax.swing.JLabel();
        txtFlightNum = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel1.setText("Create a new Flight for");

        depLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        depLabel.setText("Departure:");

        txtDeparture.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        arrivalLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        arrivalLabel.setText("Arrival:");

        txtArrival.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
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

        txtTakeOffTime.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtTakeOffTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTakeOffTimeActionPerformed(evt);
            }
        });

        txtLandTime.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        btnCreate.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        flightNumLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        flightNumLabel.setText("Flight Number:");

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        btnBack.setText("←");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(depLabel)
                            .addComponent(arrivalLabel)
                            .addComponent(takeOffLabel)
                            .addComponent(landLabel)
                            .addComponent(priceLabel)
                            .addComponent(flightNumLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCreate)
                            .addComponent(txtDeparture)
                            .addComponent(txtArrival)
                            .addComponent(txtPrice)
                            .addComponent(txtTakeOffTime)
                            .addComponent(txtLandTime)
                            .addComponent(txtFlightNum, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightNumLabel)
                    .addComponent(txtFlightNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depLabel)
                    .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arrivalLabel)
                    .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(takeOffLabel)
                    .addComponent(txtTakeOffTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(landLabel)
                    .addComponent(txtLandTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtArrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArrivalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArrivalActionPerformed

    private void txtTakeOffTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTakeOffTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTakeOffTimeActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        boolean validation = true;
        
        String flightNum = txtFlightNum.getText();
        
        if("".equals(flightNum)){
                JOptionPane.showMessageDialog(this, "Flight Number cannot be empty!");
                flightNumLabel.setForeground(Color.red);
                validation = false;
                return;
            }
         if(!checkFlightNum(flightNum)){
            JOptionPane.showMessageDialog(this, "Flight Number Must contain Upper Case letter or numbers or both!");
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
            Date takeOfftime = dateFormat.parse(txtTakeOffTime.getText());
            Date currentDate = new Date();
            takeOffLabel.setForeground(Color.black);
            if(flightDirectory.checkLandTime(takeOfftime,modelNum)== false)
            {
                JOptionPane.showMessageDialog(this, "Take Off time is unreasonalbe!");
                takeOffLabel.setForeground(Color.red);
                validation = false;
                return;
            }
            if(takeOfftime.before(currentDate)){
                JOptionPane.showMessageDialog(this, "Take Off time must after current time!");
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
            Date takeOfftime = dateFormat.parse(txtTakeOffTime.getText());
            Date currentDate = new Date();
            Date landtime = dateFormat.parse(txtLandTime.getText());
            landLabel.setForeground(Color.black);
            if(flightDirectory.checkLandTime(landtime,modelNum)== false)
            {
                JOptionPane.showMessageDialog(this, "Land time is unreasonalbe!");
                landLabel.setForeground(Color.red);
                validation = false;
                return;
            }
            if(landtime.before(takeOfftime)){
                JOptionPane.showMessageDialog(this, "Land time must after take off time!");
                takeOffLabel.setForeground(Color.red);
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
             try{ 
                 Date takeOfftime = dateFormat.parse(txtTakeOffTime.getText());
                 Date landtime = dateFormat.parse(txtLandTime.getText());
              Flight flight = flightDirectory.addFlight();
              flight.setArrival(arrival);
              flight.setDeparture(departure);
              flight.setFlightNum(flightNum);
              flight.setLandTime(landtime);
              flight.setModelNum(modelNum);
              flight.setTakeOffTime(takeOfftime);
              flight.setTicketPrice(Double.parseDouble(txtPrice.getText()));
              flight.setAirliner(airliner.getProviderName());

        JOptionPane.showMessageDialog(null, "Add a Flight successfully!");
             }
             catch(ParseException e){
                
                 JOptionPane.showMessageDialog(this, "Please enter correct value for time! The format is yyyy-MM-dd HH:mm");
             return;
             }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrivalLabel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel depLabel;
    private javax.swing.JLabel flightNumLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel landLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel takeOffLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField txtArrival;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtFlightNum;
    private javax.swing.JTextField txtLandTime;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTakeOffTime;
    // End of variables declaration//GEN-END:variables
}
