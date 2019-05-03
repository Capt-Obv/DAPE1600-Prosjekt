package logic;

package logic;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;


/**
 *
 * @author sarah
 */

public class Arrangement implements Serializable {
    private String arrangementsNavn;
    private Kontaktperson kontakt;
    private Lokale lokale;
    private transient ArrayList<Deltaker> deltakere;
    private ArrayList<Programelement> program;
    private transient Billett[] solgteBilletter;
    private Dato dato;
    private int pris;
    private static int antSolgte = 0;

    public Arrangement(String arrangementsNavn, Lokale lokale, Kontaktperson
            kontakt, LocalDate dato, int pris) {
        this.arrangementsNavn = arrangementsNavn;
        this.kontakt = kontakt;
        this.lokale = lokale;
        this.pris = pris;
        solgteBilletter = new Billett[lokale.getAntPlasser()];
        deltakere = new ArrayList();
        program = new ArrayList();
        this.dato = dato;
    }

    //get-set methods
    public void setNavn(String arrangementsNavn) {this.arrangementsNavn
            = arrangementsNavn;}
    public String getNavn() {return arrangementsNavn;}
    public void setKontakt(Kontaktperson kontakt) {this.kontakt = kontakt;}
    public Kontaktperson getKontakt() {return kontakt;}
    public void setLokale(Lokale lokale) {this.lokale = lokale;}
    public Lokale getLokale() {return lokale;}
    public void setLocalDate(LocalDate dato) {this.dato = dato;}
    public LocalDate getDato() {return dato;}
    public void setPris(int pris) {this.pris = pris;}
    public int getPris() {return pris;}
    public int getAntSolgte() {return antSolgte;}
    public Billett getBillett(int indeks) {return solgteBilletter[indeks];}

    // method for adding performers (participants of event that do not
    // require a ticket

    public void leggTilArtist(Person pers, String rolle) {
        Deltaker artist = new Deltaker(pers, rolle);
        deltakere.add(artist);
    }

    //method for selling tickets if there are still tickets available
    public boolean billettsalg(Person pers) {
        boolean billett = false;
        if(antSolgte < lokale.getAntPlasser()) {
            Billett nybillett = new Billett(lokale, antSolgte, dato, pris, pers, this);
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

    // iterates over program elements and checks if an act can be added
    // in the given timeline
    public boolean leggTilIProgram(LocalTime start, String navn,
            LocalTime slutt) {

        boolean leggesTil = true;
        if(antSolgte>0) {
            for (Programelement elem:program) {
                /*
                if(((elem.getStart() <= start) && (start <= elem.getSlutt())) ||
                        ((elem.getStart() <= slutt) && (slutt <= elem.getSlutt()))) {
*/
                if(elem.getStart().compareTo(start)<0&&(start.compareTo(elem.getSlutt())<0)||
                        (elem.getStart().compareTo(slutt)<0 && (slutt.compareTo(slutt)<0))){
                    leggesTil = false;
                }
            }
            if(leggesTil) {
                Programelement elem = new Programelement(navn, start, slutt, this);
                program.add(elem);
            }
        } else {
            Programelement elem = new Programelement(navn, start, slutt, this);
            program.add(elem);
        }
        return leggesTil;
    }

    // returnes what acts are playing at a chosen time
    public Programelement getProgramelement(LocalTime tidspunkt) {
        Programelement prog = null;
        for(Programelement elem:program) {
            if((elem.getStart().compareTo(tidspunkt)<0) && (elem.getSlutt().compareTo(tidspunkt)>0)) {
                prog = elem;
            }
        }
        return prog;
    }

    public String programToString(){
        String message = "";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("hh:mm");
        for (Programelement elem:program){
            message += elem.start.format(dateFormat)+"-"+elem.slutt.format(dateFormat)+": "+elem.getNavn();
        }
        return message;
    }
    @Override
    public String toString() {
        return String.format("Arrangementsnavn: %s \nLokale: %s \nKontaktperson"
                + ": %s \nDato: %s \nPris: %d \nLedige billetter: %d",
                arrangementsNavn, lokale, kontakt, dato, pris,
                (lokale.getAntPlasser()-antSolgte));
    }
}


class Deltaker implements Serializable {
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

class Programelement implements Serializable {
    String navn;
    LocalTime start;
    LocalTime slutt;
    Arrangement arr;

    public Programelement(String navn, LocalTime start, LocalTime slutt, Arrangement arr) {
        this.navn = navn;
        this.start = start;
        this.slutt = slutt;
        this.arr = arr;
    }

    public void setNavn(String navn) {this.navn = navn;}
    public String getNavn() {return navn;}
    public void setStart(LocalTime start) {this.start = start;}
    public LocalTime getStart() {return start;}
    public void setSlutt(LocalTime slutt) {this.slutt = slutt;}
    public LocalTime getSlutt() {return slutt;}
    public Arrangement getArrangement() {return arr;}
    public void setArrangement(Arrangement arr) {this.arr = arr;}

    @Override
    public String toString() {
        return String.format("Navn: %s \nArrangement: %s \nStarter: %d "
                + "\nSlutter: %d", navn, arr.getNavn(), start,
                slutt);
    }
}
