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
public class RedigeraAlien2 extends javax.swing.JFrame {

    
    private InfDB idb;
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
    private String attribut;
    private String tidigareRas;
    private String nuvAlienid;
 
    /**
     * Creates new form RedigeraAlien2
     * @param idb
     */
    public RedigeraAlien2(InfDB idb) {
        initComponents();
        this.idb = idb;
        epost = InlogAgent.getEpost();
        attributLabel.setVisible(false);
        laddaAlien();
    }
    
    
    private void laddaAlien() {
        try {
            ArrayList<HashMap<String, String>> alienlist = idb.fetchRows("SELECT Epost, Namn FROM alien");
            alienEpostMap = new HashMap<>();
            alienCbx.removeAllItems();
            
            for (HashMap<String, String> alien : alienlist) {
                String epost = alien.get("Epost");
                String namn = alien.get("Namn");
                alienCbx.addItem(namn + " (" + epost + ")");
                alienEpostMap.put(namn, epost);
            }
            if(!alienlist.isEmpty()) {
                alienCbx.setSelectedIndex(0);
                visaAlienInformation(alienEpostMap.get(alienlist.get(0).get("Namn")));
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel.");
        }
    }
    
    private void laddaRas() {
        String ras = (String) rasCbx.getSelectedItem();
        
        switch (ras) {
            case "Squid":
                attributLabel.setText("Antal armar:");
                break;
            case "Boglodite":
                attributLabel.setText("Antal boogies");
                break;
            case "Worm":
                attributLabel.setText("Längd i formen 0.00:");
                break;
            case "Välj":
                attributLabel.setVisible(false);
        }
    }
    
    private void hamtaTidigareRas(String epost) {
        try {
            String fragaAlienID = idb.fetchSingle("SELECT Alien_ID FROM alien WHERE Epost = '"+epost +"'");
            int alienid = Integer.parseInt(fragaAlienID);
            String fragaWorm = idb.fetchSingle("SELECT Alien_ID FROM worm WHERE Alien_ID = "+alienid);
            String fragaSquid = idb.fetchSingle("SELECT Alien_ID FROM squid WHERE Alien_ID = "+alienid);
            String fragaBog = idb.fetchSingle("SELECT Alien_ID FROM squid WHERE Alien_ID = "+alienid);
            
            if (fragaSquid != null) { 
                tidigareRas = "Squid";
            } else if (fragaWorm != null) {
                tidigareRas = "Worm";
            } else if (fragaBog != null) {
                tidigareRas = "Boglodite";
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
        }
    }
    
    
    private void uppdateraRas(String epost) {
        Object val = rasCbx.getSelectedItem();
        String menyVal = val.toString();
        tidigareRas = "";
                
        
        try {
            String fragaAlienID = idb.fetchSingle("SELECT Alien_ID FROM alien WHERE Epost = '"+epost+"'");
            int alienid = Integer.parseInt(fragaAlienID);
            String attribut = attributField.getText();
            hamtaTidigareRas(epost);
            if(!tidigareRas.equals("Squid") && !tidigareRas.isEmpty()) {
                String delete = "DELETE FROM " + tidigareRas + " WHERE Alien_ID = " + alienid;
                idb.delete(delete);
            }
            
            String checkSquid = idb.fetchSingle("SELECT Alien_ID FROM squid WHERE Alien_ID = " + alienid);
            if(checkSquid != null) {
                String fragaUpdate = "UPDATE squid SET Antal_Armar = '" + attribut + "' WHERE Alien_ID = " + alienid;
                idb.update(fragaUpdate);
            } else {
                String fragaInsert = "INSERT INTO squid (Alien_ID, Antal_Armar) VALUES (" + alienid + ", '" + attribut + "')";
                idb.insert(fragaInsert);
            }
            if(!tidigareRas.equals("Squid") && !tidigareRas.isEmpty()) {
                String delete = "DELETE FROM " + tidigareRas + " WHERE Alien_ID = " + alienid;
                idb.delete(delete);
            }
            
            String checkWorm = idb.fetchSingle("SELECT Alien_ID FROM worm WHERE Alien_ID = " + alienid);
            if(checkWorm != null) {
                String fragaUpdate = "UPDATE worm SET Langd = '" + attribut + "' WHERE Alien_ID = " + alienid;
                idb.update(fragaUpdate);
            } else {
                String fragaInsert = "INSERT INTO worm (Alien_ID, Langd) VALUES (" + alienid + ", '" + attribut + "')";
                idb.insert(fragaInsert);
            }
            
            
            String checkBog = idb.fetchSingle("SELECT Alien_ID FROM boglodite WHERE Alien_ID = " + alienid);
            if(checkBog != null) {
                String fragaUpdate = "UPDATE boglodite SET Antal_Boogies = '" + attribut + "' WHERE Alien_ID = " + alienid;
                idb.update(fragaUpdate);
            } else {
                String fragaInsert = "INSERT INTO boglodite (Alien_ID, Antal_Boogies) VALUES (" + alienid + ", '" + attribut + "')";
                idb.insert(fragaInsert);
            }
            
            attributField.setText("");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
    }
    
    private void visaAlienInformation(String epost) {
        
                regDatumField.setText("");
                losenordField.setText("");
                telefonField.setText("");
                
                try {
            HashMap<String, String> alienInfo = idb.fetchRow("SELECT * FROM alien WHERE Epost = '" + epost + "'");
            if (alienInfo != null) {
                regDatumField.setText(alienInfo.get("Registreringsdatum"));
                losenordField.setText(alienInfo.get("Losenord"));
                namnField.setText(alienInfo.get("Namn"));
                telefonField.setText(alienInfo.get("Telefon"));
                
                
                
                
                
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
            e.printStackTrace();
        }
    }
    
    private void uppdateraAlienInformation(String epost) {
        Object val = rasCbx.getSelectedItem();
        String menyVal = val.toString();
        try {
            nyttNamn = namnField.getText();
            nyttLosenord = losenordField.getText();
            nyRegistreringsdatum = regDatumField.getText();
            nyttTelefon = telefonField.getText();
            nyPlats = (String) platsCbx.getSelectedItem();
            nyAgent = (String) ansvarigAgentCbx.getSelectedItem();
            
            platsID = getPlatsID(nyPlats);
            agentID = getAgentID(nyAgent);
            
            String fraga = "UPDATE alien SET Namn = '" + nyttNamn + "', Losenord = '" + nyttLosenord + "', Registreringsdatum = '" + nyRegistreringsdatum + "', Telefon = '" + nyttTelefon + "', Plats = " + platsID + ", Ansvarig_Agent = " + agentID + " WHERE Epost = '" + epost + "'";
            
            idb.update(fraga);
            if(menyVal.equals("Välj")) {
                JOptionPane.showMessageDialog(null, "Aliens information har uppdaterats.");                       
            } else {
                JOptionPane.showMessageDialog(null, "Aliens information har ändrats, även ras från "+tidigareRas+" till "+menyVal);
            }
            regDatumField.setText("");
            losenordField.setText("");
            namnField.setText("");
            telefonField.setText("");
            platsCbx.setSelectedIndex(0);
            ansvarigAgentCbx.setSelectedIndex(0);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
        }
    }
    
    private int getPlatsID(String platsNamn) throws InfException {
        String fraga = "SELECT Plats_ID FROM plats WHERE Benamning = '" + platsNamn + "'";
        String platsID = idb.fetchSingle(fraga);
        if(platsID == null) {
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
            platsCbx.addItem("Välj plats...");
            for (HashMap<String, String> plats : platslist) {
                platsCbx.addItem(plats.get("Benamning"));
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
        }
    }
    
    private void laddaAgenter() {
        try {
            ArrayList<HashMap<String, String>> agentlist = idb.fetchRows("SELECT Agent_ID, Namn FROM agent");
            ansvarigAgentCbx.removeAllItems();
            ansvarigAgentCbx.addItem("Välj agent...");
            for (HashMap<String, String> agent : agentlist) {
                ansvarigAgentCbx.addItem(agent.get("Namn"));
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
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

        redigeraAlienLabel = new javax.swing.JLabel();
        btnLaddaAlien = new javax.swing.JToggleButton();
        alienCbx = new javax.swing.JComboBox<>();
        regDatumField = new javax.swing.JTextField();
        losenordField = new javax.swing.JTextField();
        namnField = new javax.swing.JTextField();
        telefonField = new javax.swing.JTextField();
        platsCbx = new javax.swing.JComboBox<>();
        ansvarigAgentCbx = new javax.swing.JComboBox<>();
        rasCbx = new javax.swing.JComboBox<>();
        attributField = new javax.swing.JTextField();
        btnRedigera = new javax.swing.JToggleButton();
        regLabel = new javax.swing.JLabel();
        losenordLabel = new javax.swing.JLabel();
        namnLabel = new javax.swing.JLabel();
        telefonLabel = new javax.swing.JLabel();
        platsLabel = new javax.swing.JLabel();
        ansvarigAgentLabel = new javax.swing.JLabel();
        rasLabel = new javax.swing.JLabel();
        attributLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        redigeraAlienLabel.setText("Redigera alien");

        btnLaddaAlien.setText("Ladda alien");
        btnLaddaAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaddaAlienActionPerformed(evt);
            }
        });

        alienCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alienCbxActionPerformed(evt);
            }
        });

        rasCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Worm", "Squid", "Boglodite" }));
        rasCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rasCbxActionPerformed(evt);
            }
        });

        btnRedigera.setText("Redigera");
        btnRedigera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraActionPerformed(evt);
            }
        });

        regLabel.setText("Registreringsdatum");

        losenordLabel.setText("Lösenord");

        namnLabel.setText("Namn");

        telefonLabel.setText("Telefon");

        platsLabel.setText("Plats");

        ansvarigAgentLabel.setText("Ansvarig Agent");

        rasLabel.setText("Ras");

        attributLabel.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(redigeraAlienLabel)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(alienCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLaddaAlien)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(regLabel)
                                    .addComponent(losenordLabel)
                                    .addComponent(namnLabel)
                                    .addComponent(telefonLabel)
                                    .addComponent(platsLabel)
                                    .addComponent(ansvarigAgentLabel)
                                    .addComponent(rasLabel)
                                    .addComponent(attributLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnRedigera))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(regDatumField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(losenordField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(namnField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(platsCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ansvarigAgentCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rasCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(attributField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(147, 147, 147))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(redigeraAlienLabel)
                .addGap(18, 18, 18)
                .addComponent(btnLaddaAlien)
                .addGap(18, 18, 18)
                .addComponent(alienCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regDatumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regLabel))
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
                    .addComponent(platsCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(platsLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ansvarigAgentCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ansvarigAgentLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rasCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rasLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attributField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attributLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRedigera)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLaddaAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaddaAlienActionPerformed
        // TODO add your handling code here:
        String selected = (String) alienCbx.getSelectedItem();
        if (selected != null && !selected.isEmpty()) {
            String epost = alienEpostMap.get(selected.split(" \\(")[0]);
            JOptionPane.showMessageDialog(null, "Laddar information för: " + epost);
            visaAlienInformation(epost);
        } else {
            JOptionPane.showMessageDialog(null, "Ingen alien är vald.");
    }//GEN-LAST:event_btnLaddaAlienActionPerformed
    }
    
    private void btnRedigeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraActionPerformed
        // TODO add your handling code here:
        String selected = (String) alienCbx.getSelectedItem();
        if(selected != null) {
            String epost = alienEpostMap.get(selected.split(" \\(")[0]);
            uppdateraRas(epost);
            uppdateraAlienInformation(epost);
        }
    }//GEN-LAST:event_btnRedigeraActionPerformed

    private void alienCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alienCbxActionPerformed
        // TODO add your handling code here:
        String selected = (String) alienCbx.getSelectedItem();
        if (selected != null) {
            String epost = alienEpostMap.get(selected.split(" \\(")[0]);
            visaAlienInformation(epost);
        } else {
            JOptionPane.showMessageDialog(null,"Vänta lite innan du hanterar nästa alien");
        }
    }//GEN-LAST:event_alienCbxActionPerformed

    private void rasCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rasCbxActionPerformed
        // TODO add your handling code here:
        rasLabel.setVisible(true);
        attributField.setVisible(true);
        laddaRas();
    }//GEN-LAST:event_rasCbxActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alienCbx;
    private javax.swing.JComboBox<String> ansvarigAgentCbx;
    private javax.swing.JLabel ansvarigAgentLabel;
    private javax.swing.JTextField attributField;
    private javax.swing.JLabel attributLabel;
    private javax.swing.JToggleButton btnLaddaAlien;
    private javax.swing.JToggleButton btnRedigera;
    private javax.swing.JTextField losenordField;
    private javax.swing.JLabel losenordLabel;
    private javax.swing.JTextField namnField;
    private javax.swing.JLabel namnLabel;
    private javax.swing.JComboBox<String> platsCbx;
    private javax.swing.JLabel platsLabel;
    private javax.swing.JComboBox<String> rasCbx;
    private javax.swing.JLabel rasLabel;
    private javax.swing.JLabel redigeraAlienLabel;
    private javax.swing.JTextField regDatumField;
    private javax.swing.JLabel regLabel;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonLabel;
    // End of variables declaration//GEN-END:variables
}
