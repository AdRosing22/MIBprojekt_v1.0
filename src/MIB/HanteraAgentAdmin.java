/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MIB;

import oru.inf.InfDB;

/**
 *
 * @author adamrosing
 */
public class HanteraAgentAdmin extends javax.swing.JFrame {

    private InfDB idb;
    /**
     * Creates new form HanteraAgentAdmin
     */
    public HanteraAgentAdmin(InfDB idb) {
        initComponents();
        setLocationRelativeTo(null);
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

        btnAdmin = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JToggleButton();
        jLtitel = new javax.swing.JLabel();
        btnRedigeraAgent = new javax.swing.JButton();
        btnTabortagent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdmin.setText("Ändra adminstatus ");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        jLtitel.setText("Välj åtgärd för agent:");

        btnRedigeraAgent.setText("Redigera agentinformation");
        btnRedigeraAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraAgentActionPerformed(evt);
            }
        });

        btnTabortagent.setText("Ta bort agent ");
        btnTabortagent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabortagentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 136, Short.MAX_VALUE)
                .addComponent(jLtitel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnTillbaka))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRedigeraAgent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTabortagent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLtitel)
                .addGap(39, 39, 39)
                .addComponent(btnAdmin)
                .addGap(18, 18, 18)
                .addComponent(btnRedigeraAgent)
                .addGap(18, 18, 18)
                .addComponent(btnTabortagent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        new GeAgentAdminstatus(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new AgentAdminFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnRedigeraAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraAgentActionPerformed
        // TODO add your handling code here:
        new RedigeraAgentFonster(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRedigeraAgentActionPerformed

    private void btnTabortagentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabortagentActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnTabortagentActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnRedigeraAgent;
    private javax.swing.JButton btnTabortagent;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JLabel jLtitel;
    // End of variables declaration//GEN-END:variables
}
