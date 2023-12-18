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
public class AlienFonster extends javax.swing.JFrame {

    
    private InfDB idb;
    
    
    /**
     * Creates new form AlienFonster
     */
    public AlienFonster(InfDB idb) {
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
        btnAndraLosenord = new javax.swing.JToggleButton();
        btnAvsluta = new javax.swing.JToggleButton();
        btnOmradesChef = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLvalkommen.setText("Välkommen Alien");

        btnAndraLosenord.setText("Ändra lösenord");
        btnAndraLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraLosenordActionPerformed(evt);
            }
        });

        btnAvsluta.setText("Avsluta program");
        btnAvsluta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvslutaActionPerformed(evt);
            }
        });

        btnOmradesChef.setText("Områdechef information");
        btnOmradesChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOmradesChefActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAvsluta, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLvalkommen, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnAndraLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOmradesChef)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLvalkommen)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAndraLosenord)
                    .addComponent(btnOmradesChef))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(btnAvsluta)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndraLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraLosenordActionPerformed
        // TODO add your handling code here:
        new AndraLosenordFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAndraLosenordActionPerformed

    private void btnAvslutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvslutaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnAvslutaActionPerformed

    private void btnOmradesChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmradesChefActionPerformed
        // TODO add your handling code here:
        new OmradesChefInfo(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOmradesChefActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAndraLosenord;
    private javax.swing.JToggleButton btnAvsluta;
    private javax.swing.JToggleButton btnOmradesChef;
    private javax.swing.JLabel jLvalkommen;
    // End of variables declaration//GEN-END:variables
}
