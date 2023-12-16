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
        String fraga1 = "SELECT alien_id FROM alien WHERE epost='"+epost+"'";
        String fraga2 = "SELECT namn FROM alien WHERE epost='"+epost+"'";
        String fraga3 = "SELECT telefon FROM alien WHERE epost='"+epost+"'";
        String fraga4 = "SELECT plats FROM alien WHERE epost='"+epost+"'";
        String fraga5 = "SELECT registreringsdatum FROM alien WHERE epost='"+epost+"'";
        String fraga6 = "SELECT losenord FROM alien WHERE epost='"+epost+"'";
        String fraga7 = "SELECT ansvarig_agent FROM alien WHERE epost='"+epost+"'";
        
        try{
            if(fraga1!=null||fraga2!=null||fraga3!=null||fraga4!=null||fraga5 != null||fraga6!=null||fraga7!=null){
                alienid = idb.fetchSingle(fraga1);
                namn = idb.fetchSingle(fraga2);
                telefon = idb.fetchSingle(fraga3);
                plats = idb.fetchSingle(fraga4);
                datum = idb.fetchSingle(fraga5);
                losenord = idb.fetchSingle(fraga6);
                ansvarig_agent = idb.fetchSingle(fraga7);
            }   
    }catch (InfException undantag){
                    
        JOptionPane.showMessageDialog(null, "Fel");
        System.out.println("Internt felmeddelande"+undantag.getMessage());
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
