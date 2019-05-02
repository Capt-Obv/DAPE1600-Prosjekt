
package gruppe83.semesteroppgavemaven;

import javafx.concurrent.Task;
import logic.FileExporterCSV;
import logic FileExporterJOBJ;
import logic.InvalidFormatException;

/**
 *
 * @author sarah
 */

public class ThreadExporter extends Task<Void> {
    private Runnable readWriteDone;
    private String fileType;
    private String objType;
    
    public ThreadExporter(Runnable whenDone, String fileType, String objType) {
        this.readWriteDone = whenDone;
        this.fileType = fileType;
        this.objType = objType;
    }
    
    @Override
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
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            throw new InterruptedException("Fileexporting aborted");
        }
        return null;
    }
    
    protected void succeeded() {
        readWriteDone.run();
    }
}
