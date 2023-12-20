/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MIB;


import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author adamrosing
 */
public class InlogAlien {

    private static String epost;
    private static InfDB idb;
    private static String alienid;
    private static String namn;
    private static String telefon;
    private static String plats;
    private static String datum;
    private static String losenord;
    private static String ansvarig_agent;
    
    
    
    public InlogAlien(InfDB idb, String epost){
            this.idb = idb;
            this.epost = epost;
            hamtaInfoOmAlien();
    }
    
    public InlogAlien(InfDB idb)
    {
        this.idb = idb;
    }
    
      
    
public static void hamtaInfoOmAlien()
    {
        String fraga = "SELECT alien_id, registreringsdatum, losenord, namn, telefon, plats, ansvarig_agent FROM Alien WHERE epost ='"+epost+"'";

        try{
            HashMap<String, String> alienInfo = idb.fetchRow(fraga);
            
            if(alienInfo != null){
                alienid = alienInfo.get("Alien_ID");
                namn = alienInfo.get("Namn");
                telefon = alienInfo.get("Telefon");
                plats = alienInfo.get("Plats");
                datum = alienInfo.get("Registreringsdatum");
                losenord = alienInfo.get("Losenord");
                ansvarig_agent = alienInfo.get("Ansvarig_Agent");
                
                
                System.out.println(alienid+namn+telefon+plats+datum+ansvarig_agent);
                
            }
            
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande"+ex.getMessage());
        }
    }

    
    
    public static String getEpost()
    {
        return epost;
    }
    
    public static String getAlienID()
    {
         return alienid;   
    }
    public static String getNamn()
    {
        return namn;
    }
    public static String getTelefon()
    {
        return telefon;
    }
    public static String getPlats()
    {
        return plats;
    }
    public static String getDatum()
    {
        return datum;
    }
    public static String getLosenord()
    {
        return losenord;
    }
    public static String getAnsvarigAgent()
    {
        return ansvarig_agent;
    }
    
    
}
