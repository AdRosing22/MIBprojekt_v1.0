/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author adamrosing & Melker
 */
public class RegistreraAlienFonster extends javax.swing.JFrame {
    
    private InfDB idb;

    /**
     * Creates new form RegistreraAlienFonster
     */
    public RegistreraAlienFonster(InfDB idb) {
        initComponents();
        this.idb = idb;
    }
    
   /* private void registreraNyAlien() {
        String epost = epostField.getText();
        String losenord = losenordField.getText();
        String plats = platsCbx.getSelectedItem().toString();
        String telefon = telefonField.getText();
        String ansvarigAgent = ansvarigAgentCbx.getSelectedItem().toString();
        String registreringsdatum = registreringsdatumField.getText();
        
        String fraga = "INSERT INTO alien (Epost, Losenord, Plats, Telefon, Ansvarig_Agent, Registreringsdatum) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            ArrayList<String> values = new ArrayList<>();
            values.add(epost);
            values.add(losenord);
            values.add(plats);
            values.add(telefon);
            values.add(ansvarigAgent);
            values.add(registreringsdatum);
            //idb.insert(fraga, values);
            
            //jOptionPane()
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

        registreraNyAlienText = new javax.swing.JLabel();
        epostText = new javax.swing.JLabel();
        losenordText = new javax.swing.JLabel();
        platsText = new javax.swing.JLabel();
        telefonText = new javax.swing.JLabel();
        ansvarigAgentText = new javax.swing.JLabel();
        registreringsdatumText = new javax.swing.JLabel();
        losenordField = new javax.swing.JTextField();
        epostField = new javax.swing.JTextField();
        telefonField = new javax.swing.JTextField();
        registreringsdatumField = new javax.swing.JTextField();
        registreraKnapp = new javax.swing.JToggleButton();
        platsCbx = new javax.swing.JComboBox<>();
        ansvarigAgentCbx = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registreraNyAlienText.setText("Registrera ny alien");

        epostText.setText("E-post:");

        losenordText.setText("Lösenord:");

        platsText.setText("Plats:");

        telefonText.setText("Telefon:");

        ansvarigAgentText.setText("Ansvarig agent:");

        registreringsdatumText.setText("Registreringsdatum:");

        losenordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                losenordFieldActionPerformed(evt);
            }
        });

        epostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epostFieldActionPerformed(evt);
            }
        });

        telefonField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonFieldActionPerformed(evt);
            }
        });

        registreringsdatumField.setText("ÅÅÅÅ-MM-DD");
        registreringsdatumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registreringsdatumFieldActionPerformed(evt);
            }
        });

        registreraKnapp.setText("Registrera");
        registreraKnapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registreraKnappActionPerformed(evt);
            }
        });

        platsCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ansvarigAgentCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(losenordText)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(losenordField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(registreringsdatumText)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                    .addComponent(registreringsdatumField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(epostText)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(epostField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefonText)
                                    .addComponent(platsText)
                                    .addComponent(ansvarigAgentText))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ansvarigAgentCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(platsCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(registreraNyAlienText, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(registreraKnapp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(registreraNyAlienText)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(epostText)
                    .addComponent(epostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(losenordText)
                    .addComponent(losenordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(platsText)
                    .addComponent(platsCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonText)
                    .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ansvarigAgentText)
                    .addComponent(ansvarigAgentCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registreringsdatumText)
                    .addComponent(registreringsdatumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(registreraKnapp)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void losenordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_losenordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_losenordFieldActionPerformed

    private void epostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_epostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_epostFieldActionPerformed

    private void telefonFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonFieldActionPerformed

    private void registreringsdatumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registreringsdatumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registreringsdatumFieldActionPerformed

    private void registreraKnappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registreraKnappActionPerformed
        
    }//GEN-LAST:event_registreraKnappActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ansvarigAgentCbx;
    private javax.swing.JLabel ansvarigAgentText;
    private javax.swing.JTextField epostField;
    private javax.swing.JLabel epostText;
    private javax.swing.JTextField losenordField;
    private javax.swing.JLabel losenordText;
    private javax.swing.JComboBox<String> platsCbx;
    private javax.swing.JLabel platsText;
    private javax.swing.JToggleButton registreraKnapp;
    private javax.swing.JLabel registreraNyAlienText;
    private javax.swing.JTextField registreringsdatumField;
    private javax.swing.JLabel registreringsdatumText;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonText;
    // End of variables declaration//GEN-END:variables
}
