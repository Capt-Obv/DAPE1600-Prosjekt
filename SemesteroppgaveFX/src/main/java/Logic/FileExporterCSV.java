/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

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
            writer.write("\n");
        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            //
        }
    }
    
    public void writeLokaleToFile(FileWriter writer, Lokale lokale) throws FileNotFoundException,
            IOException {
        try {
            writer.write(String.format("%s;%d;%s", lokale.getNavn(), lokale.getAntPlasser(),
                lokale.getType()));
            writer.write("\n");
        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            //
        }
    }
    
    public void writeArrangementToFile(FileWriter writer, Arrangement arr) throws
            FileNotFoundException, IOException {
        writer.write(String.format("%s;%s;%s;%s;%d", arr.getNavn(), arr.getKontakt().getNavn(),
                arr.getLokale().getNavn(), arr.getDato().toString(), arr.getPris()));
        writer.write("\n");
    }
    
    public void writeKontaktpersonToFile(FileWriter writer, Kontaktperson kontakt) throws
            FileNotFoundException, IOException {
        writer.write(String.format("%s;%d;%s;%s;%s;%s", kontakt.getNavn(), kontakt.getTelefonNr(),
                kontakt.getEpostadresse(), kontakt.getOpplysninger(), kontakt.getNettside(),
                kontakt.getFirma()));
        writer.write("\n");
    }
    
    public void writeProgramToFile(FileWriter writer, Arrangement arr) throws
            FileNotFoundException, IOException {
        //Kom på noe lur måte å gjøre dette på
    }
}

