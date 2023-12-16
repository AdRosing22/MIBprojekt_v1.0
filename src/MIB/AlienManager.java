/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MIB;

import static MIB.Alien.idb;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Melker
 */
public class AlienManager {
    static InfDB idb;


public AlienManager(InfDB idb) {
this.idb = idb;
}

public static ArrayList<Alien> getAliensFromDB(String plats) {
    ArrayList<Alien> aliens = new ArrayList<>();
    
    try {
        String fraga = "SELECT * FROM alien WHERE Plats = '" + plats + "'";
        ArrayList<HashMap<String, String>> alienDataList = idb.fetchRows(fraga);
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