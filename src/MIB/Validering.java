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
 */
public class Validering {
    
    private static InfDB idb;
    
    public Validering(InfDB idb)
    {
        this.idb = idb;
    }
    
    
    //kontrollerar att angiven epost går att hitta i databasen
    //ifall det inte är null och den hämtade eposten stämmer överens med parametern
    //--söker igenom både alien och agent
    public static boolean finnsAnvandareEpostIDB(String epost)
    {
        boolean finns = false;
        String dbEpost;
        
        String fragaAgent = "SELECT epost FROM agent WHERE epost ='"+epost+"'";
        String fragaAlien = "SELECT epost FROM alien WHERE epost ='"+epost+"'";
        
        //kör fråga mot databas
        
        try{
            dbEpost = idb.fetchSingle(fragaAgent);
            
            if(dbEpost != null && dbEpost.equals(epost)){
                finns = true;
            }
            else{
                dbEpost = idb.fetchSingle(fragaAlien);
                if(dbEpost != null && dbEpost.equals(epost)){
                    finns = true;
                }
            }
            if(!finns){
                JOptionPane.showMessageDialog(null, "Ingen kopplad epost hittades");
            }
        }
        catch (InfException undantag){
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println("Internt felmeddelande"+undantag.getMessage());
    }
    return finns;
}
    
//kontrollerar ifall agent har administarörsstatus
//--hårdkodat så att det alltid kommer angivas med J eller N
    
public static boolean kontrollOmAdmin(String epost)
{
    boolean arAdmin = false;
    String svar;
    String fraga = "SELECT administrator FROM agent WHERE epost='"+epost+"'";
        
    try{
        svar = idb.fetchSingle(fraga);
            
        if(svar != null && svar.equals("J"))
        {
            arAdmin = true;
        }
        }
        catch (InfException undantag){
            JOptionPane.showMessageDialog(null, "Fel");
            System.out.println("Internt felmeddelande"+undantag.getMessage());
        }catch(Exception e)
        {
            System.out.println("Internt fel"+e);
        }
        
        return arAdmin;
        }
    



//kontrollerar ifall angivet lösenord stämmer överens med angiven epost

public static boolean kontrollLosenStammer(String epost, String losenord)
{
    boolean stammer = false;
    String agentFraga = "SELECT losenord FROM agent WHERE epost='"+epost+"'";
    String alienFraga = "SELECT losenord FROM alien WHERE epost='"+epost+"'";

    String svar;
    
    
    
    try{
        
        if(valImeny("Agent"))
        {
            svar = idb.fetchSingle(agentFraga);
            if(svar != null)
            {
                if(svar.equals(losenord))
                {
                    stammer = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Fel lösenord, försök igen");
                }
            }
        }
        else if(valImeny("Alien")){
            svar = idb.fetchSingle(alienFraga);
            if(svar != null){
                if(svar.equals(losenord))
                {
                    stammer = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Fel lösenord, försök igen");
                }
            }
            
        }
    }catch (InfException undantag)
    {
        JOptionPane.showMessageDialog(null, "Något gick fel");
        System.out.println("Internt Fel"+undantag.getMessage());
    }catch (Exception e)
    {
        System.out.println("Internt fel"+e);
    }
    
    return stammer;
}







public static boolean valImeny(String val)
{
    boolean vald = false;
    if(InloggningsFonster.getMenyval().equals(val))
    {
        vald = true;
    }
    return vald;
}

public static boolean godkanndLosenLangd(String losenord)
{
    boolean godkand = false;
    int maxLangd = 6;
    int losLangd = losenord.length();
    
    
    if(losLangd <= maxLangd)
    {
        godkand = true;
    }
    return godkand;
}
}


