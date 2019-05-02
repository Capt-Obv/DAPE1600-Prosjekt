package gruppe83.semesteroppgavemaven;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import logic.ProgramModel;


    
public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create the first controller, which loads Layout1.fxml within its own constructor
        FXMLController controller1 = new FXMLController();

        // Show the new stage
        controller1.showStage();

    }
        public static void main(String[] args) {
        launch(args);
    }
}

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */


/*
class CreateStage extends Window {

     private TableView<logic.Arrangement> tblArrangement;

    public CreateStage() {
        tblArrangement = new TableView();        

        StackPane root = new StackPane();
        root.getChildren().add(textBox);        

        Scene scene = new Scene(root, 300, 250);

        Stage stage = new Stage();
        stage.setTitle("Additional Stage");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public String getText() {
        return textBox.getText();
    }
}
*/