package logic;

/**
 *
 * @author sarah
 */

import gruppe83.semesteroppgavemaven.FXMLController;
import java.io.FileNotFoundException;
import java.io.IOException;

abstract class FileExporter {

    abstract void writeLokaleToFile(Lokale lok) throws FileNotFoundException,
            IOException;
    abstract void writeArrangementToFile(Arrangement arr) throws FileNotFoundException,
            IOException;
    abstract void writeKontaktpersonToFile(Kontaktperson kpers) throws FileNotFoundException,
            IOException;
    abstract void writeBillettToFile(Arrangement arr) throws FileNotFoundException,
            IOException;

    public void writeToFile(String objType) throws InvalidObjectTypeException,
            FileNotFoundException, IOException {


        //Iterates over array of chosen object type and writes to file
        // (with parsing for csv-type)

        for(int i=0; i<FXMLController.getArrangementListSize(); i++) {
            if(objType.toUpperCase().equals("LOKALE")) {

                Lokale lok = FXMLController.getArrangement(i).getLokale();
                writeLokaleToFile(lok);

            } else if(objType.toUpperCase().equals("ARRANGEMENT")) {
                Arrangement arr = FXMLController.getArrangement(i);
                writeArrangementToFile(arr);

            } else if(objType.toUpperCase().equals("KONTAKTPERSON")) {
                Kontaktperson pers = FXMLController.getArrangement(i).getKontakt();
                writeKontaktpersonToFile(pers);
            
            } else if(objType.toUpperCase().equals("BILLETT")) {
                Arrangement arr = FXMLController.getArrangement(i);
                writeBillettToFile(arr);
            } else {
                throw new InvalidObjectTypeException("Not a valid objecttype");
            }
        }
    }
}
