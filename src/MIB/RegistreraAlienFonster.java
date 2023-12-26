/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;


import java.time.LocalDate;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *klass för att lägga till alien i databasen
 * @author adamrosing & Melker
 */
public class RegistreraAlienFonster extends javax.swing.JFrame {
    
    private InfDB idb;
    private HashMap<String, Integer> platsIdMap = new HashMap<>(); 
    private int alienid;
    private int id;
    private String epost;
    private String namn;
    private String losenord;
    private String valPlats;
    private String telefon;
    private String registreringsdatum;
    private Integer platsId;
    private int ansvarigAgent;
    private double regDatum;
    private int rasValINT;
    private double rasValDouble;
    private String dagensdatum;
    private String ras;

    /**
     * Creates new form RegistreraAlienFonster
     */
    public RegistreraAlienFonster(InfDB idb) {
        initComponents();
        this.idb = idb;
        
        //laddar platser och alla agenter 
        laddaPlatser();
        laddaAgenter();
        
        //genererar nytt id för alien
        genereraAlienID();
        
        //sätter reg datum till dagensdatum och kan inte ändras
        registreringsdatumField.setText(dagensDatum());
        registreringsdatumField.setEditable(false);
        
        
        
    }
    
    //metod för att generera dagens datum
   private String dagensDatum()
    {
        String datum = LocalDate.now().toString();
        String ar = datum.substring(0, 4);
        String manad = datum.substring(5, 7);
        String dag = datum.substring(8, 10);
        System.out.println(ar + manad + dag);
        dagensdatum = ar + manad + dag;
        return dagensdatum;
    }

    //Ladda lista på tillgängliga platser så att man i sin tur kan välja plats
    private void laddaPlatser() {
        try {
            ArrayList<HashMap<String,String>> allaPlatser = idb.fetchRows("SELECT Plats_ID, Benamning FROM plats");
            platsCbx.removeAllItems();
            platsIdMap.clear();
            for (HashMap<String, String> plats : allaPlatser) {
                String id = plats.get("Plats_ID");
                String namn = plats.get("Benamning");
                
                platsIdMap.put(namn, Integer.parseInt(id));
                platsCbx.addItem(namn);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något blev fel.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Något blev fel");
        }
    }
    
    //Ladda lista på tillgängliga agenter så att man kan i sin tur välja ansvarig agent
    private void laddaAgenter() {
        try {
            ArrayList<String> allaAgenter = idb.fetchColumn("SELECT Namn FROM agent");
            ansvarigAgentCbx.removeAllItems();
            for (String agent : allaAgenter) {
                ansvarigAgentCbx.addItem(agent);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Något blev fel");
        }
    }
    
    
    //generarar nytt AlienID utifrån senast tillagdas id-värde
    private void genereraAlienID()
    {
        try{
            String fragaID = idb.getAutoIncrement("alien", "Alien_ID");
            int hamtatID= Integer.parseInt(fragaID);
            System.out.println(hamtatID);
            alienid = hamtatID;
        }catch (InfException ex){
            JOptionPane.showMessageDialog(null,"Något gick fel");
            System.out.println(ex.getMessage());
        }
        
       
    }
    
    //hämta id via namn för agent, eftersom det är id som lagras för att visa ansvarig agent
    private int getAgentIDAnsvarigAgent(String namn)
    {
        try{
            //sql fråga för att hämta id på agent via parametern
            String fraga = "SELECT Agent_ID FROM agent WHERE namn='"+namn+"'";
            //hämta ur databasen
            String svar = idb.fetchSingle(fraga);
            //omvanlda svaret till int från string som fetchSingle returnerar
            id = Integer.parseInt(svar);
        
        }catch(InfException ex)
        {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande: "+ex.getMessage());
        }
        return id;
    }
    
    //metod för att hantera rullmenyn för ras
    private void registreraRas(){
        //lokal variabel för att korta ner koden
        String ras = (String) cbxRas.getSelectedItem();
        
        //kontroll för att säkerställa att frågan ska synas när den ska synas
        if(ras == null || ras.equals("Välj")) {
            jLattribut.setVisible(false);
            txtbRasAttribut.setVisible(false);
            return;
        } else {
            jLattribut.setVisible(true);
            txtbRasAttribut.setVisible(true);
        }
        
        //switch som bestämmer vilken beskrivande text som ska visas bredvid inmatningsfältet
        switch(ras){
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
                break;
        } 
        
    }
    
    
    //metod för att registrera värden i databasen för ras
    //uppdelat int och double eftersom längd i worm lagras i double
    private void registreraRasIdb(){
        //lokala varibaler för att korta koden och göra mer läsbar
        ras = cbxRas.getSelectedItem().toString();
        String txtSvar = txtbRasAttribut.getText();
        
        //sql fråga
        String fraga = "INSERT INTO "+ras+" VALUES ("+alienid+",";
        
        try{
            //hårdkodat så ifall Squid eller Boglodite är valt:
            if(ras == null || ras.equals("Välj")){
                 JOptionPane.showMessageDialog(null, "Du valde inte någon ras för den nya alien, för att lägga till det nu i efterhand kan du använda dig av 'redigera alien' funktionen");
            }else{
                if(txtSvar.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Du måste fylla i ras attributet för att rasen ska registreras!");
                }else{
            
                    //hårdkodat så ifall Squid eller Boglodite är valt:
                    if(ras.equals("Squid") || ras.equals("Boglodite")){
                        //svaret i txtrutan omvandlas till int
                        rasValINT = Integer.parseInt(txtSvar);
                        //kompletterar frågan med rasValINT variabeln
                        String sqlfraga = fraga+rasValINT+")";
                        //kör fråga mot databasen
                        idb.insert(sqlfraga);
                    }
                    else if(ras.equals("Worm")){
                        rasValDouble = Double.parseDouble(txtSvar);
                        String sqlfraga = fraga+rasValDouble+")";
                        idb.insert(sqlfraga);
                    }
                }
            }
        }
        catch(InfException ex){
            JOptionPane.showMessageDialog(null,"Något gick fel");
            System.out.println("Internt felmeddelande: "+ex.getMessage());
        }
    }
    
 
    //metoden som registrerar alien info i databasen
    private void registreraNyAlien() {
        
        try {
            //hämtar alla ifyllda textfält
            epost = epostField.getText();
            namn = txtbNamn.getText();
            losenord = losenordField.getText();
            valPlats = platsCbx.getSelectedItem().toString();
            telefon = telefonField.getText();
            
            //hämtar vald ansvarig agent från cboxen
            ansvarigAgent = getAgentIDAnsvarigAgent(ansvarigAgentCbx.getSelectedItem().toString());
            registreringsdatum = registreringsdatumField.getText();
            regDatum = Double.parseDouble(registreringsdatum);
            platsId = platsIdMap.get(valPlats);
            
            //ifall obligatoriska* textrutorna är ifyllda
            if(Validering.isTxtFilled(epost)&&Validering.isTxtFilled(losenord)&&Validering.isTxtFilled(valPlats)&& Validering.isTxtFilled(registreringsdatum)){
                
                //ifall eposten redan finns registrerad under varken agent eller alien
                if(!Validering.epostKontrollVidreg(epost) ){
                    JOptionPane.showMessageDialog(null,"E-posten är redan registrerad i databasen, ange en ny och unik epost för den nya alien");
                    
                 //ifall resternade textrutor är fyllda och epost innehåller @ och bokstav, och namn innehåller bokstav och lösenord inte längre än 6 tecken   
                }else if(Validering.isTxtFilled(registreringsdatumField.getText()) && Validering.isTxtFilled(losenordField.getText()) && Validering.godkanndLosenLangd(losenord) && Validering.isEpostTrustable(epost) && Validering.containsAlphabet(epost) && Validering.containsAlphabet(namn)) {
                    
                    //validering så att telefonnumret enbart innehåller siffror
                    String[] TEL = telefon.split("-");
                    String nr = TEL[0]+TEL[1];
                    if(Validering.containsOnlyNumber(nr)){
                        String fraga =  "INSERT INTO Alien VALUES ("+alienid +","+regDatum+",'"+epost+"','"+losenord+"','"+namn+"','"+telefon+"',"+platsId+","+ansvarigAgent+")";
                        idb.insert(fraga);
                        registreraRasIdb();
                
                        JOptionPane.showMessageDialog(null, "En ny alien har registrerats.");
                
                        epostField.setText("");
                        losenordField.setText("");
                        txtbNamn.setText("");
                        platsCbx.setSelectedIndex(0);
                        telefonField.setText("555-");
                        ansvarigAgentCbx.setSelectedIndex(0);
                        registreringsdatumField.setText(dagensDatum());
                        txtbRasAttribut.setText("");
                        registreraRas(); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Telefonnumret får inte innehålla bokstäver");
                    }
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod");
            System.out.println("Internt felmeddelande" + e.getMessage());
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

        registreraNyAlienText = new javax.swing.JLabel();
        epostText = new javax.swing.JLabel();
        losenordText = new javax.swing.JLabel();
        platsText = new javax.swing.JLabel();
        telefonText = new javax.swing.JLabel();
        ansvarigAgentText = new javax.swing.JLabel();
        registreringsdatumText = new javax.swing.JLabel();
        losenordField = new javax.swing.JTextField();
        epostField = new javax.swing.JTextField();
        telefonField = new javax.swing.JTextField();
        registreringsdatumField = new javax.swing.JTextField();
        registreraKnapp = new javax.swing.JToggleButton();
        platsCbx = new javax.swing.JComboBox<>();
        ansvarigAgentCbx = new javax.swing.JComboBox<>();
        registreringsdatumText1 = new javax.swing.JLabel();
        cbxRas = new javax.swing.JComboBox<>();
        jLattribut = new javax.swing.JLabel();
        txtbRasAttribut = new javax.swing.JTextField();
        txtbNamn = new javax.swing.JTextField();
        jLnamn = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registreraNyAlienText.setText("Registrera ny alien");

        epostText.setText("E-post:*");

        losenordText.setText("Lösenord:*");

        platsText.setText("Plats:*");

        telefonText.setText("Telefon:");

        ansvarigAgentText.setText("Ansvarig agent:*");

        registreringsdatumText.setText("Registreringsdatum:*");

        losenordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                losenordFieldActionPerformed(evt);
            }
        });

        epostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epostFieldActionPerformed(evt);
            }
        });

        telefonField.setText("555-");
        telefonField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonFieldActionPerformed(evt);
            }
        });

        registreringsdatumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registreringsdatumFieldActionPerformed(evt);
            }
        });

        registreraKnapp.setText("Registrera");
        registreraKnapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registreraKnappActionPerformed(evt);
            }
        });

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

        registreringsdatumText1.setText("Ras:");

        cbxRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj", "Squid", "Boglodite", "Worm", " " }));
        cbxRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRasActionPerformed(evt);
            }
        });

        txtbRasAttribut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbRasAttributActionPerformed(evt);
            }
        });

        txtbNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbNamnActionPerformed(evt);
            }
        });

        jLnamn.setText("Namn:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registreraNyAlienText, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(losenordText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(losenordField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(epostText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(epostField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefonText)
                                    .addComponent(platsText)
                                    .addComponent(ansvarigAgentText))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ansvarigAgentCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(platsCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLnamn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtbNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(registreringsdatumText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(registreringsdatumText1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLattribut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registreraKnapp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(registreringsdatumField, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                            .addComponent(cbxRas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txtbRasAttribut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(registreraNyAlienText)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(epostText)
                    .addComponent(epostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtbNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(losenordText)
                            .addComponent(losenordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(platsText)
                            .addComponent(platsCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefonText)
                            .addComponent(telefonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ansvarigAgentText)
                            .addComponent(ansvarigAgentCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registreringsdatumText)
                            .addComponent(registreringsdatumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLnamn))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registreringsdatumText1)
                    .addComponent(cbxRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLattribut, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbRasAttribut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(registreraKnapp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTillbaka)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void losenordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_losenordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_losenordFieldActionPerformed

    private void epostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_epostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_epostFieldActionPerformed

    private void telefonFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonFieldActionPerformed

    private void registreringsdatumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registreringsdatumFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_registreringsdatumFieldActionPerformed

    private void registreraKnappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registreraKnappActionPerformed
        registreraNyAlien();
        genereraAlienID();
    }//GEN-LAST:event_registreraKnappActionPerformed

    private void ansvarigAgentCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansvarigAgentCbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansvarigAgentCbxActionPerformed

    private void cbxRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRasActionPerformed
        registreraRas();
        

    }//GEN-LAST:event_cbxRasActionPerformed

    private void txtbRasAttributActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbRasAttributActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbRasAttributActionPerformed

    private void platsCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platsCbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_platsCbxActionPerformed

    private void txtbNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbNamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbNamnActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new HanteraAliensFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ansvarigAgentCbx;
    private javax.swing.JLabel ansvarigAgentText;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JComboBox<String> cbxRas;
    private javax.swing.JTextField epostField;
    private javax.swing.JLabel epostText;
    private javax.swing.JLabel jLattribut;
    private javax.swing.JLabel jLnamn;
    private javax.swing.JTextField losenordField;
    private javax.swing.JLabel losenordText;
    private javax.swing.JComboBox<String> platsCbx;
    private javax.swing.JLabel platsText;
    private javax.swing.JToggleButton registreraKnapp;
    private javax.swing.JLabel registreraNyAlienText;
    private javax.swing.JTextField registreringsdatumField;
    private javax.swing.JLabel registreringsdatumText;
    private javax.swing.JLabel registreringsdatumText1;
    private javax.swing.JTextField telefonField;
    private javax.swing.JLabel telefonText;
    private javax.swing.JTextField txtbNamn;
    private javax.swing.JTextField txtbRasAttribut;
    // End of variables declaration//GEN-END:variables
}
