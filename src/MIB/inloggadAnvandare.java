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
 * @author Adam
 */
public class inloggadAnvandare {

    private static String namn;
    private static String telefon;
    private static String omrade;
    private static String agentid;
    private static InfDB idb;
    private static String epost;
    private static String alienid;
    private static String plats;
    
    public inloggadAnvandare(InfDB idb, String epost)
    {
        this.idb = idb;
        this.epost = epost;
    }  
    
    public static void hamtaInfoOmAgent()
    {
        String fraga1 = "SELECT agent_id FROM agent WHERE epost='"+epost+"'";
        String fraga2 = "SELECT namn FROM agent WHERE epost='"+epost+"'";
        String fraga3 = "SELECT telefon FROM agent WHERE epost='"+epost+"'";
        String fraga4 = "SELECT omrade FROM agent WHERE epost='"+epost+"'";
        
        try{
            if(fraga1 != null || fraga2!= null || fraga3 != null || fraga4 != null){
                agentid = idb.fetchSingle(fraga1);
                namn = idb.fetchSingle(fraga2);
                telefon = idb.fetchSingle(fraga3);
                omrade = idb.fetchSingle(fraga4);
            }   
    }catch (InfException undantag){
                    
        JOptionPane.showMessageDialog(null, "Fel");
        System.out.println("Internt felmeddelande"+undantag);
        }
    }
    
    
    public static void hamtaInfoOmAlien()
    {
        String fraga1 = "SELECT alien_id FROM alien WHERE epost='"+epost+"'";
        String fraga2 = "SELECT namn FROM alien WHERE epost='"+epost+"'";
        String fraga3 = "SELECT telefon FROM alien WHERE epost='"+epost+"'";
        String fraga4 = "SELECT plats FROM alien WHERE epost='"+epost+"'";
        
        try{
            if(fraga1 != null || fraga2!= null || fraga3 != null || fraga4 != null){
                alienid = idb.fetchSingle(fraga1);
                namn = idb.fetchSingle(fraga2);
                telefon = idb.fetchSingle(fraga3);
                plats = idb.fetchSingle(fraga4);
            }   
    }catch (InfException undantag){
                    
        JOptionPane.showMessageDialog(null, "Fel");
        System.out.println("Internt felmeddelande"+undantag);
        }
    }
    
    
    

}