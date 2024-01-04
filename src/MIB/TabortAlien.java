/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *klass för att ta bort aliens ur systemet
 * Kontrollerar ifall aliens id finns med i någon ras tabell och tar bort där också
 * Tar bort alien även om den saknar ras
 * 
 * @author adamrosing & Melker
 */
public class TabortAlien extends javax.swing.JFrame {
    
    private InfDB idb;

    /**
     * Creates new form TabortAlien
     */
    public TabortAlien(InfDB idb) {
        initComponents();
        this.idb = idb;
        laddaAliens();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLtitel = new javax.swing.JLabel();
        jLvaljAlien = new javax.swing.JLabel();
        cbxAlien = new javax.swing.JComboBox<>();
        btnTabort = new javax.swing.JToggleButton();
        btnTillbaka = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLtitel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLtitel.setText("Ta bort alien ur systemet");

        jLvaljAlien.setText("Välj alien:");

        cbxAlien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAlien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxAlienKeyPressed(evt);
            }
        });

        btnTabort.setText("Bekräfta");
        btnTabort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabortActionPerformed(evt);
            }
        });
        btnTabort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTabortKeyPressed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 101, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLvaljAlien)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLtitel))
                                .addGap(92, 92, 92))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnTabort, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLtitel)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLvaljAlien)
                    .addComponent(cbxAlien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(btnTabort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTabortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabortActionPerformed
        // TODO add your handling code here:
        
        try{
            //ifall man inte valt alien får meddelande
            if(cbxAlien.getSelectedItem().toString().equals("Välj")){
                JOptionPane.showMessageDialog(null,"Du måste välja alien att ta bort");
            }else{
                
                //hämtar id för vald alien till lokal variabel
                String alienid = getAlienId();
                
                //delete sql frågor för varje ras
                String delSquid = "DELETE FROM squid WHERE Alien_ID = "+alienid;
                String delWorm = "DELETE FROM worm WHERE Alien_ID = "+alienid;
                String delBog = "DELETE FROM boglodite WHERE Alien_ID = "+alienid;
                
                //försöker hämta alien från varje ras för att kontrollera var den är registrerad
                String kollaSquid = idb.fetchSingle("SELECT Alien_ID FROM squid WHERE Alien_ID = "+alienid);
                String kollaWorm = idb.fetchSingle("SELECT Alien_ID FROM worm WHERE Alien_ID = "+alienid);
                String kollaBog = idb.fetchSingle("SELECT Alien_ID FROM boglodite WHERE Alien_ID = "+alienid);
                
                //kontroll ifall alien finns med i raserna
                if(kollaSquid != null){
                    idb.delete(delSquid);
                }else if(kollaWorm != null){
                    idb.delete(delWorm);
                }else if(kollaBog != null){
                    idb.delete(delBog);
                }
                
                //fråga för att delete hela alien från Alien tabellen
                String delAlien = "DELETE FROM Alien WHERE Alien_ID = "+alienid;
                
                idb.delete(delAlien);
                
                JOptionPane.showMessageDialog(null,"Alien med id: "+alienid+" är nu borttagen");
                
                //laddar om aliens så den borttagna inte finns med
                laddaAliens();
            } 
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null,"Något gick fel");
            System.out.println("Internt felmed: "+ex.getMessage());
        }
        
        
    }//GEN-LAST:event_btnTabortActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new HanteraAliensFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnTabortKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTabortKeyPressed
         
    }//GEN-LAST:event_btnTabortKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formKeyPressed

    
    //funkar att trycka enter, behöver inte trycka på knappen med musen
    private void cbxAlienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxAlienKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnTabort.doClick();
            
        }
    }//GEN-LAST:event_cbxAlienKeyPressed

    
    
    
    
    
    
    
    //metod som tar ut alienid från cboxen för vald alien
    private String getAlienId(){
        String valdalien = cbxAlien.getSelectedItem().toString();
        String[] alien = valdalien.split("-");
        String id = alien[0];
        return id;
    }
    
    
    //metod som laddar cboxen med alien information
    private void laddaAliens() {
        try{
            
            ArrayList<HashMap<String, String>> alienlist = idb.fetchRows("SELECT Alien_ID, Epost, Namn FROM alien");
            
            cbxAlien.removeAllItems();
            cbxAlien.addItem("Välj");
            
            for (HashMap<String, String> alien : alienlist) {
                String epost = alien.get("Epost");
                String namn = alien.get("Namn");
                String id = alien.get("Alien_ID");
                cbxAlien.addItem(id+"-"+namn + " (" + epost + ")");   
            }   
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmed: "+ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnTabort;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JComboBox<String> cbxAlien;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JLabel jLvaljAlien;
    // End of variables declaration//GEN-END:variables
}
