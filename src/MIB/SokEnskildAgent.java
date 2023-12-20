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
 *
 * @author adamrosing
 */
public class SokEnskildAgent extends javax.swing.JFrame {

    private InfDB idb;
    /**
     * Creates new form SokEnskildAgent
     */
    public SokEnskildAgent(InfDB idb) {
        initComponents();
        this.idb = idb;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFagentinfo = new javax.swing.JTextArea();
        txtbEpost = new javax.swing.JTextField();
        jLepost = new javax.swing.JLabel();
        btnSok = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLtitel.setText("Sök efter en Agent");

        txtFagentinfo.setColumns(20);
        txtFagentinfo.setRows(5);
        jScrollPane1.setViewportView(txtFagentinfo);

        jLepost.setText("E-post:");

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLtitel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLepost, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtbEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSok)
                .addGap(213, 213, 213))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLtitel)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLepost))
                .addGap(18, 18, 18)
                .addComponent(btnSok)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        // TODO add your handling code here:
        
        try{
            //tömmer textrutan
            txtFagentinfo.setText("");
            //lokal variabel för att korta ner
            String epost = txtbEpost.getText();
            
            //kontrollerar att textrutan har ett sökvärde och att det värdet finns i databasen
            if(Validering.isTxtFilled(epost) && Validering.finnsAnvandareEpostIDB(epost)){
                
                //sql fråga för agentinfo, kontorschefsinfo och omradeschefsinfo
                String fragaAgent = "SELECT agent.Agent_ID, agent.Namn, agent.Telefon, agent.Anstallningsdatum, agent.Administrator, " +
                                    "omrade.benamning, kontorschef.kontorsbeteckning, omradeschef.omrade FROM agent " +
                                    "JOIN omrade on agent.Omrade = omrade.Omrades_ID " +
                                    "LEFT JOIN kontorschef on agent.Agent_ID=kontorschef.Agent_ID " +
                                    "LEFT JOIN omradeschef on agent.Agent_ID=omradeschef.Agent_ID " +
                                    "WHERE agent.epost ='"+epost+"'";
                
                //sql fråga för utrustningen. Gick inte att slå ihop med fragaAgent då benämning finns två gånger och AS funkar inte i fetchRow
                String fragaUtr = "SELECT utrustning.benamning FROM utrustning " +
                                  "JOIN innehar_utrustning on innehar_utrustning.Utrustnings_ID = utrustning.Utrustnings_ID " +
                                  "JOIN agent on innehar_utrustning.Agent_ID = agent.Agent_ID " +
                                  "WHERE agent.epost ='"+epost+"'";
                
                
                //hämtar resultat raden för agent
                HashMap<String, String> agentInfo = idb.fetchRow(fragaAgent);
                //hämtar result raderna för utrustning
                ArrayList<HashMap<String, String>> utrustning = idb.fetchRows(fragaUtr);
                
                //validering att något har hämtats
                if(agentInfo != null){
                    //hämtar värden från resultatSet
                    String agentid = agentInfo.get("Agent_ID");
                    String namn = agentInfo.get("Namn");
                    String telefon = agentInfo.get("Telefon");
                    String datum = agentInfo.get("Anstallningsdatum");
                    String admin = agentInfo.get("Administrator");
                    String omradenamn = agentInfo.get("Benamning");
                    String kontorchef = agentInfo.get("Kontorsbeteckning");
                    String omradechef = agentInfo.get("Omrade");
                    
                    //Skriver värdena i textrutan
                    txtFagentinfo.append("ID: "+agentid+"\n");
                    txtFagentinfo.append("Namn: "+namn+"\n");
                    txtFagentinfo.append("Telefon: "+telefon+"\n");
                    txtFagentinfo.append("Anställningsdatum: "+datum+"\n");
                    txtFagentinfo.append("Är administratör: "+admin+"\n");
                    
                    //kontroll ifall agenten är områdeschef
                    if(omradechef != null){
                        txtFagentinfo.append("Arbetar och är chef i : "+omradenamn+"\n");
                    }else{
                        txtFagentinfo.append("Stationerad i omrdåe: "+omradenamn+"\n");
                    }
                    //kontroll ifall agenten är kontorschef
                    if(kontorchef != null){
                        txtFagentinfo.append("Kontorschef för: "+kontorchef+"\n");
                    }
                    
                    //hämtar ut utrustningsnamnen. Kontroll så att det inte är tom i ArrayListan
                    if(utrustning.get(0) != null){
                        txtFagentinfo.append("Innehar utrustning:"+"\n");
                        for(HashMap<String, String> rad : utrustning){
                            String utrustningnamn = rad.get("Benamning");
                            txtFagentinfo.append("Namn:"+utrustningnamn+"\n");
                        
                    }
                }
            }
            }
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felm: "+ex.getMessage());
        }catch(Exception e){
            System.out.println("Fel: "+e);
        }
    }//GEN-LAST:event_btnSokActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnSok;
    private javax.swing.JLabel jLepost;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtFagentinfo;
    private javax.swing.JTextField txtbEpost;
    // End of variables declaration//GEN-END:variables
}
