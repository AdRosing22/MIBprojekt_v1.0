/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Adam
 */
public class AndraLosenordFonster extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Creates new form AndraLosenordFonster
     */
    public AndraLosenordFonster(InfDB idb) {
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
        txtbNuvLosen = new javax.swing.JPasswordField();
        txtbNyttLosen = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBekrafta = new javax.swing.JToggleButton();
        btnTillbaka = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setText("Ändra lösenord");

        txtbNuvLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbNuvLosenActionPerformed(evt);
            }
        });

        jLabel1.setText("Nytt lösenord:");

        jLabel2.setText("Nuvarande lösenord:");

        btnBekrafta.setText("Bekräfta");
        btnBekrafta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBekraftaActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Gå tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBekrafta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtbNuvLosen)
                                    .addComponent(txtbNyttLosen, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLtitel)))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jLabel2)
                    .addContainerGap(249, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLtitel)
                .addGap(68, 68, 68)
                .addComponent(txtbNuvLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbNyttLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addComponent(btnBekrafta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new AgentFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnBekraftaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBekraftaActionPerformed
        // TODO add your handling code here:
        try{
            if(InloggningsFonster.getMenyval().equals("Agent")){
            if(Validering.kontrollOmLosenStammerAgent(inloggadAnvandare.getEpost(), txtbNuvLosen.getText()))
            {
                if(txtbNuvLosen.getText().equals(txtbNyttLosen.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Ditt nya lösenord är samma som ditt gamla, försök med något annat");
                }
                else{
                idb.update("UPDATE agent SET losenord='"+txtbNyttLosen.getText()+"' WHERE epost='"+inloggadAnvandare.getEpost()+"'");
                 JOptionPane.showMessageDialog(null, "Lösenord ändrats till:"+txtbNyttLosen.getText());
                 dispose();
                 new AgentFonster(idb).setVisible(true);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Fel nuvarande lösenord, försök igen");
            }
            }else if(InloggningsFonster.getMenyval().equals("Alien"))
            {
                if(Validering.kontrollOmLosenStammerAlien(inloggadAnvandare.getEpost(), txtbNuvLosen.getText()))
                {
                    if(txtbNuvLosen.getText().equals(txtbNyttLosen.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Ditt nya lösenord är samma som ditt gamla, försök med något annat");
                    }
                    else{
                        idb.update("UPDATE alien SET losenord='"+txtbNyttLosen.getText()+"'WHERE epost='"+inloggadAnvandare.getEpost()+"'");
                        JOptionPane.showMessageDialog(null, "Lösenord ändrats till:"+txtbNyttLosen.getText());
                        dispose();
                        new AgentFonster(idb).setVisible(true);
                    }
                }
                else{
                JOptionPane.showMessageDialog(null, "Fel nuvarande lösenord, försök igen");
                }
            }
        }catch (InfException undantag){
            JOptionPane.showMessageDialog(null, "Fel");
            System.out.println("Internt felmeddelande"+undantag);
        }catch (Exception e)
        {
            System.out.println("Internt felmeddelande"+e);
        }
    }//GEN-LAST:event_btnBekraftaActionPerformed

    private void txtbNuvLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbNuvLosenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbNuvLosenActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBekrafta;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JPasswordField txtbNuvLosen;
    private javax.swing.JPasswordField txtbNyttLosen;
    // End of variables declaration//GEN-END:variables
}
