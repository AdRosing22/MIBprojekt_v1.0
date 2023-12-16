/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import oru.inf.InfDB;

/**
 *
 * @author Adam
 */
public class HanteraAliensFonster extends javax.swing.JFrame {
    
    private InfDB idb;
    
    

    /**
     * Creates new form HanteraAliensFonster
     */
    public HanteraAliensFonster(InfDB idb) {
        initComponents();
        this.idb = idb;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTtitel = new javax.swing.JLabel();
        btnRegNyAlien = new javax.swing.JToggleButton();
        btnRedigeraAlien = new javax.swing.JToggleButton();
        btnBacka = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTtitel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jTtitel.setText("Alienåtgärder");

        btnRegNyAlien.setText("Registrera ny alien");
        btnRegNyAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegNyAlienActionPerformed(evt);
            }
        });

        btnRedigeraAlien.setText("Redigera alieninformation");
        btnRedigeraAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraAlienActionPerformed(evt);
            }
        });

        btnBacka.setText("Tillbaka");
        btnBacka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRedigeraAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegNyAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jTtitel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnBacka, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTtitel)
                .addGap(59, 59, 59)
                .addComponent(btnRegNyAlien)
                .addGap(43, 43, 43)
                .addComponent(btnRedigeraAlien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btnBacka)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRedigeraAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraAlienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRedigeraAlienActionPerformed

    private void btnBackaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackaActionPerformed
        // TODO add your handling code here:
        new AgentFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackaActionPerformed

    private void btnRegNyAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegNyAlienActionPerformed
        // TODO add your handling code here:
        new RegistreraAlienFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegNyAlienActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBacka;
    private javax.swing.JToggleButton btnRedigeraAlien;
    private javax.swing.JToggleButton btnRegNyAlien;
    private javax.swing.JLabel jTtitel;
    // End of variables declaration//GEN-END:variables
}
