/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MIB;

import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Adam
 */
public class inloggadAnvandare {
    
    private String namn;
    private InfDB idb;
    
    public inloggadAnvandare(InfDB idb)
    {
        this.idb = idb;
    }
    
    public String hamtaNamnAgent(String epost)
    {
        try{
            String fraga = "SELECT namn FROM agent WHERE epost='"+epost+"'";
            String svar = idb.fetchSingle(fraga);
            try{  
                if(!svar.isEmpty())
                {
                    namn = svar;
                }
            }catch (Exception undantag){
                System.out.println("Internt felmeddelande"+undantag);
            }
            
        }catch (InfException ex){
            Logger.getLogger(inloggadAnvandare.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return namn;
    }
    
   /* public String hamtaNamnAlien(String epost) throws InfException
    {
        String fraga = "SELECT namn FROM alien WHERE epost='"+epost+"'";
        String svar = idb.fetchSingle(fraga);
        
    }*/
    
    
}
