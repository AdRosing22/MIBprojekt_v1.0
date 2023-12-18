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
 * @author Adam & Melker
 */
public class InlogAgent {

    private static String namn;
    private static String telefon;
    private static String omrade;
    private static String agentid;
    private static InfDB idb;
    private static String epost;
    private static String datum;
    private static String losenord;
    private static String administrator;
    
    
    //konstruktorn tar in databasen och epost (som identifierare) som parametrar
    public InlogAgent(InfDB idb, String epost)
    {
        this.idb = idb;
        this.epost = epost;
        hamtaInfoOmAgent();
    }  
    
    
    //metod för att hämta ut info kring agent utifrån epost och lagra i fält
public static void hamtaInfoOmAgent()
    {
        String fraga1 = "SELECT agent_id FROM agent WHERE epost='"+epost+"'";
        String fraga2 = "SELECT namn FROM agent WHERE epost='"+epost+"'";
        String fraga3 = "SELECT telefon FROM agent WHERE epost='"+epost+"'";
        String fraga4 = "SELECT omrade FROM agent WHERE epost='"+epost+"'";
        String fraga5 = "SELECT anstallningsdatum FROM agent WHERE epost='"+epost+"'";
        String fraga6 = "SELECT losenord FROM agent WHERE epost='"+epost+"'";
        String fraga7 = "SELECT administrator FROM agent WHERE epost='"+epost+"'";
        
        try{
            if(fraga1!=null||fraga2!=null||fraga3!=null||fraga4!=null||fraga5!=null||fraga6!=null||fraga7!=null){
                agentid = idb.fetchSingle(fraga1);
                namn = idb.fetchSingle(fraga2);
                telefon = idb.fetchSingle(fraga3);
                omrade = idb.fetchSingle(fraga4);
                datum = idb.fetchSingle(fraga5);
                losenord = idb.fetchSingle(fraga6);
                administrator = idb.fetchSingle(fraga7);
                
                
            }   
    }catch (InfException undantag){
                    
        JOptionPane.showMessageDialog(null, "Fel");
        System.out.println("Internt felmeddelande"+undantag.getMessage());
        }
    }

    public static boolean isAdministrator() {
        return administrator.equals("J");
    }
    
    
    

//alla getters och setters för att kunna ha åtkomst till specifika uppgifter hämtade via hamtaInfo metoderna

    public static String getNamn() {
        return namn;
    }
    public static String getTelefon() {
        return telefon;
    }
    public static String getOmrade() {
        return omrade;
    }
    public static String getAgentId() {
        return agentid;
    }
    public static InfDB getIdb() {
        return idb;
    }
    public static String getEpost() {
        return epost;
    }
    public static String getLosenord(){
        return losenord;
    }
    public static String getDatum(){
        return datum;
    }
    public static String getAdministrator()
    {
        return administrator;
    }   
}