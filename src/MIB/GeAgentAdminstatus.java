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
 * @author alvin & adam
 */
public class GeAgentAdminstatus extends javax.swing.JFrame {
    
    private InfDB idb;

    /**
     * Creates new form GeAgentAdminstatus
     */
    public GeAgentAdminstatus(InfDB idb) {
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
        jLAngeEpost = new javax.swing.JLabel();
        jLinformation = new javax.swing.JLabel();
        txtbEpost = new javax.swing.JTextField();
        btnBekrafta = new javax.swing.JToggleButton();
        btnTillbaka = new javax.swing.JToggleButton();
        jLbekraftning = new javax.swing.JLabel();
        jLerror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLtitel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLtitel.setText("Ge annan agent administratörsstatus");

        jLAngeEpost.setText("Ange agentens e-post:");

        jLinformation.setText("Vilken agent vill du ge administratörsstatus?");

        btnBekrafta.setText("Bekräfta");
        btnBekrafta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBekraftaActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        jLbekraftning.setForeground(new java.awt.Color(0, 255, 0));
        jLbekraftning.setText("Lyckades!");

        jLerror.setForeground(new java.awt.Color(255, 0, 0));
        jLerror.setText("Något gick fel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLinformation)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBekrafta)
                            .addComponent(jLAngeEpost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLtitel)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLbekraftning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLerror, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addGap(141, 141, 141))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLtitel)
                .addGap(76, 76, 76)
                .addComponent(jLinformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAngeEpost)
                    .addComponent(txtbEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbekraftning, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLerror, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBekrafta)
                    .addComponent(btnTillbaka))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBekraftaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBekraftaActionPerformed
        //läs txtbEpost
        String epost = txtbEpost.getText();
        txtbEpost.setText("");
        jLbekraftning.setVisible(false);
        jLerror.setVisible(false);
        
        try {
        
            String fraga = "UPDATE Agent SET Administrator = J WHERE epost ='"+epost+"'";
        
            if(Validering.isTxtFilled(epost) && Validering.finnsAnvandareEpostIDB(epost)){
                idb.update(fraga);
                jLbekraftning.setVisible(true);
                JOptionPane.showMessageDialog(null,"Användare med e-post: "+epost+" är nu administratör");
            }
            else{
                jLerror.setVisible(true);
            }
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null,"Något gick fel");
            System.out.println(ex.getMessage());
        }
        //VALIDERA?? kolla om epost är giltig
        
    }//GEN-LAST:event_btnBekraftaActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        //gå tillbaka till AgentAdminFonster
        new AgentAdminFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBekrafta;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JLabel jLAngeEpost;
    private javax.swing.JLabel jLbekraftning;
    private javax.swing.JLabel jLerror;
    private javax.swing.JLabel jLinformation;
    private javax.swing.JLabel jLtitel;
    private javax.swing.JTextField txtbEpost;
    // End of variables declaration//GEN-END:variables
}
