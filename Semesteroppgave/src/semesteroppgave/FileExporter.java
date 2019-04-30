
package semesteroppgave;

/**
 *
 * @author sarah
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static semesteroppgave.Semesteroppgave.main;

abstract class FileExporter {
abstract void writeDeltakerToFile(FileWriter file, Deltaker pers) throws FileNotFoundException,
        IOException;
abstract void writeLokaleToFile(FileWriter file, Lokale lok) throws FileNotFoundException,
        IOException;
abstract void writeArrangementToFile(FileWriter file, Arrangement arr) throws FileNotFoundException,
        IOException;
abstract void writeKontaktpersonToFile(FileWriter file, Kontaktperson kontakt) throws FileNotFoundException,
        IOException;

    public void writeToFile(String objType, String filename, String fileType) throws FileNotFoundException,
             IOException, ClassNotFoundException, InvalidObjectTypeException {
        FileWriter file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        //checks what type of file user wishes to write to (either csv or jobj)
        
        if(objType.equals("csv")) {
            file = new FileWriter(new File(filename));
        } else if(objType.equals("jobj")) {
            fos = new FileOutputStream(new File(filename));
        } else {
            throw new FileNotFoundException("Filetype must be either .csv or .jobj");
        }
        
        //Iterates over array of chosen object type and writes to file
        // (with parsing for csv-type)
        
        if (objType.toUpperCase().equals("DELTAKER")) {
            for(Deltaker pers: main.deltakerListe) {
                if(objType.equals("csv")) {
                    writeDeltakerToFile(file, pers);
                } else {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(pers);
                }
            }
        } else if(objType.toUpperCase().equals("LOKALE")) {
            for(Lokale lok: main.lokaleListe) {
                if(objType.equals("csv")) {
                    writeLokaleToFile(file, lok);
                } else {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(lok);
                }
            }    
        } else if(objType.toUpperCase().equals("ARRANGEMENT")) {
            for(Arrangement arr: main.arrangementListe) {
                if(objType.equals("csv")) {
                    writeArrangementToFile(file, arr);
                } else {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(arr);
                }
            }    
        } else if(objType.toUpperCase().equals("KONTAKTPERSON")) {
            for(Kontaktperson pers: main.kontaktpersonListe) {
                if(objType.equals("csv")) {
                    writeKontaktpersonToFile(file, pers);
                } else {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(pers);
                }
            }    
        } else {
            throw new InvalidObjectTypeException("Not a valid objecttype");
        }
        
        if(file!=null) {
            file.close();
        }
        if(fos!=null) {
            fos.close();
        }
    } 
}

