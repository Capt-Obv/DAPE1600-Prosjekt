/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author sarah
 */


public class FileExporterJOBJ extends FileExporter {
    private FileOutputStream fos = null;
    private ObjectOutputStream oos = null;
    private String objType = null;
    
    public FileExporterJOBJ(String objType, String filename) throws FileNotFoundException,
            IOException {
        fos = new FileOutputStream(new File(filename));
        this.objType = objType;
    }
    
    public void initializeExport() throws 
            FileNotFoundException, IOException, ClassNotFoundException, InvalidTimeOverlapException, 
            InvalidObjectTypeException, InvalidFormatException {
        writeToFile(objType);
        oos.close();
        fos.close();
    }
    
    @Override
    public void writeKontaktpersonToFile(Kontaktperson pers) throws
            FileNotFoundException, IOException {
        oos = new ObjectOutputStream(fos);
        oos.writeObject(pers);
    }
    
    @Override
    public void writeArrangementToFile(Arrangement arr) throws
            FileNotFoundException, IOException {
        oos = new ObjectOutputStream(fos);
        oos.writeObject(arr);
    }
    
    @Override
    public void writeLokaleToFile(Lokale lok) throws FileNotFoundException,
            IOException {
        oos = new ObjectOutputStream(fos);
        oos.writeObject(lok);
    }
    
    @Override
    public void writeBillettToFile(Arrangement arr) throws FileNotFoundException,
            IOException {
        oos = new ObjectOutputStream(fos);
        for(int i=0; i<arr.getAntSolgte(); i++) {
            oos.writeObject(arr.getBillett(i));
        }
    }
    
}
