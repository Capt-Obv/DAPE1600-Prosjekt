package logic;

import java.io.Serializable;

public class Person implements Serializable {
    private String navn;
    private int telefonNr;
    
    public Person(String navn, int telefonNr) {
        this.navn = navn;
        this.telefonNr = telefonNr;
    }
    
    public void setNavn(String navn) {this.navn = navn;}
    public String getNavn() {return navn;}
    public void setTelefonNr(int telefonNr) {this.telefonNr = telefonNr;}
    public int getTelefonNr() {return telefonNr;}
    
    @Override
    public String toString() {
        return String.format("Navn: %s \nTelefonnummer: %d", navn, telefonNr);
    }
}