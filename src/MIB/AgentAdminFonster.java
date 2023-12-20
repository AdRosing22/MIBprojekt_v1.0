/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import oru.inf.InfDB;

/**
 *
 * @author Adam & Melker
 */
public class AgentAdminFonster extends javax.swing.JFrame {

    private InfDB idb;
    
    
    /**
     * Creates new form AgentAdminFonster
     */
    public AgentAdminFonster(InfDB idb) {
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

        jLvalkommen = new javax.swing.JLabel();
        btnAvsluta = new javax.swing.JToggleButton();
        jHanteraAlien = new javax.swing.JButton();
        jHanteraAgenter = new javax.swing.JButton();
        jAndraLosenord = new javax.swing.JButton();
        jHanteraUtrustning = new javax.swing.JButton();
        jHanteraChefer = new javax.swing.JButton();
        jRegistreraUtrustning = new javax.swing.JButton();
        jSokAlien = new javax.swing.JButton();
        jSokAgent = new javax.swing.JButton();
        jAtgarder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLvalkommen.setText("Välkommen Agent med administratörs rättigheter!");

        btnAvsluta.setText("Avsluta program");
        btnAvsluta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvslutaActionPerformed(evt);
            }
        });

        jHanteraAlien.setText("Hantera alien");
        jHanteraAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHanteraAlienActionPerformed(evt);
            }
        });

        jHanteraAgenter.setText("Hantera agenter");
        jHanteraAgenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHanteraAgenterActionPerformed(evt);
            }
        });

        jAndraLosenord.setText("Ändra lösenord");
        jAndraLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAndraLosenordActionPerformed(evt);
            }
        });

        jHanteraUtrustning.setText("Hantera utrustning");
        jHanteraUtrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHanteraUtrustningActionPerformed(evt);
            }
        });

        jHanteraChefer.setText("Hantera chefer");
        jHanteraChefer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHanteraCheferActionPerformed(evt);
            }
        });

        jRegistreraUtrustning.setText("Registrera utrustning");
        jRegistreraUtrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistreraUtrustningActionPerformed(evt);
            }
        });

        jSokAlien.setText("Sök Alien");
        jSokAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSokAlienActionPerformed(evt);
            }
        });

        jSokAgent.setText("Sök agent");
        jSokAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSokAgentActionPerformed(evt);
            }
        });

        jAtgarder.setText("Åtgärder:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAvsluta)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jAtgarder)
                        .addGap(180, 180, 180))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLvalkommen, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSokAlien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRegistreraUtrustning, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jAndraLosenord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSokAgent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jHanteraUtrustning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jHanteraAgenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jHanteraAlien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jHanteraChefer, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLvalkommen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jAtgarder)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jAndraLosenord))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jHanteraChefer)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jHanteraAlien)
                            .addComponent(jRegistreraUtrustning))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jHanteraAgenter)
                            .addComponent(jSokAgent))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jHanteraUtrustning)
                            .addComponent(jSokAlien))))
                .addGap(59, 59, 59)
                .addComponent(btnAvsluta)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvslutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvslutaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnAvslutaActionPerformed

    private void jHanteraAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHanteraAlienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHanteraAlienActionPerformed

    private void jHanteraAgenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHanteraAgenterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHanteraAgenterActionPerformed

    private void jAndraLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAndraLosenordActionPerformed
        // TODO add your handling code here:
        new AndraLosenordFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_jAndraLosenordActionPerformed

    private void jHanteraUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHanteraUtrustningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHanteraUtrustningActionPerformed

    private void jHanteraCheferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHanteraCheferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jHanteraCheferActionPerformed

    private void jRegistreraUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistreraUtrustningActionPerformed
        // TODO add your handling code here:
        new RegNyUtrustning(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_jRegistreraUtrustningActionPerformed

    private void jSokAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSokAlienActionPerformed
        // TODO add your handling code here:
        new ValjTypSokAvAlien(idb).setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jSokAlienActionPerformed

    private void jSokAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSokAgentActionPerformed
        // TODO add your handling code here:
        new SokEnskildAgent(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_jSokAgentActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAvsluta;
    private javax.swing.JButton jAndraLosenord;
    private javax.swing.JLabel jAtgarder;
    private javax.swing.JButton jHanteraAgenter;
    private javax.swing.JButton jHanteraAlien;
    private javax.swing.JButton jHanteraChefer;
    private javax.swing.JButton jHanteraUtrustning;
    private javax.swing.JLabel jLvalkommen;
    private javax.swing.JButton jRegistreraUtrustning;
    private javax.swing.JButton jSokAgent;
    private javax.swing.JButton jSokAlien;
    // End of variables declaration//GEN-END:variables
}
