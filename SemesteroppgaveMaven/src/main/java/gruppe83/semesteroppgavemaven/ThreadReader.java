
package gruppe83.semesteroppgavemaven;

/**
 *
 * @author sarah
 */

import javafx.concurrent.Task;

public class ThreadReader extends Task<Void> {
    private Runnable readWriteDone;
    
    public ThreadReader(Runnable whenDone) {
        this.readWriteDone = whenDone;
    }
    
    @Override
    protected Void call() throws Exception {
        try { 
            FiletypeChooser chooser = new FiletypeChooser();
            Thread.sleep(5000);
        } catch(InterruptedException e) {
        }
        return null;
    }
    
    protected void succeeded() {
        readWriteDone.run();
    }
}
