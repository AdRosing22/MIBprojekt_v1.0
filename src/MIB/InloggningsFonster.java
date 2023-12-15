/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;



import oru.inf.InfDB;
import oru.inf.InfException;

//------------FUNDERING-----------------------//adam
//Fundering ifall man ska skicka med InlogAgent hela vägen till alla fönster?

/*ex.
field:
private InlogAgent logAnv;
constructor:
this.logAnv = logAnv;
metod:
logAnv = new InlogAgent(idb, txtbEpost.getText());
new AgentFonster(idb, logAnv)
*/

//men borde fungera att inte göra det eftersom det initialiseras vid inloggningen
//Vette fan hur man ska göra ifall det blir förhinder någonstans? Det som inte går att göra
//är att logga ut och logga in på nytt med annat konto utan att stänga programmet och köra det på nytt
//-----------------------------------//adam


/**
 *
 * @author Adam
 */
public class InloggningsFonster extends javax.swing.JFrame {
    
    private InfDB idb;
    private static String menyVal;
    private boolean epostFinns;
    private String svar;
    private InlogAgent nyAgent;
    private InlogAlien nyAlien;
    
    
    

    /**
     * Creates new form InloggningsFonster
     */
    public InloggningsFonster(InfDB idb) {
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
        jLinloggning = new javax.swing.JLabel();
        txtbEpost = new javax.swing.JTextField();
        txtbLosenord = new javax.swing.JPasswordField();
        jLepost = new javax.swing.JLabel();
        jLlosenord = new javax.swing.JLabel();
        btnLoggaIn = new javax.swing.JButton();
        JComboBox = new javax.swing.JComboBox<>();
        btnAvsluta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLtitel.setText("Välkommen till Men In Black");

        jLinloggning.setText("Välj typ av användare:");

        txtbEpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbEpostActionPerformed(evt);
            }
        });

        txtbLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbLosenordActionPerformed(evt);
            }
        });

        jLepost.setText("E-post:");

        jLlosenord.setText("Lösenord:");

        btnLoggaIn.setText("Logga in");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });

        JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agent", "Alien" }));
        JComboBox.setToolTipText("");

        btnAvsluta.setText("Avsluta");
        btnAvsluta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvslutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(jLtitel)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLepost, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtbEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLinloggning)
                        .addGap(18, 18, 18)
                        .addComponent(JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLlosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtbLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoggaIn)
                .addGap(198, 198, 198))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAvsluta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLtitel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLinloggning)
                    .addComponent(JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLepost))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLlosenord))
                .addGap(34, 34, 34)
                .addComponent(btnLoggaIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnAvsluta)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbEpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbEpostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbEpostActionPerformed

    private void txtbLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbLosenordActionPerformed

        //hämtar först värdet från rullgardinsmenyn
    //kontrollerar ifall användaren har valt alien eller agent
    //1.ifall alien så kontrolleras ifall epost stämmer överens med lösenord och alienfönster öppnas
    //--det här fönstret stängs
    //2.ifall agent så kontrolleras epost mot lösenord
    //--kontroll ifall agenten har adminstatus via valideringsklassen
    //--beroende på ifall admin eller inte så öppnas antingen adminfönster eller agentfönster
    
    private void skapaAnvandareOchOppnaFonster()
    {
        String anv = txtbEpost.getText();
        
        if(menyVal.equals("Alien"))
        {
            nyAlien = new InlogAlien(idb, anv);
            nyAlien.hamtaInfoOmAlien();;
            new AlienFonster(idb, nyAlien).setVisible(true);
        }
        else if(menyVal.equals("Agent"))
        {
            nyAgent = new InlogAgent(idb, anv);
            new InlogAlien(idb);
            InlogAgent.hamtaInfoOmAgent();
            if(Validering.kontrollOmAdmin(anv))
            {
                new AgentAdminFonster(idb, nyAgent).setVisible(true);
            }
            else{
                new AgentFonster(idb, nyAgent).setVisible(true);
            }
            
            //hej
        }
        dispose();
    }
//ANVÄNDER SIG AV VALIDERINGSKLASSEN FÖR ATT KONTROLLERA LÖSENORD
    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
    
    kontrollAvRuta();
    String anv = txtbEpost.getText();
    String los = txtbLosenord.getText();
    
    if(Validering.kontrollLosenStammer(anv, los))
    {
        skapaAnvandareOchOppnaFonster();
    }
        
    }//GEN-LAST:event_btnLoggaInActionPerformed

    
    
    private void btnAvslutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvslutaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnAvslutaActionPerformed

    
    
    //hämtar val av inloggningssätt från rullmenyn och lagrar i variabeln menyVal.
private void kontrollAvRuta(){
    menyVal = JComboBox.getSelectedItem().toString();
}

public static String getMenyval()
{
    return menyVal;
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBox;
    private javax.swing.JButton btnAvsluta;
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JLabel jLepost;
    private javax.swing.JLabel jLinloggning;
    private javax.swing.JLabel jLlosenord;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JTextField txtbEpost;
    private javax.swing.JPasswordField txtbLosenord;
    // End of variables declaration//GEN-END:variables




}

