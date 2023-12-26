package MIB;


import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *Klass för att lista aliens efter rastillhörighet
 * @author gustafneander
 */
public class AlienRas extends javax.swing.JFrame {
private static InfDB idb;
    /**
     * Creates new form AlienRas
     */
    public AlienRas(InfDB idb) {
        initComponents();
        this.idb = idb;
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

        jLabel5 = new javax.swing.JLabel();
        cbxRas = new javax.swing.JComboBox<>();
        btnHamtaAlienRas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAliensRas = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Raser");

        cbxRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boglodite", "Squid", "Worm" }));

        btnHamtaAlienRas.setText("Hämta Aliens av vald ras");
        btnHamtaAlienRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtaAlienRasActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAliensRas.setColumns(20);
        txtAliensRas.setRows(5);
        jScrollPane2.setViewportView(txtAliensRas);

        jLabel4.setText("Välj Ras:");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka)))
                .addContainerGap(287, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnHamtaAlienRas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxRas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                    .addContainerGap(51, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addGap(15, 15, 15))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(cbxRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(btnHamtaAlienRas)
                    .addGap(15, 15, 15)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHamtaAlienRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaAlienRasActionPerformed

        try {
            Object ras  = cbxRas.getSelectedItem();
            // Object ras = cbxRas.getSelectedItem();
            String SQLQuery = "SELECT "+ ras +".Alien_ID,Alien.namn as Mittnamn  FROM "+ ras +" left join Alien on "+ras +".Alien_id = Alien.Alien_ID;";
            System.out.println(SQLQuery);
            //kör sql frågan till en ArrayList.
            ArrayList<HashMap<String, String>> resultList = idb.fetchRows(SQLQuery);

            // Loopar igenom resultatet i ArrayList.
            if (resultList.isEmpty()){
                txtAliensRas.setText("");
                txtAliensRas.append(" Det finns inga Aliens av ras: "+ras);
            }

            else{
                txtAliensRas.setText("");
                txtAliensRas.append("Följande Aliens finns av ras: "+ras);

                for (HashMap<String, String> row : resultList) {
                    // Hämtar namnen på aliens.
                    for (HashMap.Entry<String, String> entry : row.entrySet()) {
                        String columnName = entry.getKey();
                        String columnValue = entry.getValue();

                        // Skriv ut kolumnnamn och värde
                        System.out.println(columnName + ": " + columnValue);
                    }
                    String Namn = row.get("Namn");

                    System.out.println("Namn: " + Namn);

                    txtAliensRas.append("\n" + Namn)  ;

                }
            }
        }

        catch (InfException ex) {
            JOptionPane.showMessageDialog(null,"Något gick fel");
            System.out.println(ex.getMessage());
           

        }

    }//GEN-LAST:event_btnHamtaAlienRasActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new ValjTypSokAvAlien(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHamtaAlienRas;
    private javax.swing.JToggleButton btnTillbaka;
    private javax.swing.JComboBox<String> cbxRas;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAliensRas;
    // End of variables declaration//GEN-END:variables
}
