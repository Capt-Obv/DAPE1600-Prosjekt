
package gruppe83.semesteroppgavemaven.logic;

/**
 *
 * @author sarah
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

abstract class FileExporter {
abstract void writeDeltakerToFile(FileWriter file, Deltaker pers) throws FileNotFoundException,
        IOException;

    public void writeToFile(String objType, String filepath) {
        /*
        try { 
            FileWriter file = new FileWriter(new File(filepath)); 
            if (objType.toUpperCase().equals("DELTAKER")) {
                for(Deltaker pers: main.deltakerListe) {
                    writeDeltakerToFile(file, pers);
                }
            } else if(objType.toUpperCase().equals("LOKALE")) {
                
            } else if(objType.toUpperCase().equals("ARRANGEMENT")) {
                
            } else if(objType.toUpperCase().equals("KONTAKTPERSON")) {
                
            }
            file.close();
        } catch (FileNotFoundException e) {
            // Gjør noe
        } catch (IOException e) { 
        // Gjøre noe */
    } 
}

