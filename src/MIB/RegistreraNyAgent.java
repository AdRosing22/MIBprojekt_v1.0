/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *Klass för att registrera ny agent i databasen
 * 
 * @author adamrosing
 */
public class RegistreraNyAgent extends javax.swing.JFrame {

    private InfDB idb;
    
    /**
     * Creates new form RegistreraNyAgent
     */
    public RegistreraNyAgent(InfDB idb) {
        initComponents();
        this.idb = idb;
        setLocationRelativeTo(null);
        laddaOmraden();
        txtfID.setEditable(false);
        txtfID.setText(genereraAgentId());
        txtfTelefon.setText("555-");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTillbaka = new javax.swing.JToggleButton();
        jLtitel = new javax.swing.JLabel();
        jLepost = new javax.swing.JLabel();
        jLnamn = new javax.swing.JLabel();
        jLtelefon = new javax.swing.JLabel();
        jLadmin = new javax.swing.JLabel();
        jLlosen = new javax.swing.JLabel();
        jLomrade = new javax.swing.JLabel();
        txtfEpost = new javax.swing.JTextField();
        txtfLosen = new javax.swing.JTextField();
        txtfNamn = new javax.swing.JTextField();
        txtfTelefon = new javax.swing.JTextField();
        cbxAdmin = new javax.swing.JComboBox<>();
        cbxOmrade = new javax.swing.JComboBox<>();
        jLagentid = new javax.swing.JLabel();
        txtfID = new javax.swing.JTextField();
        btnBekrafta = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        jLtitel.setText("Registrera ny agent:");

        jLepost.setText("E-post:");

        jLnamn.setText("Namn:");

        jLtelefon.setText("Telefon:");

        jLadmin.setText("Administratör:");

        jLlosen.setText("Lösenord:");

        jLomrade.setText("Område:");

        txtfLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfLosenActionPerformed(evt);
            }
        });

        txtfNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfNamnActionPerformed(evt);
            }
        });

        txtfTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfTelefonActionPerformed(evt);
            }
        });

        cbxAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JA", "NEJ" }));

        cbxOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLagentid.setText("ID:");

        btnBekrafta.setText("Bekräfta");
        btnBekrafta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBekraftaActionPerformed(evt);
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
                        .addComponent(btnTillbaka))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLtitel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLnamn)
                            .addComponent(jLepost)
                            .addComponent(jLtelefon)
                            .addComponent(jLadmin)
                            .addComponent(jLlosen)
                            .addComponent(jLomrade)
                            .addComponent(jLagentid))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfEpost)
                            .addComponent(txtfLosen)
                            .addComponent(txtfNamn)
                            .addComponent(txtfTelefon)
                            .addComponent(cbxAdmin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnBekrafta)))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLtitel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLagentid)
                    .addComponent(txtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLepost)
                    .addComponent(txtfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLlosen)
                    .addComponent(txtfLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnamn)
                    .addComponent(txtfNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLtelefon)
                    .addComponent(txtfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLadmin)
                    .addComponent(cbxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLomrade)
                    .addComponent(cbxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBekrafta)
                .addGap(30, 30, 30)
                .addComponent(btnTillbaka)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new HanteraAgentAdmin(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void txtfLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfLosenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfLosenActionPerformed

    private void txtfNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfNamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfNamnActionPerformed

    private void txtfTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfTelefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfTelefonActionPerformed

    private void btnBekraftaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBekraftaActionPerformed
       
        //hämtar ut områdes id från cboxen
        String omrade = cbxOmrade.getSelectedItem().toString();
        String[] omradeid = omrade.split("-");
        String id = omradeid[0];
        
        //hämtar svar om adminstatus
        String adminSvar = cbxAdmin.getSelectedItem().toString();
        String admin = adminSvar.substring(0, 1);
       
        //hämtar textfälten
        String epost = txtfEpost.getText();
        String losen = txtfLosen.getText();
        String namn = txtfNamn.getText();
        String telefon = txtfTelefon.getText();
        
        
        try{
            //validering att textrutor är ifyllda och namn innehåller bokstav, epost innehåller @ och bokstav, lösenordet är godkänd längd
            if(Validering.isTxtFilled(epost) && Validering.isTxtFilled(losen)&&Validering.isTxtFilled(namn)&&Validering.isTxtFilled(telefon) && Validering.containsAlphabet(namn) && Validering.isEpostTrustable(epost) && Validering.godkanndLosenLangd(losen)){
                
                //validering att telefonnumret är ifyllt på korrekt sätt
                String[] TEL = txtfTelefon.getText().split("-");
                if(TEL.length != 2){
                    JOptionPane.showMessageDialog(null,"Du kan inte bara ha riktnumret som telefon utan du måste ha exempelvis: 555-555");
                }else{
                    telefon = TEL[0]+TEL[1];
                
                    //kontroll att eposten inte finns under varken alien eller agent redan
                    if(Validering.epostKontrollVidreg(epost)){
                
                        //validering att telefonnumret enbart innehåller siffror
                        if(Validering.containsOnlyNumber(telefon)){
                            
                            String Aid = genereraAgentId();
                            telefon = TEL[0] +"-"+TEL[1];
                            String nyAgentFraga = "INSERT INTO Agent VALUES ("+Aid+", '"+namn+"', '"+telefon+"', "+dagensDatum()+", '"+admin+"', '"+epost+"', '"+losen+"', "+id+")";
                            idb.insert(nyAgentFraga);
                            String nyFaltAgent = "INSERT INTO Faltagent VALUES ("+Aid+")";
                            idb.insert(nyFaltAgent);
                            JOptionPane.showMessageDialog(null, "Ny agent registrerad med epost: "+epost+" och lösenord: "+losen);
                            tomFalt(); 
                        }else{
                            JOptionPane.showMessageDialog(null, "Du kan inte ha bokstäver i telefonnumret!");
                        }
                
                    }else{
                        JOptionPane.showMessageDialog(null, "Det finns redan ett konto med den eposten!");
                    }
                }
            }
             
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null,"Något gick fel");
            System.out.println(ex.getMessage());
        }
        
        
    }//GEN-LAST:event_btnBekraftaActionPerformed


 //metod som tömmer alla fält 
private void tomFalt()
{
    txtfEpost.setText("");
    txtfNamn.setText("");
    txtfLosen.setText("");
    txtfTelefon.setText("555-");
    txtfID.setText(genereraAgentId());
}
 

//metod som laddar alla områden
private void laddaOmraden(){
    try{
        ArrayList<HashMap<String, String>> omradeList = idb.fetchRows("SELECT * FROM omrade");
        cbxOmrade.removeAllItems();
        for(HashMap<String, String> omrade : omradeList)
        {
            String omradeid = omrade.get("Omrades_ID");
            String namn = omrade.get("Benamning");
            cbxOmrade.addItem(omradeid+"-"+namn);
        }
    }catch(InfException ex){
        JOptionPane.showMessageDialog(null, "Något gick fel");
        System.out.println("Internt felmed:"+ex.getMessage());
    }
}


//metod som skapar nytt agentid
private String genereraAgentId()
{
    String nyAgentId ="";
    try{
        nyAgentId = idb.getAutoIncrement("Agent", "Agent_ID");
    }catch(InfException ex){
        JOptionPane.showMessageDialog(null, "Kunde inte skapa ett nytt ID för agenten");
        System.out.println(ex.getMessage());
    }
    return nyAgentId;
}

//live metod för att generera dagens datum
private String dagensDatum()
    {
        String datum = LocalDate.now().toString();
        String ar = datum.substring(0, 4);
        String manad = datum.substring(5, 7);
        String dag = datum.substring(8, 10);
        System.out.println(ar + manad + dag);
        String dagensdatum = ar + manad + dag;
        return dagensdatum;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBekrafta;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JComboBox<String> cbxAdmin;
    private javax.swing.JComboBox<String> cbxOmrade;
    private javax.swing.JLabel jLadmin;
    private javax.swing.JLabel jLagentid;
    private javax.swing.JLabel jLepost;
    private javax.swing.JLabel jLlosen;
    private javax.swing.JLabel jLnamn;
    private javax.swing.JLabel jLomrade;
    private javax.swing.JLabel jLtelefon;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JTextField txtfEpost;
    private javax.swing.JTextField txtfID;
    private javax.swing.JTextField txtfLosen;
    private javax.swing.JTextField txtfNamn;
    private javax.swing.JTextField txtfTelefon;
    // End of variables declaration//GEN-END:variables
}
