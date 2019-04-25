/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesteroppgave;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sarah
 */
public class FileExporterCSV extends FileExporter {

    public FileExporterCSV(String objType, String filepath) {
        writeToFile(objType, filepath);
    }
    public void writeDeltakerToFile(FileWriter writer, Deltaker deltaker) throws FileNotFoundException, 
            IOException {
        try {
            writer.write(String.format("%s;%d;%s",deltaker.getPerson().getNavn(),
                deltaker.getPerson().getTelefonNr(),deltaker.getRolle()));
        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            //
        }
    }
    
    public static void writeLokaleToFile(FileWriter writer, Lokale lokale) throws FileNotFoundException,
            IOException {
        try {
            writer.write(String.format("%s;%d;%s", lokale.getNavn(), lokale.getAntPlasser(),
                lokale.getType()));
        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            //
        }
    }

}
