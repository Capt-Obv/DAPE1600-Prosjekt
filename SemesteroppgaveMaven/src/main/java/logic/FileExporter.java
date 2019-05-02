package logic;

/**
 *
 * @author sarah
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import static logic.Semesteroppgave.main;

abstract class FileExporter {
/*
    abstract void writeDeltakerToFile(Deltaker pers) throws FileNotFoundException,
            IOException;
    abstract void writeLokaleToFile(Lokale lok) throws FileNotFoundException,
            IOException;
    abstract void writeArrangementToFile(Arrangement arr) throws FileNotFoundException,
            IOException;
    abstract void writeKontaktpersonToFile(Kontaktperson kpers) throws FileNotFoundException,
            IOException;

    public void writeToFile(String objType) throws InvalidObjectTypeException,
            FileNotFoundException, IOException {
        

        //Iterates over array of chosen object type and writes to file
        // (with parsing for csv-type)

        if (objType.toUpperCase().equals("DELTAKER")) {
            for(Deltaker pers: main.deltakerListe) {
                writeDeltakerToFile(pers);
            }
        } else if(objType.toUpperCase().equals("LOKALE")) {
            for(Lokale lok: main.lokaleListe) {
                writeLokaleToFile(lok);
            }
        } else if(objType.toUpperCase().equals("ARRANGEMENT")) {
            for(Arrangement arr: main.arrangementListe) {
                writeArrangementToFile(arr);
            }
        } else if(objType.toUpperCase().equals("KONTAKTPERSON")) {
            for(Kontaktperson pers: main.kontaktpersonListe) {
                writeKontaktpersonToFile(pers);
            }
        } else {
            throw new InvalidObjectTypeException("Not a valid objecttype");
        }
    }
*/
}
