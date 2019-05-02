package logic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilereaderCSV extends Filereader {

    @Override
    Kontaktperson parseKontakt(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Lokale parseLokale(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void parseProgram(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Deltaker parseDeltaker(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Arrangement parseArrangement(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public FilereaderCSV(String filename, String objType) throws 
            FileNotFoundException, IOException, ClassNotFoundException, InvalidTimeOverlapException, 
            InvalidObjectTypeException, InvalidFormatException {
        readFile(filename, objType, "CSV");
    }
    
    public boolean parseProgram(String line) throws InvalidFormatException {
        String[] del = line.split(";");
        boolean leggesTil = false;
        if(del.length<4) {
            throw new InvalidFormatException("CSV-formats require data to"
                        + " be split by semicolon");
        } else {
            int start = parseTall(del[0], "Start time of programelement not"
                        + " a number");
            String navn = del[1];
            int slutt = parseTall(del[2], "End time of programelement not "
                        + " a number");
            String arrangement = del[3];
            for(Arrangement arr: main.arrangementListe) {
                if(arrangement.equals(arr.getNavn())) {
                        leggesTill = arr.leggTilIProgram(start, navn, slutt);
                }
            }
        }
        return leggesTil;
    }
    
    public Lokale parseLokale(String line) throws InvalidFormatException {
        /*
        Lokale lok = null;
        String[] del = line.split(";");
        if(del.length < 2) {
            throw new InvalidFormatException("CSV-formats require data to"
                        + " be split by semicolon");
        } else {
            String navn = del[0];
            int antPlasser = parseTall(del[1], "Number of seats is not a number");
            lok = new Lokale(navn, antPlasser);
        }
        return lok;

    }
    
    public Deltaker parseDeltaker(String line) throws InvalidFormatException {
        Person nyPerson = null;
        Deltaker deltaker = null;
        String[] del = line.split(";");
        if(del.length < 4) {
            throw new InvalidFormatException("CSV-formats require data to "
                        + "be split by semicolon");
        } else {
            String navn = del[0];
            int telefonNr = parseTall(del[1], "Telephone number is not a number");
            //Legg til masse tester for å sjekke riktig data
            nyPerson = new Person(navn, telefonNr);
            if(del[2].toUpperCase().equals("DELTAKER")) {
                String arrangement = del[3];
                for(Arrangement arr:main.arrangementListe) {
                    if(arrangement.equals(arr.getNavn())) {
                        boolean salg = arr.billettsalg(nyPerson);
                    }
                }
            } else {
                String arrangement = del[3];
                for(Arrangement arr:main.arrangementListe) {
                    if(arrangement.equals(arr.getNavn())) {
                        arr.leggTilArtist(nyPerson, del[2]);
                    }
                }
            }
            deltaker = new Deltaker(nyPerson, del[2]);
        }
        return deltaker;
    }
    
    public Arrangement parseArrangement(String line) throws InvalidFormatException, 
        InvalidDateFormatException {
        Arrangement arr = null;
        Dato arrDato = null;
        Kontaktperson kontakt = null;
        Lokale lokasjon = null;
        int pris = 0;
        
        String[] del = line.split(";");
        if(del.length<5) {
            throw new InvalidFormatException("CSV-formats require data to be"
                        + " split by semicolon.");
        } else {
            String arrNavn = del[0];
            for(Lokale lok: main.lokaleListe) {
                if(del[1].equals(lok.getNavn())) {
                    lokasjon = lok;
                }
            }
            for(Kontaktperson pers: main.kontaktListe) {
                if(del[2].equals(pers.getNavn())) {
                    kontakt = pers;
                }
            }
            String[] datoDel = del[3].split(".");
            if(datoDel.length<3) {
                throw new InvalidDateFormatException("Eventdates "
                            + "must be on the format"
                        + " yyyy.mm.dd");
            } else {
                int år = parseTall(datoDel[0], "Year of event not a number");
                int mnd = parseTall(datoDel[1], "Month of event not a number");
                int dg = parseTall(datoDel[2], "Day of event not a number");
            }
            arrDato = new Dato(år, mnd, dg);
            pris = parseTall(del[4], "Price is not an integer");
            arr = new Arrangement(arrNavn, lokasjon, kontakt, arrDato, pris);
        }
        return arr;
    }
    
    public Kontaktperson parseKontakt(String line) throws InvalidFormatException {
        Kontaktperson pers = null;
        String[] del = line.split(";");
        if(del.length < 4) {
            throw new InvalidFormatException("CSV-formats require data to be"
                        + "split by semicolon.");
        } else {
            String navn = del[0];
            int telefonNr = parseTall(del[1],"Telephone number is not a number.");
            String epostadresse = parseEmail(del[2], "Email adress is not"
                        + " a valid emailadress.");
            String opplysninger = del[3];
            if(del.length == 5) {
                String nettside = del[4];
                pers = new Kontaktperson(navn, telefonNr,
                        epostadresse, opplysninger, nettside);
            } else if(del.length == 6) {
                String nettside = del[4];
                String firma = del[5];
                pers = new Kontaktperson(navn, telefonNr,
                        epostadresse, opplysninger, nettside, firma);
            } else {
                pers = new Kontaktperson(navn, telefonNr, 
                        epostadresse, opplysninger);
            }
        }
        return pers;
    }
}