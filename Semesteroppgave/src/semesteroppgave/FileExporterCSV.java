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

    public void writeDeltakerToFile(FileWriter writer, Deltaker deltaker) throws FileNotFoundException, 
            IOException {
        writer.append(deltaker.getPerson().getNavn());
        writer.append(";");
        writer.append(String.format("%d", deltaker.getPerson().getTelefonNr()));
        writer.append(";");
        writer.append(deltaker.getRolle());
        writer.append("\n");
        
    }

}
