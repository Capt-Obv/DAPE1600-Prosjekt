
package gruppe83.semesteroppgavemaven;

import javafx.concurrent.Task;
import logic.FileExporterCSV;
import logic FileExporterJOBJ;

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
            FileExporterCSV export = new FileExporterCSV(String.format("%s.csv", objType));
            export.writeToFile(objType);
        } else if (fileType.equals("jobj")) {
            FileExporterJOBJ export = new FileExporterJOBJ();
            export.writeToFile(objType);
        try {   
            Thread.sleep(5000);
        } catch(InterruptedException e) {
        }
        return null;
    }
    
    protected void succeeded() {
        readWriteDone.run();
    }
}
}
