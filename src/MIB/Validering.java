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
        }
        catch (InfException undantag){
            JOptionPane.showMessageDialog(null, "Epost hittades inte");
            System.out.println("Internt felmeddelande"+undantag);
    }
    return finns;
}
    
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
            System.out.println("Internt felmeddelande"+undantag);
        }
        
        return arAdmin;
        }
    
public static boolean kontrollOmLosenStammerAgent(String epost, String losenord)
{
    boolean stammer = false;
    String fraga = "SELECT losenord FROM agent WHERE epost='"+epost+"'";
    
    try{
        String svar = idb.fetchSingle(fraga);
        
        if(finnsAnvandareEpostIDB(epost)&& svar!= null)
        {
            if(svar.equals(losenord))
            {
                stammer = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Fel lösenord, försök igen"); 
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Fel epost, försök igen");
        }
    }catch (InfException undantag)
    {
        JOptionPane.showMessageDialog(null, "Fel");
        System.out.println("Internt felmeddelande"+undantag);
    }
    return stammer;   
}

public static boolean kontrollOmLosenStammerAlien(String epost, String losenord)
{
    boolean stammer = false;
    String fraga = "SELECT losenord FROM alien WHERE epost='"+epost+"'";
    
    try{
        String svar = idb.fetchSingle(fraga);
        
        if(finnsAnvandareEpostIDB(epost) && svar!= null)
        {
            if(svar.equals(losenord))
            {
                stammer = true;
            }
            else
            {
           JOptionPane.showMessageDialog(null, "Fel lösenord eller epost, försök igen"); 
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Fel epost, försök igen");
        }
    }catch (InfException undantag)
    {
        JOptionPane.showMessageDialog(null, "Fel");
        System.out.println("Internt felmeddelande"+undantag);
    }
    return stammer;   
}

}


