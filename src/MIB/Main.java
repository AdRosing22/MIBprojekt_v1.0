package MIB;

import java.util.logging.Level;
import java.util.logging.Logger;

import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author adamrosing
 */
public class Main {
    
    private static InfDB idb; 
    
    //main metod som startar upp kalaset
    public static void main(String[] args) {
        
        //koppling mot databasen mibdb
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            System.out.println("Koppling mot databas LYCKAD");
        } catch (InfException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
}
