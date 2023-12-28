/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *Klass för att lägga till utrustning i systemet i utrustning tabellen och
 * --någon av subtabellerna vapen, kommunikato eller teknik
 * 
 * @author alvin & adam
 */
public class RegNyUtrustning extends javax.swing.JFrame {

    private InfDB idb;
    /**
     * Creates new form RegNyUtrustning
     */
    public RegNyUtrustning(InfDB idb) {
        initComponents();
        setLocationRelativeTo(null);
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
        jLväljUtrustningstyp = new javax.swing.JLabel();
        cbxVälj = new javax.swing.JComboBox<>();
        txtbNamn = new javax.swing.JTextField();
        txtbEgenskap = new javax.swing.JTextField();
        jLnamn = new javax.swing.JLabel();
        btnRegistrera = new javax.swing.JToggleButton();
        jLattribut = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLtitel.setText("Registrera ny agentutrustning");

        jLväljUtrustningstyp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLväljUtrustningstyp.setText("Välj utrustningstyp:");

        cbxVälj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Vapen", "Kommunikation", "Teknik" }));
        cbxVälj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVäljActionPerformed(evt);
            }
        });

        txtbNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbNamnActionPerformed(evt);
            }
        });

        txtbEgenskap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbEgenskapActionPerformed(evt);
            }
        });

        jLnamn.setText("Namn:");

        btnRegistrera.setText("Bekräfta registrering");
        btnRegistrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistreraActionPerformed(evt);
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
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLtitel)
                            .addComponent(jLväljUtrustningstyp)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLnamn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLattribut, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxVälj, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtbNamn)
                            .addComponent(txtbEgenskap))))
                .addGap(0, 94, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnTillbaka, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btnRegistrera)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLtitel)
                .addGap(36, 36, 36)
                .addComponent(jLväljUtrustningstyp)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbxVälj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLnamn))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbEgenskap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLattribut, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrera)
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTillbaka)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxVäljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVäljActionPerformed

        //hämtar valet från hårdkodade cboxen
        String valdUtrustning = cbxVälj.getSelectedItem().toString();
        
        
        //switch med valet som villkort
        switch (valdUtrustning) {
            
            //ifall vapen är valt blir instruktionen att mata in kaliber
            case "Vapen":
                jLattribut.setText("Kaliber i formen 0.00");
                break;
            case "Kommunikation":
                jLattribut.setText("Överföringsteknik");
                break;
            case "Teknik":
                jLattribut.setText("Kraftkälla");
                break;
                
                //ifall inget är valt försivnner instruktionstexten
            case "Välj":
                jLattribut.setText("");
                break;
               
        }
    }//GEN-LAST:event_cbxVäljActionPerformed

    private void btnRegistreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistreraActionPerformed
      
        
       String valdUtrustning = cbxVälj.getSelectedItem().toString();
        
       int nyUtrustningsID = 0;
        
        //switch för att registrera utrustningen med val av kategori som utgångspunkt
        switch (valdUtrustning) {
            case "Vapen":
                try{
                    //genererar nytt UtrustningsID via databas metod
                    String genereraID = idb.getAutoIncrement("Utrustning", "Utrustnings_ID");
                    
                    //ifall det inte finns någon utrustning blir id 1
                    if(genereraID == null){
                        nyUtrustningsID = 1;
                    }else{
                        //omvandlar till int från string
                        nyUtrustningsID = Integer.parseInt(genereraID);
                    }
                        //sql frågor för att lägga till i utrustnings tabellen och vapen tabellen
                        String fraga1 = "INSERT INTO utrustning VALUES("+nyUtrustningsID+",'"+txtbNamn.getText()+"')";
                        String fraga2 = "INSERT INTO vapen VALUES("+nyUtrustningsID+",'"+txtbEgenskap.getText()+"')";
                        System.out.println(fraga1);
                        System.out.println(fraga2);
                    
                        //validering att båda textrutor är ifyllda och namnet innehåller bokstav
                    if(Validering.isTxtFilled(txtbNamn.getText()) && Validering.isTxtFilled(txtbEgenskap.getText()) && Validering.containsAlphabet(txtbNamn.getText()) && Validering.korrektFormWorm(txtbEgenskap.getText()))
                    {
                        idb.insert(fraga1);
                        idb.insert(fraga2);
                        JOptionPane.showMessageDialog(null,"Registreringen lyckades!");
                        txtbNamn.setText("");
                        txtbEgenskap.setText("");
                    }
                }catch(InfException ex)
                {
                    JOptionPane.showMessageDialog(null,"Något gick fel");
                    System.out.println(ex.getMessage());
                }
                
                
                break;
            case "Kommunikation":
                try{
                    String genereraID = idb.getAutoIncrement("Utrustning", "Utrustnings_ID");
                    
                    if(genereraID == null){
                        nyUtrustningsID = 1;
                    }else{
                        nyUtrustningsID = Integer.parseInt(genereraID);
                    }
                    
                    String fraga1 = "INSERT INTO utrustning VALUES("+nyUtrustningsID+",'"+txtbNamn.getText()+"')";
                    String fraga2 = "INSERT into kommunikation VALUES("+nyUtrustningsID+",'"+txtbEgenskap.getText()+"')";
                    
                    if(nyUtrustningsID != 0 && Validering.isTxtFilled(txtbNamn.getText()) && Validering.isTxtFilled(txtbEgenskap.getText()) && Validering.containsAlphabet(txtbNamn.getText()))
                    {
                        idb.insert(fraga1);
                        idb.insert(fraga2);
                        JOptionPane.showMessageDialog(null,"Registreringen lyckades!");
                        txtbNamn.setText("");
                        txtbEgenskap.setText("");
                    }
                    }catch(InfException ex)
                    {
                        JOptionPane.showMessageDialog(null,"Något gick fel");
                        System.out.println(ex.getMessage());
                    }
                
                break;
            case "Teknik":
                try{
                    String genereraID = idb.getAutoIncrement("Utrustning", "Utrustnings_ID");
                    if(genereraID == null){
                        nyUtrustningsID = 1;
                    }else{
                        nyUtrustningsID = Integer.parseInt(genereraID);
                    }
                    String fraga1 = "INSERT INTO utrustning VALUES("+nyUtrustningsID+",'"+txtbNamn.getText()+"')";
                    String fraga2 = "INSERT INTO teknik VALUES("+nyUtrustningsID+",'"+txtbEgenskap.getText()+"')";
                    
                    if(nyUtrustningsID != 0 && Validering.isTxtFilled(txtbNamn.getText()) && Validering.isTxtFilled(txtbEgenskap.getText()) && Validering.containsAlphabet(txtbNamn.getText()))
                    {
                        idb.insert(fraga1);
                        idb.insert(fraga2);
                        JOptionPane.showMessageDialog(null,"Registreringen lyckades!");
                        txtbNamn.setText("");
                        txtbEgenskap.setText("");
                    }
                    }catch(InfException ex)
                    {
                        JOptionPane.showMessageDialog(null,"Något gick fel");
                        System.out.println(ex.getMessage());
                    }
                
                break;
            case "Välj":
                JOptionPane.showMessageDialog(null,"Välj kategori i rullgardinen för att slutföra registreringen");
                break;
               
        }
        
        
        
    }//GEN-LAST:event_btnRegistreraActionPerformed

    private void txtbEgenskapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbEgenskapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbEgenskapActionPerformed

    private void txtbNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbNamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbNamnActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        
        //bestämmer ifall man ska skickas tillbaka till admin eller agentfönster
        if(Validering.kontrollOmAdmin(InlogAgent.getEpost())){
            new AgentAdminFonster(idb).setVisible(true);
            dispose();
        }else{
            new AgentFonster(idb).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnTillbakaActionPerformed



    
    

    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnRegistrera;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JComboBox<String> cbxVälj;
    private javax.swing.JLabel jLattribut;
    private javax.swing.JLabel jLnamn;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JLabel jLväljUtrustningstyp;
    private javax.swing.JTextField txtbEgenskap;
    private javax.swing.JTextField txtbNamn;
    // End of variables declaration//GEN-END:variables


}
