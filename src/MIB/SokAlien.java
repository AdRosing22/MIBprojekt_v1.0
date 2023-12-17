package MIB;


import java.beans.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author gustafneander & Melker
 */

public class SokAlien extends javax.swing.JFrame {
private static InfDB idb;
    /**
     * Creates new form MainFrame
     */
    public SokAlien(InfDB idb) {
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

        cbxPlatser = new javax.swing.JComboBox<>();
        btnHamtaPlats = new javax.swing.JButton();
        btnHämtaAliens = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAliens = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxPlatser.setEnabled(false);
        cbxPlatser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPlatserActionPerformed(evt);
            }
        });

        btnHamtaPlats.setText("Hämta platser");
        btnHamtaPlats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtaPlatsActionPerformed(evt);
            }
        });

        btnHämtaAliens.setText("Hämta Aliens på vald plats");
        btnHämtaAliens.setEnabled(false);
        btnHämtaAliens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHämtaAliensActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAliens.setColumns(20);
        txtAliens.setRows(5);
        jScrollPane1.setViewportView(txtAliens);

        jToggleButton1.setText("Gå tillbaka");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnHamtaPlats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxPlatser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHämtaAliens, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnHamtaPlats)
                .addGap(29, 29, 29)
                .addComponent(cbxPlatser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnHämtaAliens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxPlatserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPlatserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPlatserActionPerformed
  
    private void btnHamtaPlatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaPlatsActionPerformed
 
    try {
        //Sql frågan som hämtar alla platser.
        String SQLQuery = "SELECT Plats_ID, Benamning FROM Plats;";
        //tömmer listan med platser.
        cbxPlatser.removeAllItems();
        //kör sql frågan till en ArrayList.
        ArrayList<HashMap<String, String>> resultList = idb.fetchRows(SQLQuery);

            // Loopar igenom resultatet. 
            for (HashMap<String, String> row : resultList) {
                // Hämta platsID och Benamning.
                String platsId = row.get("Plats_ID");
                String benamning = row.get("Benamning");

                
                System.out.println("Plats_ID: " + platsId + ", Benamning: " + benamning);
                //Lägger till platsID och benamning i listan.
                cbxPlatser.addItem(platsId + " - " + benamning);
            }
           
           //Ser till så man kan välja plats och hämta aliens.
           cbxPlatser.setEnabled(true);
           btnHämtaAliens.setEnabled(true);
                      
        // TODO add your handling code here:
    } catch (InfException ex) {
        JOptionPane.showMessageDialog(null, "Något gick fel!");
        System.out.println(ex.getMessage());
  }
        
    }//GEN-LAST:event_btnHamtaPlatsActionPerformed

    private void btnHämtaAliensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHämtaAliensActionPerformed
    try {
        
        String platsId;
        Object selectedItem = cbxPlatser.getSelectedItem();

        if (selectedItem != null) {
            //tar första tecknet i rutan som är ett platsID
            platsId = selectedItem.toString().substring(0, 1);
            int position = selectedItem.toString().indexOf("-")+1;
            //Tar allt efter bindesstreck som är platsnamn.
            String platsnamn = selectedItem.toString().substring(position);
   
            System.out.println("PlatsID: " + platsId);
            String SQLQuery = "SELECT Namn from Alien where Plats ="+ platsId+";";
            //kör sql frågan till en ArrayList.
            ArrayList<HashMap<String, String>> resultList = idb.fetchRows(SQLQuery);

            // Loopar igenom resultatet i ArrayList.
            if (resultList.isEmpty()){
                txtAliens.setText("");
                txtAliens.append("I "+ platsnamn + " finns inga Aliens ");
            }
            
            else{
                 txtAliens.setText("");
                 txtAliens.append("I "+ platsnamn + " finns: ");
            
                 for (HashMap<String, String> row : resultList) {
                // Hämtar namnen på aliens. 
                String Namn = row.get("Namn");
                
                
                System.out.println("Namn: " + Namn);
               
                
                txtAliens.append("\n" + Namn)  ;
   
            }
                
            }
     } 

    
    else {
    System.out.println("Inget objekt valt.");
}

                 
   

    
    } 
    
        catch (InfException ex) {
        Logger.getLogger(SokAlien.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnHämtaAliensActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        new AgentFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHamtaPlats;
    private javax.swing.JButton btnHämtaAliens;
    private javax.swing.JComboBox<String> cbxPlatser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea txtAliens;
    // End of variables declaration//GEN-END:variables
}
