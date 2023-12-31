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
 * Klass för att ändra på lagrad information om agent
 * Kan inte redigera e-post eftersom det används som unik identifierare
 * 
 *
 * @author adamrosing
 */
public class RedigeraAgentFonster extends javax.swing.JFrame {

    private InfDB idb;
    
    /**
     * Creates new form RedigeraAgentFonster
     */
    public RedigeraAgentFonster(InfDB idb) {
        initComponents();
        this.idb = idb;
        setLocationRelativeTo(null);
        laddaAgenter();
        laddaOmraden();
        txtfNuvomrade.setEditable(false);
        txtfEpost.setEditable(false);
        
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
        jLnamn = new javax.swing.JLabel();
        jLepost = new javax.swing.JLabel();
        jLtelefon = new javax.swing.JLabel();
        jLansDatum = new javax.swing.JLabel();
        jLlosenord = new javax.swing.JLabel();
        jLlosenord1 = new javax.swing.JLabel();
        txtfEpost = new javax.swing.JTextField();
        txtfNamn = new javax.swing.JTextField();
        txtfTelefon = new javax.swing.JTextField();
        txtfDatum = new javax.swing.JTextField();
        txtfLosen = new javax.swing.JTextField();
        cbxOmrade = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLvalAgent = new javax.swing.JLabel();
        cbxAgenter = new javax.swing.JComboBox<>();
        btnHamtainfo = new javax.swing.JButton();
        jLnuvomrade = new javax.swing.JLabel();
        txtfNuvomrade = new javax.swing.JTextField();
        btnBekrafta = new javax.swing.JToggleButton();
        btnTillbaka = new javax.swing.JButton();
        jLutrustning = new javax.swing.JLabel();
        cbxUtrustning = new javax.swing.JComboBox<>();
        jLlamnaIn = new javax.swing.JLabel();
        cbxInneharUtr = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLtitel.setText("Redigera information om en befintlig agent");

        jLnamn.setText("Namn:");

        jLepost.setText("E-post:");

        jLtelefon.setText("Telefon:");

        jLansDatum.setText("Anställningsdatum:");

        jLlosenord.setText("Lösenord:");

        jLlosenord1.setText("Nytt Område:");

        cbxOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        jLabel1.setText("För att ändra administratörsstatus, gå tillbaka till tidigare fönster och välj \"Redigera adminstatus\"");

        jLvalAgent.setText("Välj agent:");

        cbxAgenter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAgenter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAgenterItemStateChanged(evt);
            }
        });
        cbxAgenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAgenterActionPerformed(evt);
            }
        });

        btnHamtainfo.setText("Hämta uppgifter");
        btnHamtainfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtainfoActionPerformed(evt);
            }
        });

        jLnuvomrade.setText("Nuvarande Område:");

        btnBekrafta.setText("Bekräfta");
        btnBekrafta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBekraftaActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        jLutrustning.setText("Kvittera ut utrustning:");

        cbxUtrustning.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        jLlamnaIn.setText("Kvittera in utrustning:");

        cbxInneharUtr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 104, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLtitel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLtelefon)
                                .addGap(18, 18, 18)
                                .addComponent(txtfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLlosenord)
                                    .addComponent(jLansDatum)
                                    .addComponent(jLlosenord1)
                                    .addComponent(jLnuvomrade)
                                    .addComponent(jLutrustning)
                                    .addComponent(jLlamnaIn))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtfDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(txtfLosen, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(cbxOmrade, 0, 170, Short.MAX_VALUE)
                                    .addComponent(txtfNuvomrade, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(cbxUtrustning, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxInneharUtr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLnamn)
                                .addGap(18, 18, 18)
                                .addComponent(txtfNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLvalAgent)
                                    .addComponent(jLepost))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnHamtainfo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka)
                        .addGap(228, 228, 228)
                        .addComponent(btnBekrafta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLtitel)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLvalAgent)
                    .addComponent(cbxAgenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHamtainfo))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLepost)
                    .addComponent(txtfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnamn)
                    .addComponent(txtfNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLtelefon)
                    .addComponent(txtfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLansDatum)
                    .addComponent(txtfDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLlosenord)
                    .addComponent(txtfLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnuvomrade)
                    .addComponent(txtfNuvomrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLlosenord1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLutrustning)
                    .addComponent(cbxUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLlamnaIn)
                    .addComponent(cbxInneharUtr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBekrafta)
                    .addComponent(btnTillbaka))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAgenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAgenterActionPerformed
        // TODO add your handling code here    
    }//GEN-LAST:event_cbxAgenterActionPerformed

    private void cbxAgenterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAgenterItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAgenterItemStateChanged

    private void btnHamtainfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtainfoActionPerformed
        
        //när man hämtar info om en agent
        //tömmer alla fält från tidigare redigering
        tomAllaFalt();
        //hämtar info om nya agenten och fyller fälten
        hamtaInfoAgent();
        //laddar in alla områden
        laddaOmraden();
        //laddar in all utrustning som agenten redan inte har
        laddaAllUtrustning();
        //laddar utrustningen som agenten har
        laddaInneharUtrustning();
    }//GEN-LAST:event_btnHamtainfoActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new HanteraAgentAdmin(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnBekraftaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBekraftaActionPerformed
        
        //hämtar all information från textrutorna
        String epost = txtfEpost.getText();
        String namn = txtfNamn.getText();
        String losenord = txtfLosen.getText();
        String telefon = txtfTelefon.getText();
        String datum = txtfDatum.getText();
         
        try{
            
            String agentid =hamtaAgentID();
            
            //splitar cbox för att få områdes id
            String valOmrade = cbxOmrade.getSelectedItem().toString();
            String[] omrade = valOmrade.split("-");
            String omradeid = omrade[0];
            
            //ifall rutorna är fyllda, namnet innehåller bokstav, lösenord inte längre än 6 tecken, datum och telefon är i rätt form
            if(Validering.isTxtFilled(namn)&&Validering.isTxtFilled(losenord)&&Validering.isTxtFilled(datum)&&Validering.isTxtFilled(telefon) && Validering.containsAlphabet(namn)&&Validering.godkanndLosenLangd(losenord) && Validering.telValidering(telefon) && Validering.datumValidering(datum)){
                
                //ifall man inte valt något nytt område så ska inte områdesid uppdateras
                if(valOmrade.equals("Välj")){
                    String fraga = "UPDATE Agent SET Epost = '"+epost+"', Namn = '"+namn+"', Losenord = '"+losenord+"', Telefon = '"+telefon+"', Anstallningsdatum = '"+datum+"' WHERE Agent_ID = "+agentid;
                    idb.update(fraga);
                    JOptionPane.showMessageDialog(null, "Agentinformation har uppdaterats!");   
                }else{
                    String fraga = "UPDATE Agent SET Epost = '"+epost+"', Namn = '"+namn+"', Losenord = '"+losenord+"', Telefon = '"+telefon+"', Anstallningsdatum = '"+datum+"', Omrade = "+omradeid+" WHERE Agent_ID = "+agentid;
                    idb.update(fraga);
                    JOptionPane.showMessageDialog(null, "Agentinformation har uppdaterats!");
                }

                uppdateraUtrustning();
                //tömmer alla fält så, eftersom uppdateringarna inte syns direkt i cboxarna
                tomAllaFalt();
            }
                 
            
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null,"Något gick fel");
            System.out.println("Intern felmed: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnBekraftaActionPerformed

    

private void uppdateraUtrustning()
{
    try{
        String agentid = hamtaAgentID();
        String dagensdatum = Validering.dagensDatum();
        
        String valNyUtr = cbxUtrustning.getSelectedItem().toString();
        String[] nyUtrID = valNyUtr.split("-");
        String utID = nyUtrID[0];
            
        String valGammalUtr = cbxInneharUtr.getSelectedItem().toString();
        String[] gamUtrID = valGammalUtr.split("-");
        String inID = gamUtrID[0];
        
        //ifall man inte valt att kvittera ut någon utrustning så får man bara system meddelande, inget ska visas för användaren
        if(valNyUtr.equals("Välj")){
            System.out.println("Ingen förändring i utag av utrustning");
        }else{
             //annars sätter man in agentid, utrustningsid och dagensdatum
            String fraga = "INSERT INTO innehar_utrustning VALUES ("+agentid+", "+utID+",'"+dagensdatum+"')";
            idb.insert(fraga);
        }

        //ifall man inte valt att kvittera in innehavd utrustning
        if(valGammalUtr.equals("Välj")){
            System.out.println("Ingen förändring i inkvittering av utrustning");
        }else{
            //annars deletas det från innehar_utrustning eftersom man lämnar tillbaka
            String fraga = "DELETE FROM innehar_utrustning WHERE Agent_ID = "+agentid+" AND Utrustnings_ID = "+inID;
            idb.delete(fraga);
        }
    }catch(InfException ex){
        JOptionPane.showMessageDialog(null,"Något gick fel vid kvittering av utrustning");
        System.out.println(ex.getMessage());
    }
}
    
    
//metod för att tömma alla fält
private void tomAllaFalt(){
    txtfEpost.setText("");
    txtfNamn.setText("");
    txtfLosen.setText("");
    txtfTelefon.setText("");
    txtfDatum.setText("");
    txtfNuvomrade.setText("");
    cbxOmrade.removeAllItems();
    cbxUtrustning.removeAllItems();
    cbxInneharUtr.removeAllItems();
    cbxOmrade.addItem("Välj");
    cbxUtrustning.addItem("Välj");
    cbxInneharUtr.addItem("Välj");
}    
    
//metod för att hämta all info från agent tabellen
private void hamtaInfoAgent(){
    
    String dagensDatum = Validering.dagensDatum();
    String id = hamtaAgentID();
    String fraga = "SELECT * FROM Agent WHERE Agent_ID = "+id;
    
    try{
        HashMap<String, String> agentInfo = idb.fetchRow(fraga);
        
        //här sker kontroll för varje värde för att inte visa null i något textfält, utgår från att epost och lösenord inte ska kunna saknas
        if(agentInfo !=null){
            String namn = agentInfo.get("Namn");
            if(namn != null){
                txtfNamn.setText(namn);
            }else{
                txtfNamn.setText("Info saknas");
            }
            String telefon = agentInfo.get("Telefon");
            if(telefon != null){
                txtfTelefon.setText(telefon);
            }else{
                txtfTelefon.setText("000-000");
            }
            String datum = agentInfo.get("Anstallningsdatum");
            if(datum != null){
                txtfDatum.setText(datum);
            }else{
                txtfDatum.setText(dagensDatum);
            }
            String epost = agentInfo.get("Epost");
            if(epost != null){
                txtfEpost.setText(epost);
            }
            String losenord = agentInfo.get("Losenord");
            if(losenord != null ){
                txtfLosen.setText(losenord);
            }     
            
            //hämtar nuvarande område för agenten
            String nuvOmradesID = agentInfo.get("Omrade");
            String omrnamn = idb.fetchSingle("SELECT benamning FROM omrade where Omrades_ID= "+nuvOmradesID);
            txtfNuvomrade.setText(omrnamn); 
        }
        
    }catch(InfException ex){
        JOptionPane.showMessageDialog(null,"Något gick fel");
        System.out.println("Internt felmeddelande: "+ex.getMessage());
    }
    
    
    
}

//metod för att få id för vald agent i cbx
private String hamtaAgentID(){
    String AgentID = cbxAgenter.getSelectedItem().toString();
    String[] agentInfo = AgentID.split("-");
    String id = agentInfo[0];
    return id;
}


//metod för att visa utrustningen agenten har just nu
private void laddaInneharUtrustning(){
    
    String id = hamtaAgentID();
    
    try{
        ArrayList<HashMap<String, String>> inneharUtr = idb.fetchRows("SELECT innehar_utrustning.Utrustnings_ID, utrustning.Benamning FROM innehar_utrustning JOIN utrustning ON innehar_utrustning.Utrustnings_ID = utrustning.Utrustnings_ID WHERE Agent_ID =" + id);
        cbxInneharUtr.removeAllItems();
        cbxInneharUtr.addItem("Välj");
        for(HashMap<String,String> innehar : inneharUtr){
            String inneharId = innehar.get("Utrustnings_ID");
            String namn = innehar.get("Benamning");
            
            cbxInneharUtr.addItem(inneharId+"-"+namn);
        }
    }catch(InfException ex){
        JOptionPane.showMessageDialog(null,"något gick fel");
        System.out.println("Internt felmed: "+ex.getMessage());
    }
}


//metod för att visa all utrustning som agenten inte innehar, eftersom den inte kan ha två av samma samtidigt
private void laddaAllUtrustning()
{
    String agentID = hamtaAgentID();
    try{
        ArrayList<HashMap<String, String>> utrustningInfo = idb.fetchRows("SELECT utrustning.Utrustnings_ID, utrustning.benamning FROM utrustning LEFT JOIN innehar_utrustning ON utrustning.Utrustnings_ID = innehar_utrustning.Utrustnings_ID AND innehar_utrustning.agent_id = "+agentID+" WHERE innehar_utrustning.Utrustnings_ID IS NULL");
        cbxUtrustning.removeAllItems();
        cbxUtrustning.addItem("Välj");
        for(HashMap<String, String> utrustning : utrustningInfo){
            String utrID = utrustning.get("Utrustnings_ID");
            String namn = utrustning.get("Benamning");
            
            cbxUtrustning.addItem(utrID+"-"+namn);
        }
    }catch(InfException ex){
        JOptionPane.showMessageDialog(null,"något gick fel");
        System.out.println("Internt felmed: "+ex.getMessage());
    }
            
}


    
//metod som hämtar alla agenter
private void laddaAgenter() {
    try {
        ArrayList<HashMap<String, String>> agentlist = idb.fetchRows("SELECT Agent_ID, Namn FROM agent");
        cbxAgenter.removeAllItems();
        for(HashMap<String, String> agent : agentlist) {
            String agentid = agent.get("Agent_ID");
            String namn = agent.get("Namn");
                    
            cbxAgenter.addItem(agentid+"-"+namn);
            }
    }catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
        System.out.println(e.getMessage());
    }
}
            
//metod som hämtar alla områden
private void laddaOmraden(){
    try{
        ArrayList<HashMap<String, String>> omradeList = idb.fetchRows("SELECT * FROM omrade");
        cbxOmrade.removeAllItems();
        cbxOmrade.addItem("Välj");
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBekrafta;
    private javax.swing.JButton btnHamtainfo;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JComboBox<String> cbxAgenter;
    private javax.swing.JComboBox<String> cbxInneharUtr;
    private javax.swing.JComboBox<String> cbxOmrade;
    private javax.swing.JComboBox<String> cbxUtrustning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLansDatum;
    private javax.swing.JLabel jLepost;
    private javax.swing.JLabel jLlamnaIn;
    private javax.swing.JLabel jLlosenord;
    private javax.swing.JLabel jLlosenord1;
    private javax.swing.JLabel jLnamn;
    private javax.swing.JLabel jLnuvomrade;
    private javax.swing.JLabel jLtelefon;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JLabel jLutrustning;
    private javax.swing.JLabel jLvalAgent;
    private javax.swing.JTextField txtfDatum;
    private javax.swing.JTextField txtfEpost;
    private javax.swing.JTextField txtfLosen;
    private javax.swing.JTextField txtfNamn;
    private javax.swing.JTextField txtfNuvomrade;
    private javax.swing.JTextField txtfTelefon;
    // End of variables declaration//GEN-END:variables
}
