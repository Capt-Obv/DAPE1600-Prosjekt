package semesteroppgave;

import java.util.ArrayList;

/**
 *
 * @author sarah
 */

public class Arrangement {
    private String arrangementsNavn;
    private Kontaktperson kontakt;
    private Lokale lokale;
    private ArrayList<Deltaker> deltakere;
    private ArrayList<Programelement> program;
    private Billett[] solgteBilletter;
    private Dato dato;
    private int pris;
    private static int antSolgte = 0;
    
    public Arrangement(String arrangementsNavn, Lokale lokale, Kontaktperson
            kontakt, Dato dato, int pris) {
        this.arrangementsNavn = arrangementsNavn;
        this.kontakt = kontakt;
        this.lokale = lokale;
        this.pris = pris;
        solgteBilletter = new Billett[lokale.getAntPlasser()];
        deltakere = new ArrayList();
        program = new ArrayList();
    }
        
    public void setNavn(String arrangementsNavn) {this.arrangementsNavn
            = arrangementsNavn;}
    public String getNavn() {return arrangementsNavn;}
    public void setKontakt(Kontaktperson kontakt) {this.kontakt = kontakt;}
    public Kontaktperson getKontakt() {return kontakt;}
    public void setLokale(Lokale lokale) {this.lokale = lokale;}
    public Lokale getLokale() {return lokale;}
    public void setDato(Dato dato) {this.dato = dato;}
    public Dato getDato() {return dato;}
    public void setPris(int pris) {this.pris = pris;}
    public int getPris() {return pris;}
    public int getAntSolgte() {return antSolgte;}
    

    public void leggTilArtist(Person pers, String rolle) {
        Deltaker artist = new Deltaker(pers, rolle);
        deltakere.add(artist);
    }
    
    public boolean billettsalg(Person pers) {
        boolean billett = false;
        if(antSolgte < lokale.getAntPlasser()) {
            Billett nybillett = new Billett(lokale, antSolgte, dato, pris, pers);
            Deltaker kunde = new Deltaker(pers, "Deltaker");
            deltakere.add(kunde);
            solgteBilletter[antSolgte] = nybillett;
            antSolgte++;
            billett = true;
        } else {
            System.out.println("Fullt, dessverre");
        }
        return billett;
    }
    
    public boolean leggTilIProgram(int start, String navn,
            int slutt) {
        
        boolean leggesTil = true;
        if(antSolgte>0) {
            for (Programelement elem:program) {
                if(((elem.getStart() <= start) && (start <= elem.getSlutt())) || 
                        ((elem.getStart() <= slutt) && (slutt <= elem.getSlutt()))) {
                    leggesTil = false;
                }
            }
            if(leggesTil) {
                Programelement elem = new Programelement(navn, start, slutt);
                program.add(elem);
            }
        } else {    
            Programelement elem = new Programelement(navn, start, slutt);
            program.add(elem);
        }
        return leggesTil;
    }
    
    @Override
    public String toString() {
        return String.format("Arrangementsnavn: %s \nLokale: %s \nKontaktperson"
                + ": %s \nDato: %s \nPris: %d \nLedige billetter: %d", 
                arrangementsNavn, lokale, kontakt, dato, pris, 
                (lokale.getAntPlasser()-antSolgte));
    }
}


class Deltaker {
    private Person person;
    private String rolle;
    
    public Deltaker(Person person, String rolle) {
        this.person = person;
        this.rolle = rolle;
    }
    
    public void setPerson(Person person) {this.person = person;}
    public Person getPerson() {return person;}
    public void setRolle(String rolle) {this.rolle = rolle;}
    public String getRolle() {return rolle;}
    
    @Override
    public String toString() {
        return String.format("%d, %s", person, rolle);
    }
}

class Programelement {
    String navn;
    int start;
    int slutt;
    
    public Programelement(String navn, int start, int slutt) {
        this.navn = navn;
        this.start = start;
        this.slutt = slutt;
    }
    
    public void setNavn(String navn) {this.navn = navn;}
    public String getNavn() {return navn;}
    public void setStart(int start) {this.start = start;}
    public int getStart() {return start;}
    public void setSlutt(int slutt) {this.slutt = slutt;}
    public int getSlutt() {return slutt;}
    
    @Override
    public String toString() {
        return String.format("Navn: %s \nStarter: %s \nSlutter", navn, start, 
                slutt);
    }
}