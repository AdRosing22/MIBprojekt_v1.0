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
            
            if(dbEpost != null){
                finns = true;
            }
            else{
                dbEpost = idb.fetchSingle(fragaAlien);
                if(dbEpost != null){
                    finns = true;
                }
            }
        }
<<<<<<< HEAD
        catch (InfException undantag){
            JOptionPane.showMessageDialog(null, "Fel");
            System.out.println("Internt felmeddelande"+undantag);
=======
        catch (InfException e){
<<<<<<< HEAD
            System.out.println("Ingen epost hittades, försök igen."+e);
=======
            JOptionPane.showMessageDialog(null, "Ingen epost hittades, försök igen");
            System.out.println("Internt felmeddelande"+e);
>>>>>>> 4562f03e23e620ebdc5df6ebe8a1ec273d3582c0
>>>>>>> 7d4a3213aed89b6ce670f6e6507a4b5b4af96ec7
        }
        return finns;
    }
    
    
    
    //metod som kontrollerar adminstatus för agent
    public static boolean kontrollOmAdmin(String epost)
    {
        boolean arAdmin = false;
        String svar;
        String fraga = "SELECT administrator FROM agent WHERE epost='"+epost+"'";
        
        try{
            svar = idb.fetchSingle(fraga);
            
            if(svar.equals("J"))
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
    
    
    
    
}
