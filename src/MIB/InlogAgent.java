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
        String fraga = "SELECT agent_id, namn, telefon, omrade, anstallningsdatum, losenord, administrator FROM Agent WHERE epost ='"+epost+"'";

        try{
            HashMap<String, String> agentInfo = idb.fetchRow(fraga);
            
            if(agentInfo != null){
                agentid = agentInfo.get("Agent_ID");
                namn = agentInfo.get("Namn");
                telefon = agentInfo.get("Telefon");
                omrade = agentInfo.get("Omrade");
                datum = agentInfo.get("Anstallningsdatum");
                losenord = agentInfo.get("Losenord");
                administrator = agentInfo.get("Administrator");
                
                
                
            }
            
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande"+ex.getMessage());
        }
    }

    public static boolean isAdministrator() {
        return administrator.equals("J");
    }
    
    

    public static void loggaUt()
    {
        namn ="";
        epost="";
        telefon="";
        omrade="";
        agentid="";
        losenord="";
        datum="";
        administrator="";          
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