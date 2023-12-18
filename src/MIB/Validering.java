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
    public static boolean finnsAnvandareEpostIDB(String epost){
        boolean finns = false;
        String anvEpost;

        String fraga1 = "SELECT epost FROM Agent WHERE Epost ='"+ epost+"'";
        String fraga2 = "SELECT epost FROM Alien WHERE Epost ='"+ epost+"'";

        // Hämtar ut ur databasen
        try {
            if(valImeny("Agent")){
            anvEpost = idb.fetchSingle(fraga1);
            
            if(anvEpost != null){
                finns = true;
            }
            }
            else if(valImeny("Alien")){
                anvEpost = idb.fetchSingle(fraga2);
                
                    if(anvEpost != null){
                    finns = true;
                    }
                }
            if(!finns)
            {
                JOptionPane.showMessageDialog(null, "Inget konto med den eposten kan hittas");
            }
  
        } catch (InfException e) {
            System.out.println("Internt felmeddelande" + e);

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
    else{
        JOptionPane.showMessageDialog(null, "Lösenordet får max vara 6 tecken långt, försök igen");
    }
        
    return godkand;
}



public static boolean isTxtFilled(String txtb)
{
    boolean isFilled = false;
    if(txtb.isEmpty())
    {
        JOptionPane.showMessageDialog(null, "Vänligen fyll i den nödvändiga informationen för att fortsätta");
    }
    else{
        isFilled = true;
    }
    return isFilled;
}
        
}


