/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MIB;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Adam
 * 
 * heej
 */
public class Start {
    
    private static InfDB idb; 
    
    //main metod som startar upp kalaset
    public static void main(String[] args) {
        
        //koppling mot databasen mibdb
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            System.out.println("Koppling LYCKAD");
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }

        //
        new InloggningsFonster(idb).setVisible(true); 
        

    }
    
}
    

