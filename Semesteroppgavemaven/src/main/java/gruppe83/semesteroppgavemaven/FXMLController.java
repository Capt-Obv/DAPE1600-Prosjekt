package gruppe83.semesteroppgavemaven;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.Arrangement;
import logic.ArrangementModel;
import logic.ProgramModel;

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
    private TableView<ArrangementModel> tabell;

    @FXML
    private TableColumn<ArrangementModel, String> colArr;

    @FXML
    private TableColumn<String, ArrangementModel> colNavn;

    @FXML
    private TableColumn<String, ArrangementModel> colKontakt;

    @FXML
    private TableColumn<String, ArrangementModel> colpris;

    @FXML
    private TableColumn<String, ArrangementModel> colBilett;

    @FXML
    private TableColumn<String, ArrangementModel> colDeltaker;

    @FXML
    private TableColumn<String, ArrangementModel> colProgramm;

    @FXML
    private TableColumn<String, ArrangementModel> colLokale;

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
    
    @FXML
    private TextField txtToSecondController;
    
    @FXML
    private Label lblFromController2;
    
    @FXML
    private ListView<Arrangement> listFromSecondController;


    public FXMLController() {

        // Create the new stage
        thisStage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene((Parent) loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Passing Controllers Example - Layout1");

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
        
        
        colArr.setCellValueFactory(new PropertyValueFactory<ArrangementModel, String>("navn"));
        colNavn.setCellValueFactory(new PropertyValueFactory<String, ArrangementModel>("navn"));
        colKontakt.setCellValueFactory(new PropertyValueFactory<String, ArrangementModel>("kontakt"));
        colpris.setCellValueFactory(new PropertyValueFactory<String, ArrangementModel>("pris"));
        colBilett.setCellValueFactory(new PropertyValueFactory<String, ArrangementModel>("plasser"));
//        colDeltaker.setCellValueFactory(new PropertyValueFactory<ArrangementModel, String>(""));
        colProgramm.setCellValueFactory(new PropertyValueFactory<String, ArrangementModel>("program"));
        colLokale.setCellValueFactory(new PropertyValueFactory<String, ArrangementModel>("lokale"));
    
          

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
    public String getEnteredText() {
        return txtToSecondController.getText();
    }

    /**
     * Allows other controllers to set the text of this layout's Label
     */
    public void setTextFromController2(String text) {
        lblFromController2.setText(text);
    }
    public void setListViewFromSecondController(Arrangement arr){
        addArrangementToTable(arr);
    }
   
    public void addArrangementToTable(Arrangement arr){
       tabell.getItems().add(new ArrangementModel(arr));

    }
    /*
    public void kjøpBillett(){
         public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
        getClass().getResource("login.fxml")
        );
            scene.setRoot((Parent) loader.load());
            LoginController controller = 
                loader.<LoginController>getController();
            controller.initManager(this);
            } catch (IOException ex) {
      Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
    }
  } 
    }
*/
}