/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.interfaces;

import com.travel.business.Business;
import com.travel.business.Flight;
import com.travel.business.Traveler;
import com.travel.users.Airliner;
import com.travel.users.User;
import com.travel.util.Validator;
import java.awt.CardLayout;
import java.awt.Panel;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lihang
 */
public class FlightsPanel extends javax.swing.JPanel {

    /**
     * Creates new form FlightsPanel
     */
    public final static int SEARCH_MODE = 0;
    public final static int VIEW_EDIT_MODE = 1;

    private final JPanel bottomPanel;
    private final Business business;
    private String to;
    private String from;
    private Date depart;
    private int mode;
    private User user;
    private String airliner;
    private Double price;

    public FlightsPanel(JPanel b, String from, String to, Date depart) {
        initComponents();
        this.mode = SEARCH_MODE;
        bottomPanel = b;
        business = Business.getInstance();
        this.to = to;
        this.depart = depart;
        this.from = from;
        loadFlights();
    }

    public FlightsPanel(JPanel b, String from, String to, Date depart, String airliner) {
        initComponents();
        bottomPanel = b;
        business = Business.getInstance();
        this.to = to;
        this.depart = depart;
        this.from = from;
        this.airliner = airliner;
        loadFlightsA();
    }

    public FlightsPanel(JPanel b, String from, String to, Date depart, Double price) {
        initComponents();
        bottomPanel = b;
        business = Business.getInstance();
        this.to = to;
        this.depart = depart;
        this.from = from;
        this.price = price;
        loadFlightsB();
    }

    public FlightsPanel(JPanel b, String from, String to, Date depart, String airliner, Double price) {
        initComponents();
        bottomPanel = b;
        business = Business.getInstance();
        this.to = to;
        this.depart = depart;
        this.from = from;
        this.price = price;
        this.airliner = airliner;
        loadFlightsC();
    }

    public int getMode() {
        return this.mode;
    }

    public FlightsPanel(JPanel b, User u) {
        initComponents();
        business = Business.getInstance();
        this.bottomPanel = b;
        this.user = u;
        this.mode = VIEW_EDIT_MODE;
        loadUserFlights();
    }

    public void loadUserFlights() {
        DefaultTableModel dtm = (DefaultTableModel) tblFlights.getModel();
        dtm.setColumnIdentifiers(new String[]{
            "Traveler Name", "Flight #", "From", "To", "Date & Time"
        });
        dtm.setRowCount(0);

        for (Flight ff : business.getFlightDirectory().getFlightDir()) {
            for (Traveler t : ff.getTravelers(user)) {
                Flight f = t.getFlight();
                Object[] row = new Object[5];
                row[0] = t;
                row[1] = f;
                row[2] = f.getDeparture();
                row[3] = f.getArrival();
                row[4] = f.getTakeOffTime();
                dtm.addRow(row);
            }
        }
    }

    public void loadFlights() {
        DefaultTableModel dtm = (DefaultTableModel) tblFlights.getModel();
        dtm.setRowCount(0);

        for (Flight f : business.getFlightDirectory().getFlightDir()) {
            if (f.getArrival().equals(to) && f.getDeparture().equals(from) && Validator.IsSameDay(f.getTakeOffTime(), depart)) {
                Object[] row = new Object[5];
                row[0] = f.getAirliner();
                row[1] = f;
                row[2] = f.getDeparture();
                row[3] = f.getArrival();
                row[4] = f.getTakeOffTime();
                dtm.addRow(row);
            }
        }

        if (dtm.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No result");
        }

    }

    public void loadFlightsA() {
        DefaultTableModel dtm = (DefaultTableModel) tblFlights.getModel();
        dtm.setRowCount(0);

        for (Flight f : business.getFlightDirectory().getFlightDir()) {
            if (f.getArrival().equals(to) && f.getDeparture().equals(from) && Validator.IsSameDay(f.getTakeOffTime(), depart) && f.getAirliner().equals(airliner)) {
                Object[] row = new Object[5];
                row[0] = f.getAirliner();
                row[1] = f;
                row[2] = f.getDeparture();
                row[3] = f.getArrival();
                row[4] = f.getTakeOffTime();
                dtm.addRow(row);
            }

        }
        if (dtm.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No result");
        }
    }

    public void loadFlightsB() {
        DefaultTableModel dtm = (DefaultTableModel) tblFlights.getModel();
        dtm.setRowCount(0);

        for (Flight f : business.getFlightDirectory().getFlightDir()) {
            if (f.getArrival().equals(to) && f.getDeparture().equals(from) && Validator.IsSameDay(f.getTakeOffTime(), depart) && f.getTicketPrice() <= price) {
                Object[] row = new Object[5];
                row[0] = f.getAirliner();
                row[1] = f;
                row[2] = f.getDeparture();
                row[3] = f.getArrival();
                row[4] = f.getTakeOffTime();
                dtm.addRow(row);
            }

        }
        if (dtm.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No result");
        }
    }

    public void loadFlightsC() {
        DefaultTableModel dtm = (DefaultTableModel) tblFlights.getModel();
        dtm.setRowCount(0);

        for (Flight f : business.getFlightDirectory().getFlightDir()) {
            if (f.getArrival().equals(to) && f.getDeparture().equals(from) && Validator.IsSameDay(f.getTakeOffTime(), depart) && f.getTicketPrice() <= price && f.getAirliner().equals(airliner)) {
                Object[] row = new Object[5];
                row[0] = f.getAirliner();
                row[1] = f;
                row[2] = f.getDeparture();
                row[3] = f.getArrival();
                row[4] = f.getTakeOffTime();
                dtm.addRow(row);
            }

        }
        if (dtm.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No result");
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

        btnGoBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlights = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnContinue = new javax.swing.JButton();

        btnGoBack.setText("←");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        tblFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airliner", "Flight #", "From", "To", "Date & Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFlights);

        jLabel1.setText("Choose your flight");

        btnContinue.setText("Continue >>");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnContinue))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(jLabel1)
                    .addComponent(btnContinue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        this.bottomPanel.remove(this);
        layout.previous(this.bottomPanel);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        // TODO add your handling code here:
        int selected = tblFlights.getSelectedRow();
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        if (mode == SEARCH_MODE) {
            if (selected > -1) {
                Flight f = (Flight) tblFlights.getValueAt(selected, 1);
                AddViewEditPersonOnBoardPanel panel = new AddViewEditPersonOnBoardPanel(bottomPanel, f);
                bottomPanel.add("SelectSeatPanel", panel);
                layout.next(bottomPanel);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a flight!", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } else if (mode == VIEW_EDIT_MODE) {
            if (selected < 0) {
                JOptionPane.showMessageDialog(this, "Please select a flight!", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {
                Traveler tra = (Traveler) tblFlights.getValueAt(selected, 0);
                AddViewEditPersonOnBoardPanel panel = new AddViewEditPersonOnBoardPanel(bottomPanel, tra);
                bottomPanel.add("EditSeatPanel", panel);
                layout.next(bottomPanel);
            }
        }
    }//GEN-LAST:event_btnContinueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFlights;
    // End of variables declaration//GEN-END:variables

}
