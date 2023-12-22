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
 * Gränssnitt för att redigera info om alien eller ta bort alien
 * Olika funktioner bereoende på ifall den inloggade agenten har admin eller agentstatus
 * 
 * @author Melker & Adam
 */
public class REDIGERALIENFÖRSÖKRASFUNGERAR extends javax.swing.JFrame {

    // Instansvariabler
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
     * Skapar ett nytt RedigeraAlienInfoFonster.
     * @param idb InfDB-objekt för att kommunicera med
     */
    public REDIGERALIENFÖRSÖKRASFUNGERAR(InfDB idb) {
        initComponents();
        this.idb = idb;
        epost = InlogAgent.getEpost();
        kontrolleraAdminStatus();
        alienIDField.setEditable(false);
        txtfAttribut.setVisible(false);

        
    }
    
    // Funktion för att ladda aliens i ComboBox och visa information om den första alienen
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
            
            if (!alienlist.isEmpty()) {
                chooseAlienCbx.setSelectedIndex(0);
                visaAlienInformation(alienEpostMap.get(alienlist.get(0).get("Namn")));
            }
            
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod");
        }
    }
    
    // Funktion för att kontrollera om inloggad agent är admin
    private void kontrolleraAdminStatus() {
        boolean isAdmin = Validering.kontrollOmAdmin(InlogAgent.getEpost());
        tabortKnapp.setVisible(isAdmin);
        
    }

    // Funktion för att ladda ras i ComboBox beroende på vald ras
    private void laddaRas() {
        String ras = (String) cbxRas.getSelectedItem();
        
        switch (ras) {
            case "Squid":
                jLattribut.setText("Antal armar:");
                break;
            case "Boglodite":
                jLattribut.setText("Antal boogies:");
                break;
            case "Worm":
                jLattribut.setText("Längd i formen 0.00:");
                break;
            case "Välj":
                jLattribut.setVisible(false);
        }
    }
    
    
    
    
    private void hamtaTidigareRas(String epost)
    {
        
        try{
            String fragaAlienID = idb.fetchSingle("SELECT Alien_ID FROM alien WHERE epost = '"+epost+"'");
            int alienid = Integer.parseInt(fragaAlienID);
            String fragaWorm = idb.fetchSingle("SELECT Alien_ID FROM worm WHERE Alien_ID = "+alienid);
            String fragaSquid = idb.fetchSingle("SELECT Alien_ID FROM Squid WHERE Alien_ID = "+alienid);
            String fragaBog = idb.fetchSingle("SELECT Alien_ID FROM Boglodite WHERE Alien_ID = "+alienid);

            if (fragaSquid != null) {
                tidigareRas = "Squid";
            } else if (fragaWorm != null) {
                tidigareRas ="Worm";
            } else if (fragaBog != null) {
                tidigareRas = "Boglodite";
            }
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmed: "+ex.getMessage());
        }
    }
            
    
    // Funktion för att uppdatera ras för en alien
    private void uppdateraRas(String epost) {
        Object val = cbxRas.getSelectedItem();
        String menyVal = val.toString();
        tidigareRas ="";
        String delete = "";
        String fraga = "";

        try {
            String fragaAlienID = idb.fetchSingle("SELECT Alien_ID FROM alien WHERE epost = '"+epost+"'");
            int alienid = Integer.parseInt(fragaAlienID);
            hamtaTidigareRas(epost);
            switch (menyVal) {
                case "Squid":
                    attribut = txtfAttribut.getText();
                    delete = "DELETE FROM " + tidigareRas + " WHERE Alien_ID = " + alienid;
                    fraga = "INSERT INTO Squid VALUES (" + alienid + ", '" + attribut + "')";
                    idb.delete(delete);
                    idb.insert(fraga);
                    
                    break;
                case "Worm":
                    attribut = txtfAttribut.getText();
                    delete = "DELETE FROM " + tidigareRas + " WHERE Alien_ID = " + alienid;
                    fraga = "INSERT INTO Worm VALUES (" + alienid + ", '" + attribut + "')";
                    idb.delete(delete);
                    idb.insert(fraga);
                    
                    break;
                case "Boglodite":
                    attribut = txtfAttribut.getText();
                    delete = "DELETE FROM " + tidigareRas + " WHERE Alien_ID = " + alienid;
                    fraga = "INSERT INTO Boglodite VALUES (" + alienid + ", '" + attribut + "')";
                    idb.delete(delete);
                    idb.insert(fraga);
                    
                    break;
                case "Välj":
                    break;
            }
            txtfAttribut.setText("");

        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmed: "+ex.getMessage());
        }
    }

    // Funktion för att ta bort en alien
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

    // Funktion för att visa information om en alien
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
        }
    }

    // Funktion för att uppdatera information om en alien
    private void uppdateraAlienInformation(String epost) {
        Object val = cbxRas.getSelectedItem();
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
            if(menyVal.equals("Välj")){
            JOptionPane.showMessageDialog(null, "Aliens information har uppdaterats.");
            }else{
                JOptionPane.showMessageDialog(null,"Aliens information har ändrats, även ras från "+tidigareRas+" till "+menyVal);
            }

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

    // Funktion för att hämta Plats_ID från en platsbenämning
    private int getPlatsID(String platsNamn) throws InfException {
        String fraga = "SELECT Plats_ID FROM plats WHERE Benamning = '" + platsNamn + "'";
        String platsID = idb.fetchSingle(fraga);
        if (platsID == null) {
            throw new InfException("Platsen kunde inte hittas.");
        }
        return Integer.parseInt(platsID);
    }

    // Funktion för att hämta Agent_ID från ett agentnamn
    private int getAgentID(String agentNamn) throws InfException {
        String fraga = "SELECT Agent_ID FROM agent WHERE Namn = '" + agentNamn + "'";
        String agentID = idb.fetchSingle(fraga);
        if (agentID == null) {
            throw new InfException("Platsen kunde inte hittas.");
        }
        return Integer.parseInt(agentID);
    }

    // Funktion för att ladda platser i ComboBox
    private void laddaPlatser() {
        try {
            ArrayList<HashMap<String, String>> platslist = idb.fetchRows("SELECT Plats_ID, Benamning FROM plats");
            platsCbx.removeAllItems();
            for (HashMap<String, String> plats : platslist) {
                platsCbx.addItem(plats.get("Benamning"));
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod.");
        }
    }

    // Funktion för att ladda agenter i ComboBox
    private void laddaAgenter() {
        try {
            ArrayList<HashMap<String, String>> agentlist = idb.fetchRows("SELECT Agent_ID, Namn FROM agent");
            ansvarigAgentCbx.removeAllItems();
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
        jLras = new javax.swing.JLabel();
        cbxRas = new javax.swing.JComboBox<>();
        jLattribut = new javax.swing.JLabel();
        txtfAttribut = new javax.swing.JTextField();

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

        alienIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alienIDFieldActionPerformed(evt);
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

        jLras.setText("Ras");

        cbxRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Squid", "Worm", "Boglodite" }));
        cbxRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRasActionPerformed(evt);
            }
        });

        txtfAttribut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfAttributActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(alienIDLabel)
                            .addComponent(registreringsdatumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(losenordLabel)
                            .addComponent(namnLabel)
                            .addComponent(telefonLabel)
                            .addComponent(platsLabel)
                            .addComponent(jLras)
                            .addComponent(ansvarigAgentLabel)
                            .addComponent(jLattribut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(telefonField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namnField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(losenordField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseAlienCbx, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(laddaAliensKnapp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registreringsdatumField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alienIDField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(platsCbx, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ansvarigAgentCbx, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxRas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfAttribut, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(tabortKnapp)
                        .addGap(28, 28, 28)
                        .addComponent(redigeraKnapp))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
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
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLras)
                    .addComponent(cbxRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLattribut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtfAttribut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabortKnapp)
                    .addComponent(redigeraKnapp))
                .addGap(17, 17, 17))
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
        }
        else{
            JOptionPane.showMessageDialog(null, "Fyll i uppgifterna!");
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
        }
        else{
            JOptionPane.showMessageDialog(null,"Vänta lite innan du hanterar nästa alien");
        }
    }//GEN-LAST:event_chooseAlienCbxActionPerformed

    private void redigeraKnappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redigeraKnappActionPerformed
        // TODO add your handling code here:
        String selected = (String) chooseAlienCbx.getSelectedItem();
        if(selected != null) {
            String epost = alienEpostMap.get(selected.split(" \\(")[0]);
            uppdateraRas(epost);
            uppdateraAlienInformation(epost);
            
        }
    }//GEN-LAST:event_redigeraKnappActionPerformed

    private void txtfAttributActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfAttributActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtfAttributActionPerformed

    private void cbxRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRasActionPerformed
        // TODO add your handling code here:
        txtfAttribut.setVisible(true);
        jLattribut.setVisible(true);
        laddaRas();
    }//GEN-LAST:event_cbxRasActionPerformed

    private void alienIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alienIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alienIDFieldActionPerformed

    
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alienIDField;
    private javax.swing.JLabel alienIDLabel;
    private javax.swing.JComboBox<String> ansvarigAgentCbx;
    private javax.swing.JLabel ansvarigAgentLabel;
    private javax.swing.JComboBox<String> cbxRas;
    private javax.swing.JComboBox<String> chooseAlienCbx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLattribut;
    private javax.swing.JLabel jLras;
    private javax.swing.JButton laddaAliensKnapp;
    private javax.swing.JTextField losenordField;
    private javax.swing.JLabel losenordLabel;
    private javax.swing.JTextField namnField;
    private javax.swing.JLabel namnLabel;
    private javax.swing.JComboBox<String> platsCbx;
    private javax.swing.JLabel platsLabel;
    private javax.swing.JButton redigeraKnapp;
    private javax.swing.JTextField registreringsdatumField;
    private javax.swing.JLabel registreringsdatumLabel;
    private javax.swing.JButton tabortKnapp;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonLabel;
    private javax.swing.JTextField txtfAttribut;
    // End of variables declaration//GEN-END:variables
}
