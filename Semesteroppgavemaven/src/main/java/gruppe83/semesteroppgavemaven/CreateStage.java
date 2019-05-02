/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe83.semesteroppgavemaven;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Andrea
 */
/*
public class CreateStage extends Window {
    private static Stage inputskjema;
     private TableView<logic.Arrangement> tblArrangement;

    public CreateStage(TableView<logic.Arrangement> ) {
        tblArrangement = new TableView();        

        StackPane root = new StackPane();
        root.getChildren().add(tblArrangement);        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InputSkjema.fxml"));
                try {
                    root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setOpacity(1);
                    stage.setTitle("Lag nytt arrangement");
                    stage.setScene(new Scene(root));
                    //stage.setHeight(600);
                    //stage.setWidth(900);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    public TableView getTable() {
        return tblArrangement;
    }
}
*/