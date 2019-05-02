package gruppe83.semesteroppgavemaven;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Andrea
 */
public class FXMLController {

    // Holds this controller's Stage
    private final Stage thisStage;

    // Define the nodes from the Layout1.fxml file. This allows them to be referenced within the controller
    @FXML
    private AnchorPane parent;

    @FXML
    private SplitPane split;

    @FXML
    private Button btnLesFil;

    @FXML
    private Button btnNyttArr;

    @FXML
    private Button btnSlettArr;

    @FXML
    private Button btnSkrivFil;

    @FXML
    private ScrollPane skroll;

    @FXML
    private ToolBar toolbar;

    @FXML
    private TextField search;

    @FXML
    private Button kanskje;

    @FXML
    private MenuButton filter;

    @FXML
    private MenuItem filterDato;

    @FXML
    private MenuItem filterSal;

    @FXML
    private TableView<?> tabell;

    @FXML
    private TableColumn<?, ?> colArr;

    @FXML
    private TableColumn<?, ?> colNavn;

    @FXML
    private TableColumn<?, ?> colKontakt;

    @FXML
    private TableColumn<?, ?> colpris;

    @FXML
    private TableColumn<?, ?> colBilett;

    @FXML
    private TableColumn<?, ?> colDeltaker;

    @FXML
    private TableColumn<?, ?> colProgramm;

    @FXML
    private TableColumn<?, ?> colLokale;

    @FXML
    private MenuBar menu;

    @FXML
    private Menu file;

    @FXML
    private MenuItem close;

    @FXML
    private Menu edit;

    @FXML
    private MenuItem delete;

    @FXML
    private Menu help;

    @FXML
    private MenuItem about;

    public FXMLController() {

        // Create the new stage
        thisStage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene((Pane) loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Passing Controllers Example - Layout1");

        } catch (IOException e) {
        }
    }

    /**
     * Show the stage that was loaded in the constructor
     */
    public void showStage() {
        thisStage.showAndWait();
    }

    /**
     * The initialize() method allows you set setup your scene, adding actions, configuring nodes, etc.
     */
    @FXML
    private void initialize() {

        // Add an action for the "Open Layout2" button
        btnNyttArr.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                openLayout2();
            }
            
        });
    }

    /**
     * Performs the action of loading and showing Layout2
     */
    private void openLayout2() {

        // Create the second controller, which loads its own FXML file. We pass a reference to this controller
        // using the keyword [this]; that allows the second controller to access the methods contained in here.
        InputSkjemaController controller2 = new InputSkjemaController(this);

        // Show the new stage/window
        controller2.showStage();

    }

    /**
     * Returns the text entered into txtToSecondController. This allows other controllers/classes to view that data.
     */
    /*
    public logic.Arrangement getArrangement() {
        return .getText();
    }
    */

    /**
     * Allows other controllers to set the text of this layout's Label
     */
   /* 
    public void setTableViewFromController2(TableView table) {
        tabell.setText(text);
    }
*/
}
