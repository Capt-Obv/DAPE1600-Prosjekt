/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author sarah
 */
public class FileExporterCSV extends FileExporter {
    private FileWriter writer = null;
    String objType = null;
    
    public FileExporterCSV(String objType, String filepath) throws FileNotFoundException,
            IOException {
        writer = new FileWriter(new File(filepath));
        this.objType = objType;
    }
    
    public void initializeExport() throws InvalidObjectTypeException, FileNotFoundException,
            IOException {
        writeToFile(objType);
        writer.close();
    }
    
    // methods for creating lines in csv-files (semi-colon separated) for 
    // the different object-types.
    
    @Override
    public void writeDeltakerToFile(Deltaker deltaker) throws FileNotFoundException, 
            IOException {
        writer.write(String.format("%s;%d;%s",deltaker.getPerson().getNavn(),
                deltaker.getPerson().getTelefonNr(),deltaker.getRolle()));
        writer.write("\n");
    }
    
    @Override
    public void writeLokaleToFile(Lokale lokale) throws FileNotFoundException,
            IOException {
        writer.write(String.format("%s;%d;%s", lokale.getNavn(), lokale.getAntPlasser(),
                lokale.getType()));
        writer.write("\n");
    }
    
    @Override
    public void writeArrangementToFile(Arrangement arr) throws
            FileNotFoundException, IOException {
        writer.write(String.format("%s;%s;%s;%s;%d", arr.getNavn(), arr.getKontakt().getNavn(),
                arr.getLokale().getNavn(), arr.getDato().toString(), arr.getPris()));
        
        //NOTE:  Kanskje vi skal skrive ut Programmet her også?
        
        
        writer.write("\n");
    }
    
    @Override
    public void writeKontaktpersonToFile(Kontaktperson kontakt) throws
            FileNotFoundException, IOException {
        writer.write(String.format("%s;%d;%s;%s;%s;%s", kontakt.getNavn(), kontakt.getTelefonNr(),
                kontakt.getEpostadresse(), kontakt.getOpplysninger(), kontakt.getNettside(),
                kontakt.getFirma()));
        writer.write("\n");
    }
}
