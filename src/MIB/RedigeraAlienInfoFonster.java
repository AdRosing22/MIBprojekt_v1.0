/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;
import oru.inf.InfDB;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfException;


/**
 *
 * @author Melker
 */
public class RedigeraAlienInfoFonster extends javax.swing.JFrame {

    private InfDB idb;
    private boolean isAdmin;
    private HashMap<String, String> alienEpostMap;
    private String epost;
    private String nyttNamn;
    private String nyttLosenord;
    private String nyRegistreringsdatum;
    private String nyttTelefon;
    private String nyAgent;
    private String nyPlats;
    private int agentID;
    private int platsID;
    private String tidigareRas;
    private String attribut;
    private String nuvAlienid;
    /**
     * Creates new form RedigeraAlienInfoFonster
     */
    public RedigeraAlienInfoFonster(InfDB idb) {
        initComponents();
        this.idb = idb;
        epost = InlogAgent.getEpost();
        kontrolleraAdminStatus();
        alienIDField.setEditable(false);
    }
    
    private void laddaAliens() {
        try {
            ArrayList<HashMap<String, String>> alienlist = idb.fetchRows("SELECT Epost, Namn FROM alien");
            alienEpostMap = new HashMap<>();
            chooseAlienCbx.removeAllItems();
            
            for (HashMap<String, String> alien : alienlist) {
                String epost = alien.get("Epost");
                String namn = alien.get("Namn");
                chooseAlienCbx.addItem(namn + " (" + epost + ")");
                alienEpostMap.put(namn, epost);
            }
            
            if(!alienlist.isEmpty()) {
                chooseAlienCbx.setSelectedIndex(0);
                visaAlienInformation(alienEpostMap.get(alienlist.get(0).get("Namn")));
            }
            
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod");
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }
    }
    
    private void kontrolleraAdminStatus() {
            if(Validering.kontrollOmAdmin(InlogAgent.getEpost())) {
                tabortKnapp.setVisible(true);
            } else {
                tabortKnapp.setVisible(false);
            }
                
            
            
    }

    
    
    private void taBortAlien(String epost) {       
            try {
                idb.delete("DELETE FROM boglodite WHERE Alien_ID IN (SELECT Alien_ID FROM alien WHERE Epost = '" + epost + "')");
                idb.delete("DELETE FROM squid WHERE Alien_ID IN (SELECT Alien_ID FROM alien WHERE Epost = '" + epost + "')");
                idb.delete("DELETE FROM worm WHERE Alien_ID IN (SELECT Alien_ID FROM alien WHERE Epost = '" + epost + "')");
                
                idb.delete("DELETE FROM alien WHERE Epost = '" + epost + "'");
                JOptionPane.showMessageDialog(null, "Alien borttagen.");
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Något blev fel.");
                System.out.println("Intern felmeddelande." + e.getMessage());
            }
    }
    
    private void visaAlienInformation(String epost) {
        try {
            HashMap<String, String> alienInfo = idb.fetchRow("SELECT * FROM alien WHERE epost = '" + epost + "'");
            if (alienInfo != null) {
                alienIDField.setText(alienInfo.get("Alien_ID"));
                registreringsdatumField.setText(alienInfo.get("Registreringsdatum"));
                losenordField.setText(alienInfo.get("Losenord"));
                namnField.setText(alienInfo.get("Namn"));
                telefonField.setText(alienInfo.get("Telefon"));
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något blev fel.");
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }
    }
    
    private void uppdateraAlienInformation(String epost) {
        
        Object val = rasCbx.getSelectedItem();
        String menyVal = val.toString();
        
        try {
            nyttNamn = namnField.getText();
            nyttLosenord = losenordField.getText();
            nyRegistreringsdatum = registreringsdatumField.getText();
            nyttTelefon = telefonField.getText();
            nyPlats = (String) platsCbx.getSelectedItem();
            nyAgent = (String) ansvarigAgentCbx.getSelectedItem();
            
            platsID = getPlatsID(nyPlats);
            agentID = getAgentID(nyAgent);
            
            String fraga = "UPDATE alien SET Namn = '" + nyttNamn + "', Losenord = '" + nyttLosenord + "', Registreringsdatum = '" + nyRegistreringsdatum + "', Telefon = '" + nyttTelefon + "', Plats = " + platsID + ", Ansvarig_Agent = " + agentID + " WHERE Epost = '" + epost + "'";
            
            idb.update(fraga);
            JOptionPane.showMessageDialog(null, "Aliens information har uppdaterats.");
            
            alienIDField.setText("");
            registreringsdatumField.setText("");
            losenordField.setText("");
            namnField.setText("");
            telefonField.setText("");          
            platsCbx.setSelectedIndex(0);           
            ansvarigAgentCbx.setSelectedIndex(0);
            
            
            
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
            System.out.println("Internt felmeddelande." + e.getMessage());
        }
}  

    private int getPlatsID(String platsNamn) throws InfException {
        String fraga = "SELECT Plats_ID FROM plats WHERE Benamning = '" + platsNamn + "'";
        String platsID = idb.fetchSingle(fraga);
        if (platsID == null) {
            throw new InfException("Platsen kunde inte hittas.");
        }
        return Integer.parseInt(platsID);
    }
    
    private int getAgentID(String agentNamn) throws InfException {
        String fraga = "SELECT Agent_ID FROM agent WHERE Namn = '" + agentNamn + "'";
        String agentID = idb.fetchSingle(fraga);
        if (agentID == null) {
            throw new InfException("Platsen kunde inte hittas.");
        }
        return Integer.parseInt(agentID);
    }
    
    
    private void laddaPlatser() {
        try {
            ArrayList<HashMap<String, String>> platslist = idb.fetchRows("SELECT Plats_ID, Benamning FROM plats");
            platsCbx.removeAllItems();
            for(HashMap<String, String> plats : platslist) {
                platsCbx.addItem(plats.get("Benamning"));
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }
    }
    
    private void laddaAgenter() {
        try {
            ArrayList<HashMap<String, String>> agentlist = idb.fetchRows("SELECT Agent_ID, Namn FROM agent");
            ansvarigAgentCbx.removeAllItems();
            for(HashMap<String, String> agent : agentlist) {
                ansvarigAgentCbx.addItem(agent.get("Namn"));
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }
    }
    
    private void laddaRaser() {
        
            String ras = (String) rasCbx.getSelectedItem();
            
            switch (ras) {
                case "Squid":
                    rasEgenskaper.setText("Antal Armar:");
                    break;
                case "Boglodite":
                    rasEgenskaper.setText("Antal boogies:");
                    break;
                case "Worm":
                    rasEgenskaper.setText("Längd i formen 0.00:");
                    break;
                case "Välj":
                    rasEgenskaper.setVisible(false);
            
            }
        
            
        }
    
    
    private void hamtaTidigareRas(String epost) {
        try {
            String fragaAlienID = idb.fetchSingle("SELECT Alien_ID FROM alien WHERE Epost = '"+epost+"'");
            int alienid = Integer.parseInt(fragaAlienID);
            String fragaWorm = idb.fetchSingle("SELECT Alien_ID FROM worm WHERE Alien_ID = "+alienid);
            String fragaBog = idb.fetchSingle("SELECT Alien_ID FROM boglodite WHERE Alien_ID = "+alienid);
            String fragaSquid = idb.fetchSingle("SELECT Alien_ID FROM squid WHERE Alien_ID = "+alienid);
            
            if(fragaSquid != null) {
                tidigareRas = "Squid";
            } else if (fragaWorm != null) {
                tidigareRas = "Worm";
            } else if (fragaBog != null) {
                tidigareRas = "Boglodite";
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }
    }
    
    private void uppdateraRas(String epost) {
        Object val = rasCbx.getSelectedItem();
        String menyVal = val.toString();
        tidigareRas = "";
        String delete = "";
        String fraga = "";
        
        try {
            String fragaAlienID = idb.fetchSingle("SELECT Alien_ID FROM alien WHERE Epost = '"+epost+"'");
            int alienid = Integer.parseInt(fragaAlienID);
            hamtaTidigareRas(epost);
            switch (menyVal) {
                case "Squid":
                    attribut = rasEgenskaper.getText();
                    delete = "DELETE FROM " + tidigareRas + " WHERE Alien_ID = " + alienid;
                    fraga = "INSERT INTO Squid VALUES (" + alienid + ", '" + attribut + "')";
                    idb.delete(delete);
                    idb.insert(fraga);
                    
                    break;
                    
                case "Worm":
                    attribut = rasEgenskaper.getText();
                    delete = "DELETE FROM " + tidigareRas + " WHERE Alien_ID = " + alienid;
                    fraga = "INSERT INTO Worm VALUES (" + alienid + ", '" + attribut + "')";
                    idb.delete(delete);
                    idb.insert(fraga);
                    
                    break;
                    
                case "Boglodite":
                    attribut = rasEgenskaper.getText();
                    delete = "DELETE FROM " + tidigareRas + " WHERE Alien_ID = " + alienid;
                    fraga = "INSERT INTO Boglodite VALUES (" + alienid + ", '" + attribut + "')";
                    idb.delete(delete);
                    idb.insert(fraga);
                    
                    break;
                    
                case "Välj":
                    break;
            }
            rasEgenskaper.setText("");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        laddaAliensKnapp = new javax.swing.JButton();
        chooseAlienCbx = new javax.swing.JComboBox<>();
        alienIDField = new javax.swing.JTextField();
        registreringsdatumField = new javax.swing.JTextField();
        alienIDLabel = new javax.swing.JLabel();
        registreringsdatumLabel = new javax.swing.JLabel();
        losenordField = new javax.swing.JTextField();
        losenordLabel = new javax.swing.JLabel();
        namnField = new javax.swing.JTextField();
        namnLabel = new javax.swing.JLabel();
        telefonField = new javax.swing.JTextField();
        telefonLabel = new javax.swing.JLabel();
        platsLabel = new javax.swing.JLabel();
        ansvarigAgentLabel = new javax.swing.JLabel();
        platsCbx = new javax.swing.JComboBox<>();
        ansvarigAgentCbx = new javax.swing.JComboBox<>();
        tabortKnapp = new javax.swing.JButton();
        redigeraKnapp = new javax.swing.JButton();
        rasLabel = new javax.swing.JLabel();
        rasCbx = new javax.swing.JComboBox<>();
        rasTxt = new javax.swing.JTextField();
        rasEgenskaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Redigera Alien");

        jLabel2.setText("Välj Alien att redigera...");

        laddaAliensKnapp.setText("Ladda aliens");
        laddaAliensKnapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laddaAliensKnappActionPerformed(evt);
            }
        });

        chooseAlienCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseAlienCbxActionPerformed(evt);
            }
        });

        alienIDLabel.setText("AlienID");

        registreringsdatumLabel.setText("Registreringsdatum");

        losenordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                losenordFieldActionPerformed(evt);
            }
        });

        losenordLabel.setText("Lösenord");

        namnLabel.setText("Namn");

        telefonField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonFieldActionPerformed(evt);
            }
        });

        telefonLabel.setText("Telefon");

        platsLabel.setText("Plats");

        ansvarigAgentLabel.setText("Ansvarig agent");

        platsCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                platsCbxActionPerformed(evt);
            }
        });

        ansvarigAgentCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansvarigAgentCbxActionPerformed(evt);
            }
        });

        tabortKnapp.setText("Ta bort alien");
        tabortKnapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabortKnappActionPerformed(evt);
            }
        });

        redigeraKnapp.setText("Redigera");
        redigeraKnapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redigeraKnappActionPerformed(evt);
            }
        });

        rasLabel.setText("Ras");

        rasCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Squid", "Boglodite", "Worm" }));
        rasCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rasCbxActionPerformed(evt);
            }
        });

        rasTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rasTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(tabortKnapp)
                        .addGap(26, 26, 26)
                        .addComponent(redigeraKnapp))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(alienIDLabel)
                                    .addComponent(registreringsdatumLabel)
                                    .addComponent(losenordLabel)
                                    .addComponent(namnLabel)
                                    .addComponent(telefonLabel)
                                    .addComponent(platsLabel)
                                    .addComponent(ansvarigAgentLabel)
                                    .addComponent(rasLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(rasEgenskaper, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(telefonField)
                            .addComponent(namnField)
                            .addComponent(losenordField)
                            .addComponent(chooseAlienCbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(laddaAliensKnapp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registreringsdatumField)
                            .addComponent(alienIDField)
                            .addComponent(platsCbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ansvarigAgentCbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rasCbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rasTxt))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(laddaAliensKnapp)
                .addGap(18, 18, 18)
                .addComponent(chooseAlienCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alienIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alienIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registreringsdatumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registreringsdatumLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(losenordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(losenordLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namnLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(platsLabel)
                    .addComponent(platsCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ansvarigAgentLabel)
                    .addComponent(ansvarigAgentCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rasLabel)
                    .addComponent(rasCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rasEgenskaper, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabortKnapp)
                    .addComponent(redigeraKnapp))
                .addGap(79, 79, 79))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void laddaAliensKnappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laddaAliensKnappActionPerformed
        // TODO add your handling code here:
        laddaAliens();
        visaAlienInformation(epost);
        laddaPlatser();
        laddaAgenter();
    }//GEN-LAST:event_laddaAliensKnappActionPerformed

    private void losenordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_losenordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_losenordFieldActionPerformed

    private void telefonFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonFieldActionPerformed

    private void tabortKnappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabortKnappActionPerformed
        // TODO add your handling code here:
        String selected = (String) chooseAlienCbx.getSelectedItem();
        if (selected != null) {
            String epost = alienEpostMap.get(selected.split(" \\(")[0]);
            taBortAlien(epost);
            laddaAliens();
            uppdateraAlienInformation(epost);
        } else {
            JOptionPane.showMessageDialog(null, "Vänligen fyll i uppgifterna.");
        }
    }//GEN-LAST:event_tabortKnappActionPerformed

    private void platsCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platsCbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_platsCbxActionPerformed

    private void chooseAlienCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseAlienCbxActionPerformed
        // TODO add your handling code here:
        String selected = (String) chooseAlienCbx.getSelectedItem();
        if(selected != null) {
            String epost = alienEpostMap.get(selected.split(" \\(")[0]);
            visaAlienInformation(epost);
        } else {
            JOptionPane.showMessageDialog(null, "Vänta lite innan du hanterar nästa alien.");
        }
    }//GEN-LAST:event_chooseAlienCbxActionPerformed

    private void redigeraKnappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redigeraKnappActionPerformed
        // TODO add your handling code here:
        String selected = (String) chooseAlienCbx.getSelectedItem();
        if(selected != null & !selected.isEmpty()) {
            String epost = alienEpostMap.get(selected.split(" \\(")[0]);
            uppdateraAlienInformation(epost);
            uppdateraRas(epost);
        }
    }//GEN-LAST:event_redigeraKnappActionPerformed

    private void ansvarigAgentCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansvarigAgentCbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansvarigAgentCbxActionPerformed

    private void rasTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rasTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rasTxtActionPerformed

    private void rasCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rasCbxActionPerformed
        // TODO add your handling code here:
        rasLabel.setVisible(true);
        rasEgenskaper.setVisible(true);
        laddaRaser();
    }//GEN-LAST:event_rasCbxActionPerformed

    
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alienIDField;
    private javax.swing.JLabel alienIDLabel;
    private javax.swing.JComboBox<String> ansvarigAgentCbx;
    private javax.swing.JLabel ansvarigAgentLabel;
    private javax.swing.JComboBox<String> chooseAlienCbx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton laddaAliensKnapp;
    private javax.swing.JTextField losenordField;
    private javax.swing.JLabel losenordLabel;
    private javax.swing.JTextField namnField;
    private javax.swing.JLabel namnLabel;
    private javax.swing.JComboBox<String> platsCbx;
    private javax.swing.JLabel platsLabel;
    private javax.swing.JComboBox<String> rasCbx;
    private javax.swing.JLabel rasEgenskaper;
    private javax.swing.JLabel rasLabel;
    private javax.swing.JTextField rasTxt;
    private javax.swing.JButton redigeraKnapp;
    private javax.swing.JTextField registreringsdatumField;
    private javax.swing.JLabel registreringsdatumLabel;
    private javax.swing.JButton tabortKnapp;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonLabel;
    // End of variables declaration//GEN-END:variables
}
