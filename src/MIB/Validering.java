/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MIB;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *Valideringsklass som innehåller flera metoder som används genom hela projektet
 * Metoderna är av typen boolean och används t.ex. vid kontroll om användares epost
 * --redan finns i databasen, ifall lösenordet är godkänd längt, ifall agent är admin osv.
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
    //--söker igenom både alien och agent beroende på val vad man vill logga in som
    public static boolean finnsAnvandareEpostIDB(String epost){
        boolean finns = false;
        String anvEpost;

        String fraga1 = "SELECT epost FROM Agent WHERE Epost ='"+ epost+"'";
        String fraga2 = "SELECT epost FROM Alien WHERE Epost ='"+ epost+"'";

        // Hämtar ut ur databasen
        try {
            if(valImenyInloggningFonster("Agent")){
            anvEpost = idb.fetchSingle(fraga1);
            
            if(anvEpost != null){
                finns = true;
            }
            }
            else if(valImenyInloggningFonster("Alien")){
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
    
    
    
    //kontroll för som används vid alien/agent registrering för att hålla alla
    //eposter unika i databasen
    public static boolean epostKontrollVidreg(String ep)
    {
        boolean finnsInte = false;
        try{
        String fragaAlien ="SELECT epost FROM alien WHERE epost='"+ep+"'";
        String svarAlien = idb.fetchSingle(fragaAlien);
        String fragaAgent = "SELECT epost FROM agent WHERE epost='"+ep+"'";
        String svarAgent = idb.fetchSingle(fragaAgent);
        if(svarAlien == null && svarAgent == null){
            finnsInte = true;
        }
        }catch(InfException ex){
            JOptionPane.showMessageDialog(null,"Fel");
           System.out.println("Internt felmeddelande: "+ex.getMessage());
        }
        return finnsInte;
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
        
        if(valImenyInloggningFonster("Agent"))
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
        else if(valImenyInloggningFonster("Alien")){
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






//kontroll för att se ifall valet är agent eller alien i inloggningsfönstret
//-i efterhand väldigt ångersam över denna :,)
public static boolean valImenyInloggningFonster(String val)
{
    boolean vald = false;
    if(InloggningsFonster.getMenyval().equals(val))
    {
        vald = true;
    }
    return vald;
}


//kontrollerar att lösenord inte är längre än 6 tecken, används vid reg och ändring
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



//kontrollerar att en textruta inte är tom
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
        


//kontroll som används vid AndraLosenord för att se till att man inte anger samma

public static boolean isLosenordNew(String nuv, String nytt)
{
    boolean samma = true;
    
    if(nuv.equals(nytt)){
        JOptionPane.showMessageDialog(null, "Lösenord är samma som det gamla, pröva någonting nytt");
        samma = false;
    }
    return samma;  
}



//eftersom jag aldrig sett en epost utan @ så kontrollerar denna metod att 
//en ny eller ändrad epost innehåller @
public static boolean isEpostTrustable(String epost)
{
    boolean ja = false;
    
    if(epost.contains("@")){
        ja = true;
    }else{
        JOptionPane.showMessageDialog(null,"Din angivna epost verkar inte vara korrekt, kan du ha glömt använda @?");
    }
    return ja;
}


//metod som kontrollerar att en sträng innehåller en bokstav
//hjälp av AI med denna för fick det inte att fungera med a-ö först
public static boolean containsAlphabet(String txt) {
    boolean sant = false;

    if (txt.matches(".*[a-öA-Ö]+.*")) {
        sant = true;
    } else {
        System.out.println("Txt: " + txt);
        JOptionPane.showMessageDialog(null, "Du har fält som innehåller enbart siffror istället för kombination av siffror och tecken. Kontrollera ifall du har ett namnfält eller epostfält att inmatning är korrekt");
    }

    return sant;
}


//metod som kontrollerar att det inte finns nummer
//skapades för !containsAlphabet inte fungerade på tänkt sätt
//där det behövdes
public static boolean containsOnlyNumber(String txt){
    boolean sant = true;
    if(txt.matches(".*[a-öA-Ö]+.*")){
        sant = false;
    }
    return sant;
    
}


}


