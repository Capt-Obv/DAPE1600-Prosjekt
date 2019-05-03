
package gruppe83.semesteroppgavemaven;

/**
 *
 * @author sarah
 */

import java.io.File;
import javafx.concurrent.Task;
import logic.FilereaderCSV;
import logic.FilereaderJOBJ;
import logic.InvalidFormatException;

public class ThreadReader extends Task<Void> {
    private Runnable readDone;
    private File file;

    public ThreadReader(Runnable whenDone, File file) {
        this.readDone = whenDone;
        this.file = file;
    }

    
    // method checks if fileparameter is a csv-file or jobj-file
    // and initializes the import.
    @Override
    protected Void call() throws Exception {
        String filename = file.getName();
        String[] filenameParts = filename.split(".");
        if(filenameParts[1].equals("csv")) {
            FilereaderCSV reader = new FilereaderCSV();
            reader.initializeImport(file, filenameParts[0]);
        } else if(filenameParts[1].equals("jobj")) {
            FilereaderJOBJ reader = new FilereaderJOBJ();
            reader.initializeImport(file, filenameParts[0]);
        } else {
            throw new InvalidFormatException("Not a valid filetype. Choose"
                    + " either csv or jobj");
        }
        try {
            Thread.sleep(10000);
        } catch(InterruptedException e) {
            throw new InterruptedException("Fileimport aborted");
        }
        return null;
    }

    protected void succeeded() {
        readDone.run();
    }
}
