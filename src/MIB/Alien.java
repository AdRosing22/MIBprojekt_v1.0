/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MIB;

import oru.inf.InfDB;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author Melker
 */
public class Alien {

    static ArrayList<Alien> getAliensFromPlats() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private int alienid;
    private String namn;
    private String telefon;
    private String epost;
    private String registreringsdatum;
    private String losenord;
    private String plats;
    static InfDB idb;


    
public Alien(int alienid, String namn, String telefon) {
this.alienid = alienid;
this.namn = namn;
this.telefon = telefon;
}

//getters
public int getAlienId() {
    return alienid;
}

public String getNamn() {
    return namn;
}

public String getTelefon() {
    return telefon;
}

public String getEpost() {
    return epost;
}
public String getRegistreringsdatum() {
    return registreringsdatum;
}

public String getLosenord() {
    return losenord;
}
public String getPlats() {
    return plats;
}
public InfDB getIdb() {
    return idb;
}

//setters
public void setAlienId() {
    this.alienid = alienid;
}

public void setNamn() {
    this.namn = namn;
}

public void setTelefon() {
    this.telefon = telefon;
}

public void setEpost() {
    this.epost = epost;
}

public void setRegistreringsdatum() {
    this.registreringsdatum = registreringsdatum;
}

public void setLosenord() {
    this.losenord = losenord;
}

public void setPlats() {
    this.plats = plats;
}

public void setIdb() {
    this.idb = idb;
}


public static ArrayList<Alien> getAliensFromDB(String plats) {
    ArrayList<Alien> aliens = new ArrayList<>();
    
    try {
        String fraga = "SELECT * FROM alien WHERE Plats = '" + plats + "';";
        ArrayList<HashMap<String, String>> alienDataList = idb.fetchRows("SELECT * FROM alien;");
        for(HashMap<String, String> alienData : alienDataList) {
            Alien alien = new Alien(
            Integer.parseInt(alienData.get("Alien_ID")),
            alienData.get("Namn"),
            alienData.get("Telefon")
            );
            aliens.add(alien);
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Databasfel " + e.getMessage());
    }
    return aliens;
}
}

