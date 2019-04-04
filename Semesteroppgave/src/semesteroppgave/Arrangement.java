package semesteroppgave;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author sarah
 */
public class Arrangement {
    private String arrangementsNavn;
    private Lokale lokale;
    private Kontaktperson kontakt;
    private ArrayList<Person> deltakere;
    private HashMap<Integer,String> program;
    private Billett[] solgteBilletter;
    private Tidspunkt dato;
    private int pris;
    private static int antSolgte = 0;
    
    public void setNavn(String arrangementsNavn) {this.arrangementsNavn
            = arrangementsNavn;}
    public String getNavn() {return arrangementsNavn;}
    public void setLokale(Lokale lokale) {this.lokale = lokale;}
    public Lokale getLokale() {return lokale;}
    public void setKontakt(Kontaktperson kontakt) {this.kontakt = kontakt;}
    public Kontaktperson getKontakt() {return kontakt;}
    public void setTidspunkt(Tidspunkt dato) {this.dato = dato;}
    public Tidspunkt getTidspunkt() {return dato;}
    public void setPris(int pris) {this.pris = pris;}
    public int getPris() {return pris;}
    
    public int getAntSolgte() {return antSolgte;}
    
    public Arrangement(String arrangementsNavn, Lokale lokale, Kontaktperson
            kontakt, Tidspunkt dato) {
        this.arrangementsNavn = arrangementsNavn;
        this.lokale = lokale;
        this.kontakt = kontakt;
        solgteBilletter = new Billett[lokale.getAntPlasser()];
        deltakere = new ArrayList();
        program = new HashMap();
    }
    
    public void billettsalg(Person pers) {
        if(antSolgte < lokale.getAntPlasser()) {
            Billett nybillett = new Billett(lokale, antSolgte, dato, pris, pers);
            deltakere.add(pers);
            solgteBilletter[antSolgte] = nybillett;
            antSolgte++;
        } else {
            System.out.println("Fullt, dessverre");
        }
    }
    
    public void leggTilProgram(int tidspunkt, String navn) {
        program.put(tidspunkt,navn);
    }
    
    public String toString() {
        return String.format("Arrangementsnavn: %s \nLokale: %d \nKontaktperson"
                + ": %d \nDato: %d \nPris: %d \nLedige billetter: %d", 
                arrangementsNavn, lokale, kontakt, dato, pris, 
                (lokale.getAntPlasser()-antSolgte));
    }
}