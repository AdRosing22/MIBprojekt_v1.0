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
 *Metod för att ändra på innehar_utrustning hos agent
 * 
 * @author adamrosing
 */
public class KvitteringUtrustningAgent extends javax.swing.JFrame {

    private InfDB idb;
    /**
     * Creates new form KvitteringUtrustningAgent
     */
    public KvitteringUtrustningAgent(InfDB idb) {
        initComponents();
        this.idb = idb;
        setLocationRelativeTo(null);
        laddaInneharUtrustning();
        laddaAllUtrustning();
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
        jLutrustning = new javax.swing.JLabel();
        cbxUtrustning = new javax.swing.JComboBox<>();
        jLlamnaIn = new javax.swing.JLabel();
        cbxInneharUtr = new javax.swing.JComboBox<>();
        btnBekrafta = new javax.swing.JToggleButton();
        btnTillbaka = new javax.swing.JToggleButton();
        jLutk = new javax.swing.JLabel();
        jLink = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLtitel.setText("Kvittera utrustning");

        jLutrustning.setText("Kvittera ut utrustning:");

        cbxUtrustning.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

        jLlamnaIn.setText("Kvittera in utrustning:");

        cbxInneharUtr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj" }));

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

        jLutk.setForeground(new java.awt.Color(102, 204, 0));

        jLink.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLtitel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLlamnaIn)
                            .addComponent(jLutrustning)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBekrafta)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxUtrustning, 0, 170, Short.MAX_VALUE)
                            .addComponent(cbxInneharUtr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLutk, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLink, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLtitel)
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLutrustning)
                    .addComponent(cbxUtrustning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLlamnaIn)
                    .addComponent(cbxInneharUtr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBekrafta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLutk, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLink, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new AgentFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnBekraftaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBekraftaActionPerformed
        
            //tömmer bekräftelse meddelanden
            jLutk.setText("");
            jLink.setText("");
        
            //hämmtar index för utkvitterings utrustning från cboxen
            String valNyUtr = cbxUtrustning.getSelectedItem().toString();
            String[] nyUtrID = valNyUtr.split("-");
            String utID = nyUtrID[0];
            
            //hämtar index för inkvitterings utrustning från cboxen
            String valGammalUtr = cbxInneharUtr.getSelectedItem().toString();
            String[] gamUtrID = valGammalUtr.split("-");
            String inID = gamUtrID[0];
            
            //anropar metoden för att hämta id för agenten som är inloggad
            String agentid = hamtaAgentID();
            
            
            //genererar dagens datum
            String dagensdatum = dagensDatum();
            
            try{
            
            //ifall inget är valt att utkvittera
            if(valNyUtr.equals("Välj")){
                        System.out.println("Ingen förändring i utag av utrustning");
                    }else{
                        //annars sätter man in agentid, utrustningsid och dagensdatum i innehar_utrustning
                        String fraga = "INSERT INTO innehar_utrustning VALUES ("+agentid+", "+utID+",'"+dagensdatum+"')";
                        idb.insert(fraga);
                        jLutk.setText("Utkvitterat!");
                    }
                
                    //ifall man inte valt att kvittera in innehavd utrustning
                    if(valGammalUtr.equals("Välj")){
                        System.out.println("Ingen förändring i inkvittering av utrustning");
                    }else{
                        //annars deletas det från innehar_utrustning eftersom man lämnar tillbaka
                        String fraga = "DELETE FROM innehar_utrustning WHERE Agent_ID = "+agentid+" AND Utrustnings_ID = "+inID;
                        idb.delete(fraga);  
                        jLink.setText("Inkvitterat!");
                    }
                    //laddar cboxarna för att de förändringar man gjort ska synas
                    laddaInneharUtrustning();
                    laddaAllUtrustning();
            }catch(InfException ex){
                JOptionPane.showMessageDialog(null,"Något gick fel");
                System.out.println("Internt felmed: "+ex.getMessage());
            }
                    
        
    }//GEN-LAST:event_btnBekraftaActionPerformed

 //metod för att generera dagens datum
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
 
 //metod som hämtar Agent_ID på inloggade agenten via InlogAgent klassen
 private String hamtaAgentID(){
     String id = InlogAgent.getAgentId();
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBekrafta;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JComboBox<String> cbxInneharUtr;
    private javax.swing.JComboBox<String> cbxUtrustning;
    private javax.swing.JLabel jLink;
    private javax.swing.JLabel jLlamnaIn;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JLabel jLutk;
    private javax.swing.JLabel jLutrustning;
    // End of variables declaration//GEN-END:variables
}
