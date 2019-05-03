/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sarah
 */
public class Lokale implements Serializable {
    private String navn;
    private final int antPlasser;
    private String type;
    
    public Lokale(String navn, int antPlasser, String type) {
        this.navn = navn;
        this.antPlasser = antPlasser;
        this.type = type;
    }
        public static ArrayList<String> lokalListe(){
        ArrayList<String> lokaler = new ArrayList<>();
        lokaler.add("Kino");
        lokaler.add("Konsertsal");
        lokaler.add("Foredragsal");
        lokaler.add("Teatersal");
        return lokaler;
    }
        
    //get-set methods
    public void setNavn(String navn) {this.navn = navn;}
    public String getNavn() {return navn;}
    public int getAntPlasser() {return antPlasser;}
    public String getType() {return type;}
    
    @Override
    public String toString() {
        return String.format("Lokalets navn: %s \nKapasitet: %d \nType: %s",
                 navn, antPlasser, type);
    }
}