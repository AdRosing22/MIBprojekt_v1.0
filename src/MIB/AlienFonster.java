/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import oru.inf.InfDB;

/**
 *Klass som enbart innehåller knappar för att öppna nya klasser
 * @author Adam
 */
public class AlienFonster extends javax.swing.JFrame {

    
    private InfDB idb;
    private InlogAlien nyAlien;
    
    
   
    /**
     * Creates new form AlienFonster
     */
    
    
    public AlienFonster(InfDB idb)
    {
        initComponents();
        this.idb = idb;
        setValkommen(InlogAlien.getNamn());
    }
    
    public AlienFonster(InfDB idb, InlogAlien nyAlien)
    {
        initComponents();
        this.idb=idb;
        this.nyAlien=nyAlien;
        setValkommen(nyAlien.getNamn());
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
        jLatgarder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLvalkommen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLvalkommen.setText("Välkommen Alien");

        btnAndraLosenord.setText("Ändra lösenord");
        btnAndraLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraLosenordActionPerformed(evt);
            }
        });

        btnAvsluta.setText("Logga ut");
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

        jLatgarder.setText("Åtgärder:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOmradesChef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAndraLosenord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLatgarder, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAvsluta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLvalkommen, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLvalkommen)
                .addGap(27, 27, 27)
                .addComponent(jLatgarder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOmradesChef)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAndraLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnAvsluta)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndraLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraLosenordActionPerformed
        // TODO add your handling code here:
        new AndraLosenordFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAndraLosenordActionPerformed

    private void btnAvslutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvslutaActionPerformed
        // TODO add your handling code here:
        
        //tömmer InlogAlien state för att kunna fylla med nya värden från ny inloggning
        nyAlien.loggaUt();
        new InloggningsFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAvslutaActionPerformed

    private void btnOmradesChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOmradesChefActionPerformed
        // TODO add your handling code here:
        new OmradesChefInfo(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOmradesChefActionPerformed


    //metod för att sätta välkommen text
    private void setValkommen(String namn)
    {
        if(namn != null){
            jLvalkommen.setText("Välkommen Alien "+InlogAlien.getNamn());
        }
        else{
            jLvalkommen.setText("Välkommen Alien");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAndraLosenord;
    private javax.swing.JToggleButton btnAvsluta;
    private javax.swing.JToggleButton btnOmradesChef;
    private javax.swing.JLabel jLatgarder;
    private javax.swing.JLabel jLvalkommen;
    // End of variables declaration//GEN-END:variables
}
