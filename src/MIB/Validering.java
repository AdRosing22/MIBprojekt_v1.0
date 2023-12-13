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
        
        String fragaAgent = "SELECT epost FROM agent WHERE epost like'"+epost+"'";
        String fragaAlien = "SELECT epost FROM alien WHERE epost like'"+epost+"'";
        
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
        catch (InfException e){
            JOptionPane.showMessageDialog(null, "Ingen epost hittades, försök igen");
            System.out.println("Internt felmeddelande"+e);
        }
        return finns;
    }
    
    
    
    
}
