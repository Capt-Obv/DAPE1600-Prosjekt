/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe83.testmaven;

import java.io.IOException;
import java.text.ParseException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Andrea
 */
public class kjøpBillettController {
        private Stage thisStage;
        
            @FXML
            private TextField txtNavn;

            @FXML
            private TextField txtTextField;

            @FXML
            private Button btnKjøp;

            @FXML
            private Button btnAvbryt;

            @FXML
            private Label lblTelefonr;

            @FXML
            private Label lblArrangement;

    // Will hold a reference to the first controller, allowing us to access the methods found there.
        private final FXMLController controller1;
    
        public kjøpBillettController(FXMLController controller1) {
        // We received the first controller, now let's make it usable throughout this controller.
        this.controller1 = controller1;

        // Create the new stage
        thisStage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/openKjopBillettVindu.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene((Parent) loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Passing Controllers Example - Layout2");
            
                
 
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show the stage that was loaded in the constructor
     */
    public void showStage() {
        thisStage.showAndWait();
    }

    @FXML
    private void initialize() throws ParseException {
        lblArrangement.setText(controller1.getEnteredText());
    }
    }

    
   

