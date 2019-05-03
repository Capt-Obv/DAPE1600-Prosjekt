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

/**
 *
 * @author sarah
 */

public class FileExporterCSV extends FileExporter {

    private FileWriter writer = null;
    String objType = null;

    public FileExporterCSV(String objType, String filename) throws FileNotFoundException,
            IOException {
        writer = new FileWriter(new File(filename));
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
    public void writeBillettToFile(Arrangement arr) throws FileNotFoundException,
            IOException {
        for(int i=0; i<arr.getAntSolgte(); i++) {
            Billett bill = arr.getBillett(i);
            writer.write(String.format("%s;%d;%s;%d;%s;%d;%s", bill.getSted().getNavn(),
                    bill.getPlassNr(), bill.getDato().toString(), bill.getPris(),
                    bill.getPerson().getNavn(), bill.getPerson().getTelefonNr(),
                    bill.getArrangement().getNavn()));
            writer.write("\n");
        }
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
        writer.write(String.format("%s;%s;%d;%s;%s;%d;%s;%s;%s;%s;%s;%d", arr.getNavn(),
                arr.getLokale().getNavn(), arr.getLokale().getAntPlasser(),
                arr.getLokale().getType(),
                arr.getKontakt().getNavn(), arr.getKontakt().getTelefonNr(),
                arr.getKontakt().getEpostadresse(), arr.getKontakt().getOpplysninger(),
                arr.getKontakt().getFirma(), arr.getKontakt().getNettside(),
                arr.getDato().toString(), arr.getPris()));

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
