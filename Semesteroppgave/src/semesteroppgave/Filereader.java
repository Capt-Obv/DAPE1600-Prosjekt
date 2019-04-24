package semesteroppgave;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Filereader {
    private String filename;
    ArrayList<Person> personListe;
    ArrayList<Arrangement> arrangementListe;
    
    public Filereader(String filename, String objType) {
        this.filename = filename;
        String[] parts = filename.split(".");
        String fileType = parts[1];
        readFile(filename, objType, fileType);
    }
    
    public void readFile(String filename, String objType, String fileType) throws IOException, 
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
               } else if(objType.toUpperCase().equals("DELTAKER")) {
                   deltakerListe.add(parseDeltaker(line,fileType));
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
    
    public Person parsePerson(String line, String fileType) {
        if(fileType.equals("csv")) {
            String[] liste = line.split(";");
            //Legg til masse tester for å sjekke riktig data
            Person nyPerson = new Person(navn, telefonNr);
        } else if(fileType.equals("jobj")) {
            
        }
    }
    
    public Arrangement parseArrangement(String line, String objType) {
    }
}