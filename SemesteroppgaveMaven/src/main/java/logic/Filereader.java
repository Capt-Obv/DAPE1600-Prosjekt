package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import static logic.Semesteroppgave.main;
/**
 *
 * @author sarah
 */
abstract class Filereader {
    abstract Kontaktperson parseKontakt(String line);
    abstract Lokale parseLokale(String line);
    abstract void parseProgram(String line);
    abstract Deltaker parseDeltaker(String line);
    abstract Arrangement parseArrangement(String line);
    
    /* method checks if filetype is of the allowed two: jobj and csv, creates
    readers for the different filetypes and depending on strategy creates object
    for every line of file (with parsing for csv-files)
    */
    public void readFile(String filename, String objType, String fileType) throws IOException, 
            FileNotFoundException, ClassNotFoundException, InvalidTimeOverlapException, 
            InvalidObjectTypeException, InvalidFormatException {
        BufferedReader reader = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(fileType.equals("csv")) {
            reader = Files.newBufferedReader(Paths.get(filename));
            
        } else if(fileType.equals("jobj")) {
            fis = new FileInputStream(new File(filename));
            ois = new ObjectInputStream(fis);
        } else {
            throw new FileNotFoundException("Filetype must be either .csv or .jobj");
            
        }
        
        //parameters to check if we've reached the end of the Input-file.
         String line = null;
         boolean cont = true;
         
         
        while(((line=reader.readLine())!=null) || (cont)) {
            if(objType.toUpperCase().equals("DELTAKER")) {
                if(fileType.equals("csv")) {
                    main.deltakerListe.add(parseDeltaker(line));
                } else {
                    Deltaker nyDeltaker = (Deltaker) ois.readObject();
                    if(nyDeltaker != null) {
                        main.deltakerListe.add(nyDeltaker);
                    } else {
                        cont = false;
                    }
                }
            } else if(objType.toUpperCase().equals("ARRANGEMENT")) {
                if(fileType.equals("csv")) {
                    main.arrangementListe.add(parseArrangement(line));
                } else {
                    Arrangement arr = (Arrangement) ois.readObject();
                    
                    if(arr != null) {
                        main.arrangementListe.add(arr);
                    } else {
                        cont = false;
                    }
                }
            } else if(objType.toUpperCase().equals("KONTAKTPERSON")) {
                if(fileType.equals("csv")) {
                    main.kontaktPersonListe.add(parseKontakt(line));
                } else {
                    Kontaktperson pers = (Kontaktperson) ois.readObject();
                    if(pers != null) {
                        main.kontaktpersonListe.add(pers);
                    } else {
                        cont = false;
                    }
                }
            } else if(objType.toUpperCase().equals("LOKALE")) {
                if(fileType.equals("csv")) {
                    main.lokaleListe.add(parseLokale(line));
                } else {
                    Lokale lok = (Lokale) ois.readObject();
                    if(lok != null) {
                        main.lokalListe.add(lok);
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
                        for(Arrangement arr: main.arrangementListe) {
                            if(prgm.getArrangement().getNavn().equals(arr.getNavn())) {
                                leggesTil = arr.leggTilIProgram(prgm.getStart(), prgm.getNavn(),
                                        prgm.getSlutt());
                            }
                        }
                    } else {
                        cont = false;
                    }
                }
                if(leggesTil = false) {
                    throw new InvalidTimeOverlapException("Already an act performing"
                            + " at given time");
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
}
