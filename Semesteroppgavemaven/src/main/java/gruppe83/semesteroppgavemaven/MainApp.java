package gruppe83.semesteroppgavemaven;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create the first controller, which loads Layout1.fxml within its own constructor
        FXMLController controller1 = new FXMLController();

        // Show the new stage
        controller1.showStage();

    }
}
