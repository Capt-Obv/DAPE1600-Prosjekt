/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author sarah
 */
public class FilereaderJOBJ extends Filereader{
    
    @Override
    public void initializeImport(File file, String objType) throws 
            FileNotFoundException, IOException, ClassNotFoundException, InvalidTimeOverlapException, 
            InvalidObjectTypeException, InvalidFormatException {
<<<<<<< HEAD
        readFile(file, objType, "jobj");
=======
        /*
        readFile(filename, objType, "JOBJ");
*/
>>>>>>> 6295515fdb7b3afb38a48b82714d171776b65fbf
    }
}
