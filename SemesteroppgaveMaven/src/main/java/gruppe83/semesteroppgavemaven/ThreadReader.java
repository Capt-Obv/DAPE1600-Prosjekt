
package gruppe83.semesteroppgavemaven;

/**
 *
 * @author sarah
 */

import javafx.concurrent.Task;
import javafx.stage.Stage;

public class ThreadReader extends Task<Void> {
    private Runnable readWriteDone;
    private Stage stage;
    
    public ThreadReader(Runnable whenDone, Stage stage) {
        this.readWriteDone = whenDone;
        this.stage = stage;
    }
    
    @Override
    protected Void call() throws Exception {
        try { 
            FiletypeChooser chooser = new FiletypeChooser();
            chooser.chooseFile(stage);
            Thread.sleep(5000);
        } catch(InterruptedException e) {
        }
        return null;
    }
    
    protected void succeeded() {
        readWriteDone.run();
    }
}
