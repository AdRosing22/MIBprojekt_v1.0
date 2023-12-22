package MIB;


import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author gustafneander
 */
public class AlienDatum extends javax.swing.JFrame {
private static InfDB idb;
    /**
     * Creates new form AlienDatum
     */
    public AlienDatum(InfDB idb) {
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

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnHamtaAlienDatum = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAliensDatum = new javax.swing.JTextArea();
        jDateFrom = new com.toedter.calendar.JDateChooser();
        jDateTo = new com.toedter.calendar.JDateChooser();
        btnTillbaka = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Datum från:");

        jLabel7.setText("Datum till:");

        btnHamtaAlienDatum.setText("Hämta Aliens inom valda datum");
        btnHamtaAlienDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtaAlienDatumActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAliensDatum.setColumns(20);
        txtAliensDatum.setRows(5);
        jScrollPane3.setViewportView(txtAliensDatum);

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
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHamtaAlienDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTillbaka)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addContainerGap(150, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHamtaAlienDatum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addGap(18, 18, 18))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(276, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHamtaAlienDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaAlienDatumActionPerformed
        // TODO add your handling code here:
    if (jDateFrom.getDate() == null) {
txtAliensDatum.setText("Välj ett fråndatum");
return;
}
        if (jDateTo.getDate() == null) {
txtAliensDatum.setText("Välj ett tilldatum");
return;
}
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (jDateFrom.getDate().after(jDateTo.getDate())) {
            txtAliensDatum.setText("Datum från måste vara mindre än eller \nsamma som datum till");

        } else {
            String datefrom = sdf.format(jDateFrom.getDate());
            String dateto = sdf.format(jDateTo.getDate());
            String SQLQuery = "select Namn,Registreringsdatum from alien where Registreringsdatum >= '"+ datefrom + "' and Registreringsdatum <= '" + dateto + "' order by Registreringsdatum;";
            System.out.println(SQLQuery);
            try {
                idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
                // Object ras = cbxRas.getSelectedItem();
                System.out.println(SQLQuery);
                //kör sql frågan till en ArrayList.
                ArrayList<HashMap<String, String>> resultList = idb.fetchRows(SQLQuery);

                // Loopar igenom resultatet i ArrayList.
                if (resultList.isEmpty()){
                    txtAliensDatum.setText("");
                    txtAliensDatum.append(" Det finns inga Aliens registrerade \n inom valda datum");
                }

                else{
                    txtAliensDatum.setText("");
                    txtAliensDatum.append("Följande Aliens finns registrerade inom valda datum: \n");

                    for (HashMap<String, String> row : resultList) {
                        // Hämtar namnen på aliens.
                        for (HashMap.Entry<String, String> entry : row.entrySet()) {
                            String columnName = entry.getKey();
                            String columnValue = entry.getValue();

                            // Skriv ut kolumnnamn och värde
                            System.out.println(columnName + ": " + columnValue);
                        }
                        String Namn = row.get("Namn");
                        String Registreringsdatum = row.get("Registreringsdatum");

                        System.out.println("Namn: " + Namn);

                        txtAliensDatum.append("\n Namn: " + Namn)  ;
                        txtAliensDatum.append(", Registreringsdatum: " + Registreringsdatum)  ;
                    }
                }
            }

            catch (InfException ex) {
              //  Logger.getLogger(AlienDatum.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }//GEN-LAST:event_btnHamtaAlienDatumActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        new ValjTypSokAvAlien(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHamtaAlienDatum;
    private javax.swing.JToggleButton btnTillbaka;
    private com.toedter.calendar.JDateChooser jDateFrom;
    private com.toedter.calendar.JDateChooser jDateTo;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAliensDatum;
    // End of variables declaration//GEN-END:variables
}
