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
public class SokOmradeschef extends javax.swing.JFrame {
    
    private InfDB idb;
    

    /**
     * Creates new form SokOmradeschef
     */
    public SokOmradeschef(InfDB idb) {
        initComponents();
        this.idb = idb;
        //laddar comboboxen med dem områden som finns
        laddaOmraden();
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
        txtFchef = new javax.swing.JTextArea();
        cbxOmraden = new javax.swing.JComboBox<>();
        btnSok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setText("Sök områdetschef");

        txtFchef.setColumns(20);
        txtFchef.setRows(5);
        jScrollPane1.setViewportView(txtFchef);

        cbxOmraden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxOmraden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOmradenActionPerformed(evt);
            }
        });

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
                .addGap(153, 153, 153)
                .addComponent(jLtitel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbxOmraden, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSok)
                        .addGap(152, 152, 152))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLtitel)
                .addGap(18, 18, 18)
                .addComponent(cbxOmraden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSok)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //metod för att fylla comboboxen med dem områden som finns så den inloggade
    //inte behöver söka manuellt
    private void laddaOmraden()
    {
        try{
            //sql fraga
            String fraga = "SELECT Omrades_ID, Benamning FROM Omrade";
            
            //tömmer comboboxen 
            cbxOmraden.removeAllItems();
            
            //hämtar omrades id och benamning
            ArrayList<HashMap<String, String>> omraden = idb.fetchRows(fraga);
            
            //loopar genom resultatet och hämtar ut alla hittade värden
            for(HashMap<String, String> rad : omraden)
            {
                String omrID = rad.get("Omrades_ID");
                String namn = rad.get("Benamning");
                
                //lägger till det värdet som hittas i comboboxen
                cbxOmraden.addItem(omrID+" - "+namn);
            }
            
            //gör så att sök och cbx fungerar att interagera med
            cbxOmraden.setEnabled(true);
            btnSok.setEnabled(true);
            
            
        } catch(InfException ex){
            JOptionPane.showMessageDialog(null,"Något gick fel");
            System.out.println("Internt felmeddelande: "+ex.getMessage());
        }catch (Exception e){
            System.out.println("Internt felmed:"+e);
        }
    }
    
    
    
    
    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        // TODO add your handling code here:
        
        //tömmer textrutan på tidigare sökresultat
        txtFchef.setText("");
        try{
            //hämtar det valda omradet från comboboxen
            String platsid = cbxOmraden.getSelectedItem().toString();
            //kollar så det valda alternativet inte är tomt (validering)
            if(!platsid.isEmpty()){
                //tar via substring ut första tecknet, vilket vi lagt är ID
                String id = platsid.substring(0, 1);
                //sql fraga som söker på omrades id
                String fraga ="SELECT namn, agent.agent_id, telefon, agent.epost FROM agent " +
                              "JOIN omradeschef on agent.Agent_ID = omradeschef.Agent_ID " +
                              "JOIN omrade ON omradeschef.Omrade = omrade.Omrades_ID " +
                              "WHERE omrade.Omrades_ID ="+id;
                
                //hämtar raden, eftersom en agent kan vara chef för ett område ska en rad va i resultSet
                HashMap<String, String> chef = idb.fetchRow(fraga);
                
                //validering att resultatet inte är tomt
                if(chef !=null){
                    //hämtar värden från sqlresultatet till lokala variabler
                    String agentnamn = chef.get("Namn");
                    String agentid = chef.get("Agent_ID");
                    String telefon= chef.get("Telefon");
                    String epost = chef.get("Epost");
                    
                    //skriver det i textrutan
                    txtFchef.append("Chef för området "+platsid+": \n");
                    txtFchef.append("Namn: "+agentnamn+"\n");
                    txtFchef.append("ID: "+agentid+"\n");
                    txtFchef.append("Telefon: "+telefon+"\n");
                    txtFchef.append("E-post: "+epost);
                    
                }
                //ifall ingen agent skulle vara tillagd som chef för området
                else{
                    txtFchef.append("Ingen chef registrerad i området");
                }
            }
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt fel"+ex.getMessage());
        }catch(Exception e){
            System.out.println("Fel: "+e);
        }
    }//GEN-LAST:event_btnSokActionPerformed

    private void cbxOmradenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOmradenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOmradenActionPerformed

    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSok;
    private javax.swing.JComboBox<String> cbxOmraden;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtFchef;
    // End of variables declaration//GEN-END:variables
}
