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
 *
 * @author adamrosing
 */
public class ValjTypSokAvAlien extends javax.swing.JFrame {

    private InfDB idb;
    private String agentnamn;
    /**
     * Creates new form ValjTypSokAvAlien
     */
    public ValjTypSokAvAlien(InfDB idb) {
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
        btnSokPlats = new javax.swing.JButton();
        btnSokRas = new javax.swing.JToggleButton();
        btnSokRas1 = new javax.swing.JToggleButton();
        btnSok = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlien = new javax.swing.JTextArea();
        jLbtnAtgarder = new javax.swing.JLabel();
        jLfonsterAtgard = new javax.swing.JLabel();
        txtFepost = new javax.swing.JTextField();
        jLepost = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JToggleButton();
        jLingenhittad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLtitel.setText("Välj hur du vill söka efter Aliens ");

        btnSokPlats.setText("Sök via plats");
        btnSokPlats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokPlatsActionPerformed(evt);
            }
        });

        btnSokRas.setText("Sök via ras");

        btnSokRas1.setText("Sök mellan registreringsdatum");

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        txtAlien.setColumns(20);
        txtAlien.setRows(5);
        jScrollPane1.setViewportView(txtAlien);

        jLbtnAtgarder.setText("Dessa åtgärder görs via nytt fönster som öppnas");

        jLfonsterAtgard.setText("Sök efter all information om en alien");

        jLepost.setText("E-post:");

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        jLingenhittad.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLbtnAtgarder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLfonsterAtgard)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSokPlats, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jLepost))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSokRas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSokRas1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addComponent(btnTillbaka, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnSok, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLingenhittad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFepost, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                        .addGap(58, 58, 58))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLtitel)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLtitel)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbtnAtgarder)
                    .addComponent(jLfonsterAtgard))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFepost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLepost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSok)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLingenhittad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSokPlats)
                        .addGap(18, 18, 18)
                        .addComponent(btnSokRas)
                        .addGap(18, 18, 18)
                        .addComponent(btnSokRas1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTillbaka)
                        .addGap(40, 40, 40))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokPlatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokPlatsActionPerformed
        // TODO add your handling code here:
        new SokAlien(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSokPlatsActionPerformed

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        
        //tömmer textrutan på tidigare sökning
        txtAlien.setText("");
        jLingenhittad.setText("");
        String epost = txtFepost.getText();
        
     try{
         //validering att textrutan är ifylld och att den angivna eposten existerar i databasen
         if(Validering.isTxtFilled(epost)){
             if(!Validering.epostKontrollVidreg(epost)){
             
             //sqlfraga för at att hämta den nödvändiga infromationen om alien
         String fraga = "SELECT alien.Alien_ID, alien.Registreringsdatum, alien.Namn AS Aliennamn, alien.Telefon, " +
                        "plats.Benamning, agent.Agent_ID, Squid.antal_armar, Boglodite.antal_boogies, Worm.langd " +
                        "FROM Alien " +
                        "JOIN Plats ON alien.Plats = plats.Plats_ID " +
                        "JOIN Agent ON alien.Ansvarig_Agent=agent.Agent_ID " +
                        "LEFT JOIN Squid ON alien.Alien_ID=squid.Alien_ID " +
                        "LEFT JOIN Boglodite ON alien.Alien_ID=boglodite.Alien_ID " +
                        "LEFT JOIN Worm ON alien.Alien_ID=worm.Alien_ID " +
                        "WHERE alien.epost ='"+epost+"'";
         
         //använder InfDB fetchRow för att hämta den raden som frågan returnerar
         //använder fetchRow istället för fetchRows eftersom epost är unik och
         //det ska enbart skapas en rad av frågan
         HashMap<String, String> alienInfo = idb.fetchRow(fraga);
         
         //kontroll att inte mapen är tom
         if(alienInfo != null){
             String alienid = alienInfo.get("Alien_ID");
             String datum = alienInfo.get("Registreringsdatum");
             String aliennamn = alienInfo.get("Namn");
             String telefon = alienInfo.get("Telefon");
             String plats = alienInfo.get("Benamning");
             String agentid = alienInfo.get("Agent_ID");
             String squid = alienInfo.get("Antal_Armar");
             String boglodite = alienInfo.get("Antal_Boogies");
             String worm = alienInfo.get("Langd");
             
             //eftersom fetchRow inte accepterar AS i sql så hämtas agentnamnet
             //separat för blev problem då aliennamnet också hämtades samtidigt
             String fraga2 = "SELECT namn FROM agent WHERE agent_id="+agentid;
             String svar = idb.fetchSingle(fraga2);
             
             if(svar != null){
                 agentnamn = svar;
             }else{
                 agentnamn = "Saknas information";
             }
             
             //visar hämtade informationen i textrutan
             txtAlien.append("ID: "+alienid+"\n");
             txtAlien.append("Namn: "+aliennamn+"\n");
             txtAlien.append("Registreringsdatum: "+datum+"\n");
             txtAlien.append("Telefon: "+telefon+"\n");
             txtAlien.append("Plats: "+plats+"\n");
             txtAlien.append("Ansvarig agent: ID: "+agentid+", Namn: "+agentnamn+"\n");
             
             //kontroll för att avgöra rasen
             //hårdkodat :/ men aja
             if(squid!= null){
                 txtAlien.append("Ras: Squid"+"\n");
                 txtAlien.append("Antal armar: "+squid);
             }else if(boglodite != null){
                 txtAlien.append("Ras: Boglodite"+"\n");
                 txtAlien.append("Antal boogies: "+boglodite);
             }else if(worm != null){
                 txtAlien.append("Ras: Worm"+"\n");
                 txtAlien.append("Längd: "+worm);
             }
             

            
         }
         //tömmer epost rutan för användarvänlighet
         txtFepost.setText("");
         }
         else{
             jLingenhittad.setText("Ingen e-post hittad som matchar sökningen");
         }
         }    
     }catch(InfException ex){
         JOptionPane.showMessageDialog(null,"Något gick fel");
         System.out.println("Internt felmeddelande: "+ex.getMessage());
     }
    }//GEN-LAST:event_btnSokActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new AgentFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnSok;
    private javax.swing.JButton btnSokPlats;
    private javax.swing.JToggleButton btnSokRas;
    private javax.swing.JToggleButton btnSokRas1;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JLabel jLbtnAtgarder;
    private javax.swing.JLabel jLepost;
    private javax.swing.JLabel jLfonsterAtgard;
    private javax.swing.JLabel jLingenhittad;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAlien;
    private javax.swing.JTextField txtFepost;
    // End of variables declaration//GEN-END:variables
}
