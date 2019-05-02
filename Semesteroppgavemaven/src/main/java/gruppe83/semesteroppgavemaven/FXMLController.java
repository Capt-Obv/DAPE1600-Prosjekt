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
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Andrea
 */
public class FXMLController implements Initializable {
    
    @FXML
    private SplitPane split;
    
    @FXML
    private AnchorPane parent;
    
    @FXML
    private MenuBar menu;
    
    @FXML
    private Menu file;
    
    @FXML
    private Menu edit;
    
    @FXML
    private Menu help;
    
    @FXML
    private MenuItem close;
    
    @FXML
    private MenuItem delete;
    
    @FXML
    private MenuItem about;
    @FXML
    private Button btnLesFil;
    @FXML
    private Button btnNyttArr;
    @FXML
    private Button btnSlettArr;
    @FXML
    private ScrollPane skroll;
    @FXML
    private TextField search;
    @FXML
    private MenuButton filter;
    @FXML
    private ToolBar toolbar;
    @FXML
    private Button kanskje;
    @FXML
    private MenuItem filterDato;
    @FXML
    private MenuItem filterSal;
    @FXML
    private TableView tabell;
    @FXML
    private TableColumn colArr;
    @FXML
    private TableColumn colNavn;
    @FXML
    private TableColumn colLokale;
    @FXML
    private TableColumn colKontakt;
    @FXML
    private TableColumn colpris;
    @FXML
    private TableColumn colBilett;
    @FXML
    private TableColumn colDeltaker;
    @FXML
    private TableColumn colProgramm;
    @FXML
    private Button skrivFil;
//    Scene FXMLDocument;
//    Scene InputSkjema;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnNyttArr.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/InputSkjema.fxml"));
                try {
                    StackPane root = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setOpacity(1);
                    stage.setTitle("Lag nytt arrangement");
                    stage.setScene(new Scene(root));
                    
                    root.getChildren().
                    //stage.setHeight(600);
                    //stage.setWidth(900);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            });
        }

}
    
    

  