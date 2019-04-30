package semesteroppgave;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    /*
    public void readFile(String filename, String objType, String fileType) throws IOException, 
            FileNotFoundException {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(filename));
            String line = null;
            
            while((line=reader.readLine())!=null) {
               if(objType.toUpperCase().equals("DELTAKER")) {
                   main.deltakerListe.add(parseDeltaker(line));
                   // lister lagres et annet sted
               } else if(objType.toUpperCase().equals("ARRANGEMENT")) {
                   main.arrangementListe.add(parseArrangement(line));
               } else if(objType.toUpperCase().equals("KONTAKTPERSON")) {
                   main.kontaktPersonListe.add(parseKontakt(line));
               } else if(objType.toUpperCase().equals("LOKALE")) {
                   main.lokaleListe.add(parseLokale(line));
               } else if(objType.toUpperCase().equals("PROGRAM")) {
                   parseArrangement(line);
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
    }*/
}
