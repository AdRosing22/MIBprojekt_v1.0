/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;



import javax.swing.JOptionPane;
import javax.swing.UIManager;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *Det första som öppnas upp via main metoden
 * Hanterar inmatning av epost och lösenord för att bestämma vem det är som loggar in
 * Val av agent/alien vid inloggning är väsentligt för resten av systemet
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
        new Validering(idb);
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
        jLinloggning = new javax.swing.JLabel();
        txtbEpost = new javax.swing.JTextField();
        txtbLosenord = new javax.swing.JPasswordField();
        jLepost = new javax.swing.JLabel();
        jLlosenord = new javax.swing.JLabel();
        btnLoggaIn = new javax.swing.JButton();
        JComboBox = new javax.swing.JComboBox<>();
        btnAvsluta = new javax.swing.JButton();
        bakgrundsBild = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLtitel.setBackground(new java.awt.Color(0, 0, 0));
        jLtitel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLtitel.setForeground(new java.awt.Color(255, 255, 255));
        jLtitel.setText("Välkommen till Men In Black");
        getContentPane().add(jLtitel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 280, 42));

        jLinloggning.setForeground(new java.awt.Color(255, 255, 255));
        jLinloggning.setText("Välj typ av användare:");
        getContentPane().add(jLinloggning, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 140, -1));

        txtbEpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbEpostActionPerformed(evt);
            }
        });
        getContentPane().add(txtbEpost, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 143, 150, -1));

        txtbLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbLosenordActionPerformed(evt);
            }
        });
        txtbLosenord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbLosenordKeyPressed(evt);
            }
        });
        getContentPane().add(txtbLosenord, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 187, 150, -1));

        jLepost.setForeground(new java.awt.Color(255, 255, 255));
        jLepost.setText("E-post:");
        getContentPane().add(jLepost, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 148, 62, -1));

        jLlosenord.setForeground(new java.awt.Color(255, 255, 255));
        jLlosenord.setText("Lösenord:");
        getContentPane().add(jLlosenord, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 192, 62, -1));

        btnLoggaIn.setText("Logga in");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoggaIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agent", "Alien" }));
        JComboBox.setToolTipText("");
        JComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JComboBoxKeyPressed(evt);
            }
        });
        getContentPane().add(JComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 99, 94, -1));

        btnAvsluta.setText("Avsluta");
        btnAvsluta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvslutaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAvsluta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        bakgrundsBild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bilder/46a22884bfb0164c9d70b69a5db74027.jpg"))); // NOI18N
        bakgrundsBild.setText("jLabel1");
        getContentPane().add(bakgrundsBild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtbEpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbEpostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbEpostActionPerformed

    private void txtbLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbLosenordActionPerformed

  
 
//ANVÄNDER SIG AV VALIDERINGSKLASSEN FÖR ATT KONTROLLERA LÖSENORD
    //hämtar först värdet från rullgardinsmenyn
    //kontrollerar ifall användaren har valt alien eller agent
    //1.ifall alien så kontrolleras ifall epost stämmer överens med lösenord och alienfönster öppnas
    //--det här fönstret stängs
    //2.ifall agent så kontrolleras epost mot lösenord
    //--kontroll ifall agenten har adminstatus via valideringsklassen
    //--beroende på ifall admin eller inte så öppnas antingen adminfönster eller agentfönster
    
    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
    
    kontrollAvRuta();
    String anv = txtbEpost.getText();
    String los = txtbLosenord.getText();
    
    if(Validering.isTxtFilled(anv) && Validering.isTxtFilled(los) && Validering.finnsAnvandareEpostIDB(anv)
       && Validering.kontrollLosenStammer(anv, los))
    {
        
        if(menyVal.equals("Alien"))
        {
            nyAlien = new InlogAlien(idb, anv);
            
            new AlienFonster(idb, nyAlien).setVisible(true);
        }
        else if(menyVal.equals("Agent"))
        {
            nyAgent = new InlogAgent(idb, anv);
            new InlogAlien(idb);
            if(Validering.kontrollOmAdmin(anv))
            {
                new AgentAdminFonster(idb, nyAgent).setVisible(true);
            }
            else{
                new AgentFonster(idb, nyAgent).setVisible(true);
            }   
        }
        dispose();
    }  
    }//GEN-LAST:event_btnLoggaInActionPerformed
    
    
    
    private void btnAvslutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvslutaActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.yesButtonText", "Ja");
        UIManager.put("OptionPane.noButtonText", "Nej");
        int choice = JOptionPane.showConfirmDialog(
        this, // Komponenten att centrera popup på
        "Vill du verkligen avsluta programmet?", // Meddelandetext
        "Bekräftelse", // Titel på popup
        JOptionPane.YES_NO_OPTION // Visa Ja/Nej-knappar
        );

        // Kontrollera användarens val
        if (choice == JOptionPane.YES_OPTION) {
            dispose();
        }
        
    }//GEN-LAST:event_btnAvslutaActionPerformed

    private void JComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JComboBoxKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JComboBoxKeyPressed

    private void txtbLosenordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbLosenordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnLoggaIn.doClick();
            
        }
    }//GEN-LAST:event_txtbLosenordKeyPressed

    
    
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
    private javax.swing.JLabel bakgrundsBild;
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

