/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MIB;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author adamrosing, melker langell, gustaf neander, alvin källberg
 * //V1.0 2023-12-09
 *
 * 
 */
public class Start {
    
    private static InfDB idb; 
    
    //main metod som startar upp kalaset
    public static void main(String[] args) {
        
        //koppling mot databasen mibdb
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            System.out.println("Koppling mot databas LYCKAD");
        } catch (InfException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Fel i systemet, vänligen testa igen");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }

        //new InloggningsFonster(idb).setVisible(true);
        new Top3AnsvarigaAgenter(idb).setVisible(true);
        new Validering(idb);
        

    }
    
}
    

