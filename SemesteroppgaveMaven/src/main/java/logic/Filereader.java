package logic;

import gruppe83.semesteroppgavemaven.FXMLController;
import static gruppe83.semesteroppgavemaven.MainApp.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 *
 * @author sarah
 */
/*
abstract class Filereader {

    abstract void initializeImport(File file, String objType) throws
            FileNotFoundException, IOException, ClassNotFoundException, InvalidTimeOverlapException,
            InvalidObjectTypeException, InvalidFormatException, InvalidDateFormatException;

    /* method checks if filetype is of the allowed two: jobj and csv, creates
    readers for the different filetypes and depending on strategy creates object
    for every line of file (with parsing for csv-files)
    */

    public void readFile(File inputfile, String objType, String fileType) throws IOException,
            FileNotFoundException, ClassNotFoundException, InvalidTimeOverlapException,
            InvalidObjectTypeException, InvalidFormatException , InvalidDateFormatException{
        BufferedReader reader = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(fileType.equals("csv")) {
            reader = new BufferedReader(new FileReader(inputfile));

        } else if(fileType.equals("jobj")) {
            fis = new FileInputStream(inputfile);
            ois = new ObjectInputStream(fis);
        } else {
            throw new FileNotFoundException("Filetype must be either .csv or .jobj");

        }

        //parameters to check if we've reached the end of the Input-file or
        // if the event in question is full and the ticket-sale is closed.
         String line = null;
         boolean cont = true;
         boolean ledig = true;


        while((((line=reader.readLine())!=null) || (cont)) && (ledig)) {
            if(objType.toUpperCase().equals("ARRANGEMENT")) {
                if(fileType.equals("csv")) {
                    parseArrangement(line);
                } else {
                    Arrangement arr = (Arrangement) ois.readObject();

                    if(arr != null) {
                        cont = true;
                    } else {
                        cont = false;
                    }
                }
            } else if(objType.toUpperCase().equals("KONTAKTPERSON")) {
                if(fileType.equals("csv")) {
                    parseKontakt(line);
                } else {
                    Kontaktperson pers = (Kontaktperson) ois.readObject();
                    if(pers != null) {
                        cont = true;
                    } else {
                        cont = false;
                    }
                }
            } else if(objType.toUpperCase().equals("LOKALE")) {
                if(fileType.equals("csv")) {
                    parseLokale(line);
                } else {
                    Lokale lok = (Lokale) ois.readObject();
                    if(lok != null) {
                        cont = true;
                    } else {
                        cont = false;
                    }
                }
            } else if(objType.toUpperCase().equals("PROGRAM")) {
                Boolean leggesTil = false;
                if(fileType.equals("csv")) {
                    leggesTil = parseProgram(line);
                } else {
                    Programelement prgm = (Programelement) ois.readObject();
                    if(prgm != null) {
                        for(int i=0; i<FXMLController.getArrangementListSize(); i++) {
                            Arrangement arr = FXMLController.getArrangement(i);
                            if(prgm.getArrangement().getNavn().equals(arr.getNavn())) {
                                leggesTil = arr.leggTilIProgram(prgm.getStart(), prgm.getNavn(),
                                        prgm.getSlutt());
                            }
                        }
                    } else {
                        cont = false;
                    }
                }
                if(leggesTil == false) {
                    throw new InvalidTimeOverlapException("Already an act performing"
                            + " at given time");
                }

            } else if(objType.toUpperCase().equals("BILLETT")) {
                if(fileType.equals("csv")) {
                    ledig = parseBillett(line);
                } else {
                    Billett bill = (Billett) ois.readObject();
                    ledig = bill.getArrangement().billettsalg(bill.getPerson());
                }
            } else {
                throw new InvalidObjectTypeException("Not a valid object type");
            }
        }
        reader.close();
        if(fis!=null) {
            fis.close();
        }
        if(ois!=null) {
            ois.close();
        }
    }

    public static int parseTall(String testStr, String errorMessage)
            throws InvalidFormatException {
        int tall;
        try {
            tall = Integer.parseInt(testStr);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException(errorMessage);
        }
        return tall;
    }

    public static boolean checkEmail(String testStr, String errorMessage)
            throws InvalidFormatException {
        boolean trueEmail = false;
        if(testStr.contains("@")) {
            trueEmail = true;
        } else {
            throw new InvalidFormatException(errorMessage);
        }
        return trueEmail;
    }

    public boolean parseBillett(String line) throws InvalidFormatException,
            InvalidDateFormatException {
        Arrangement arr = null;
        boolean salg = false;

        String[] del = line.split(";");

        String arrangementNavn = del[0];
        for(int i=0; i<FXMLController.getArrangementListSize(); i++) {
            Arrangement a = FXMLController.getArrangement(i);
            if(arrangementNavn.toUpperCase().equals(a.getNavn().toUpperCase())) {
                arr = a;
            }
        }
        if(arr!= null) {
            String navn = del[1];
            int telefonNr = parseTall(del[2], "Telephone number of buyer not a number");
            Person kjøper = new Person(navn, telefonNr);
            salg = arr.billettsalg(kjøper);
            if(salg) {
                arr.leggTilArtist(kjøper, "Deltaker");
            }
        } else {
            throw new InvalidFormatException("Event in question does not exist");
        }
        return salg;
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
            for(int i=0; i<FXMLController.getArrangementListSize(); i++) {
                Arrangement arr = FXMLController.getArrangement(i);
                if(arrangement.equals(arr.getNavn())) {
                        leggesTil = arr.leggTilIProgram(start, navn, slutt);
                }
            }
        }
        return leggesTil;
    }

    public Lokale parseLokale(String line) throws InvalidFormatException {
        Lokale lok = null;
        String[] del = line.split(";");
        if(del.length < 3) {
            throw new InvalidFormatException("CSV-formats require data to"
                        + " be split by semicolon");
        } else {
            String navn = del[0];
            int antPlasser = parseTall(del[1], "Number of seats is not a number");
            String type = del[2];
            lok = new Lokale(navn, antPlasser, type);
        }
        return lok;

    }

    public Arrangement parseArrangement(String line) throws InvalidFormatException,
        InvalidDateFormatException {
        Arrangement arr = null;
        Dato arrDato = null;
        int mnd = 0;
        int dg = 0;
        int år = 0;
        Kontaktperson kontakt = null;
        Lokale lokasjon = null;
        int pris = 0;

        String[] del = line.split(";");
        if(del.length<11) {
            throw new InvalidFormatException("CSV-formats require data to be"
                        + " split by semicolon.");
        } else {
            String arrNavn = del[0];
            for(int i=0; i<FXMLController.getArrangementListSize(); i++) {
                Lokale lok = FXMLController.getArrangement(i).getLokale();
                if(del[1].equals(lok.getNavn())) {
                    lokasjon = lok;
                } else {
                    int antPlasser = parseTall(del[2], "Number of seats not a "
                            + "number");
                    lokasjon = new Lokale(del[1],antPlasser,del[3]);
                }
            }
            for(int i=0; i<FXMLController.getArrangementListSize(); i++) {
                Kontaktperson pers = FXMLController.getArrangement(i).getKontakt();
                if(del[4].equals(pers.getNavn())) {
                    kontakt = pers;
                } else {
                    int telefonNr = parseTall(del[5], "Telephone number of contact"
                            + " not a number");
                    kontakt = new Kontaktperson(del[4], telefonNr, del[5], del[6],
                     del[7], del[8]);
                }
            }
            String[] datoDel = del[9].split(".");
            if(datoDel.length<3) {
                throw new InvalidDateFormatException("Eventdates "
                            + "must be on the format"
                        + " yyyy.mm.dd");
            } else {
                år = parseTall(datoDel[0], "Year of event not a number");
                mnd = parseTall(datoDel[1], "Month of event not a number");
                dg = parseTall(datoDel[2], "Day of event not a number");
            }
            arrDato = new Dato(år, mnd, dg);
            pris = parseTall(del[10], "Price is not an integer");
            arr = new Arrangement(arrNavn, lokasjon, kontakt, arrDato, pris);
        }
        return arr;
    }

    public Kontaktperson parseKontakt(String line) throws InvalidFormatException {
        Kontaktperson pers = null;
        String epostadresse = null;
        String[] del = line.split(";");
        if(del.length < 4) {
            throw new InvalidFormatException("CSV-formats require data to be"
                        + "split by semicolon.");
        } else {
            String navn = del[0];
            int telefonNr = parseTall(del[1],"Telephone number is not a number.");
            if(checkEmail(del[2], "Email adress is not"
                        + " a valid emailadress.")) {
                epostadresse = del[2];
            }
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
*/
