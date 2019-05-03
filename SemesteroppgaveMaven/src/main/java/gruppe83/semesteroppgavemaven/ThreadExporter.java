
package gruppe83.semesteroppgavemaven;

import javafx.concurrent.Task;
import logic.FileExporterCSV;
import logic.FileExporterJOBJ;
import logic.InvalidFormatException;

/**
 *
 * @author sarah
 */

public class ThreadExporter extends Task<Void> {
    private String fileType;
    private String objType;
    
    public ThreadExporter(String fileType, String objType) {
        this.fileType = fileType;
        this.objType = objType;
    }
    
    @Override
    // method initiates FileExport either to csv or jobj-file.
    protected Void call() throws Exception {
        if(fileType.equals("csv")) {
            FileExporterCSV export = new FileExporterCSV(objType,String.format("%s.csv", objType));
            export.writeToFile(objType);
        } else if (fileType.equals("jobj")) {
            FileExporterJOBJ export = new FileExporterJOBJ(objType, String.format("%s.jobj", objType));
            export.writeToFile(objType);
        } else {
            throw new InvalidFormatException("Not a supported file-format");
        }
        try {   
            Thread.sleep(10000);
        } catch(InterruptedException e) {
            throw new InterruptedException("Fileexporting aborted");
        }
        return null;
    }
    
    @Override
    protected void succeeded() {
    }
    
    @Override
    protected void failed() {
        getException().printStackTrace();
    }
}
