package semesteroppgave;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Filereader {
    
    public static void readFile(String filename, String objType, String fileType) throws IOException, 
            FileNotFoundException {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(filename));
            String line = null;
            
            while((line=reader.readLine())!=null) {
               if(objType.toUpperCase().equals("BILLETT")) {
                   personListe.add(parsePerson(line,fileType));
               } else if(objType.toUpperCase().equals("ARRANGEMENT")) {
                   arrangementListe.add(parseArrangement(line,fileType));
               } else if(objType.toUpperCase().equals("LOKALE")) {
                   lokaleListe.add(parseLokale(line,fileType));
               } else if(objType.toUpperCase().equals("KONTAKTPERSON")) {
                   kontaktPersonListe.add(parseKontakt(line,fileType));
               }
            }
            
            reader.close();
         
        } catch (FileNotFoundException e) {
            // Håndter med å lage en exceptionhandler som vi kan kaste FileNotFound
            // og IOException til
        } catch (IOException e) {
            //Ditto
        }
    }
    
    public static Person parsePerson(String line, String fileType) {
        if(fileType.equals("csv")) {
            String[] del = line.split(";");
            if(del.length < 2) {
                throw new InvalidFormatException("CSV-formats require data to "
                        + "be split by semicolon");
            } else {
                String navn = del[0];
                int telefonNr = parseTall(del[1], "Telephone number is not a number");
                //Legg til masse tester for å sjekke riktig data
                Person nyPerson = new Person(navn, telefonNr);
            }
        } else if(fileType.equals("jobj")) {
            
        }
    }
    
    public static Arrangement parseArrangement(String line, String objType) {
    }
    
    public static Kontaktperson parseKontakt(String line, String fileType) {
        Kontaktperson pers;
        if(fileType.equals("csv")) {
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
        }
        
        return pers;
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