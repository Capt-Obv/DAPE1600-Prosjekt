package logic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;


public class FilereaderCSV extends Filereader {

    @Override 
    public void initializeImport(File file, String objType) throws
            FileNotFoundException, IOException, ClassNotFoundException, InvalidTimeOverlapException,
            InvalidObjectTypeException, InvalidFormatException, InvalidDateFormatException, 
            NonExistingEventException {
        readFile(file, objType, "csv");
    }
}
