/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *Metod som alien kommer åt
 * Visar agentinfo för den som är chef för området som en aliens plats hör till
 * 
 * @author adamrosing
 */
public class OmradesChefInfo extends javax.swing.JFrame {

    private InfDB idb;
    private String namn;
    private String telefon;
    private String anstallningsdatum;
    private String epost;
    private String omrade;
    /**
     * Creates new form OmradesChefInfo
     */
    public OmradesChefInfo(InfDB idb) {
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

        jLtitel = new javax.swing.JLabel();
        btnHamtaOmradesChef = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOmradeschef = new javax.swing.JTextArea();
        btnTillbaka = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setText("Områdeschef information");

        btnHamtaOmradesChef.setText("Hämta information om din områdeschef");
        btnHamtaOmradesChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtaOmradesChefActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtOmradeschef.setColumns(20);
        txtOmradeschef.setRows(5);
        jScrollPane1.setViewportView(txtOmradeschef);

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
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnHamtaOmradesChef)
                                .addGap(57, 57, 57))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLtitel)
                                .addGap(107, 107, 107))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLtitel)
                .addGap(18, 18, 18)
                .addComponent(btnHamtaOmradesChef)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHamtaOmradesChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaOmradesChefActionPerformed
       
try {
        //SQL fråga för sammanfoga alien och agent på plats, till område, till områdeschef, till agent.
        String fraga = "SELECT agent.namn, agent.telefon, agent.anstallningsdatum, agent.epost, omrade.benamning FROM Agent "
                    + "JOIN omradeschef ON agent.agent_id = omradeschef.Agent_ID "
                    + "JOIN omrade ON omradeschef.Omrade = omrade.Omrades_ID "
                    + "JOIN plats ON omrade.Omrades_ID = plats.Finns_I "
                    + "JOIN alien ON plats.Plats_ID = alien.Plats "
                    + "WHERE alien.Epost = '"+InlogAlien.getEpost()+"'";
         
        //skapar ny hasmap för att kunna hämta rad via InfDB fetchRow() metod
        HashMap<String, String> omradeschefInfo = idb.fetchRow(fraga);
    
        //mapen får inte vara tom
        if (omradeschefInfo != null) {
            
            //hämtar från mapen på SQL tabellens kolumnnamn som nyckel
            namn = omradeschefInfo.get("Namn");
            telefon = omradeschefInfo.get("Telefon");
            anstallningsdatum = omradeschefInfo.get("Anstallningsdatum");
            epost = omradeschefInfo.get("Epost");
            omrade = omradeschefInfo.get("Benamning");
            
            
            //kontrollerar att det finns en chef, eftersom vi hämtar benamning som kommer göra att mapen inte är null
            if(epost != null){
          
            //via append() visar man det i textrutan
            txtOmradeschef.append("Namn: "+namn+"\n");
            txtOmradeschef.append("Telefonnummer: "+telefon+"\n");
            txtOmradeschef.append("Anställningsdatum: "+anstallningsdatum+"\n");
            txtOmradeschef.append("Epost: "+epost+"\n");
            txtOmradeschef.append("Ansvar över ditt område: "+omrade+"\n");
          
        //ifall alien inte har någon som är områdeschef, eller saknar område
        } else {
            txtOmradeschef.append("Det finns ingen chef för ditt område!");  
        }
        }
    } catch (InfException ex) {
        JOptionPane.showMessageDialog(null, "Något gick fel");
        System.out.println("Internt felmeddelande:" + ex.getMessage());
    }

    }//GEN-LAST:event_btnHamtaOmradesChefActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new AlienFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnHamtaOmradesChef;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtOmradeschef;
    // End of variables declaration//GEN-END:variables
}
