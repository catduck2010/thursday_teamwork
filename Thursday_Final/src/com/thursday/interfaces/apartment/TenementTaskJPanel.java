/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thursday.interfaces.apartment;

import com.thursday.business.CompanyDirectory;
import com.thursday.business.UserDirectory;
import com.thursday.business.identities.User;
import com.thursday.business.WorkFlow;
import com.thursday.business.workflow.Task;
import com.thursday.util.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CHEN JIEYING
 */
public class TenementTaskJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TenementRequestJPanel
     */
    private final User user;
    private JPanel rightPanel;

    public TenementTaskJPanel(JPanel rightPanel, User u) {
        initComponents();
        this.user = u;
        this.rightPanel = rightPanel;

    }
    
    private void clearAllFields() {
        this.aptTxt.setText("");
        this.remarkTxt.setText("");
    }
    
private void createTask(){
    String aptNo = aptTxt.getText().trim();
    String taskType = (String)taskComboBox1.getSelectedItem();
    String title = "Apt"+ aptNo + " " + taskType;
    String message = remarkTxt.getText().trim();
    String creator = user.getUsername();
    
      if (Validator.IsEmpty(aptNo)) {
            //CompNameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Apartment No. can't be empty");
            return;      
        }else if(!IsUserName(aptNo)){
            JOptionPane.showMessageDialog(null, "Please enter valid apartment No. ");
            return;
        }else if (Validator.IsEmpty(message)) {
            //adminNameTxt.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Remark message can't be empty");
            return;
        }else{
             Task t =WorkFlow.createTask(creator, title, message);
            JOptionPane.showMessageDialog(null, "Request is created successfully");
            clearAllFields();
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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        aptTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        taskComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        remarkTxt = new javax.swing.JTextField();
        comfirmBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        btnGoBack.setText("←");
        btnGoBack.setEnabled(false);
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Make A Request");

        jLabel1.setText("APT NO.");

        aptTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aptTxtActionPerformed(evt);
            }
        });

        jLabel4.setText("Task Type:");

        taskComboBox1.setFont(taskComboBox1.getFont());
        taskComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Repair", "Cleaning", "" }));

        jLabel5.setText("Remark");

        comfirmBtn.setText("Confirm");
        comfirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comfirmBtnActionPerformed(evt);
            }
        });

        jLabel3.setText(" Apt");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(comfirmBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(taskComboBox1, 0, 183, Short.MAX_VALUE)
                            .addComponent(remarkTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aptTxt)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aptTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remarkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comfirmBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(252, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comfirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comfirmBtnActionPerformed
        // TODO add your handling code here:
        createTask();
    }//GEN-LAST:event_comfirmBtnActionPerformed

    private void aptTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aptTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aptTxtActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackActionPerformed

    

    
    public static boolean IsUserName(String str) {
        String regex = "^[a-zA-Z0-9]+$";
        return Match(regex, str);
    }
    
    private static boolean Match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aptTxt;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton comfirmBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField remarkTxt;
    private javax.swing.JComboBox<String> taskComboBox1;
    // End of variables declaration//GEN-END:variables
}

