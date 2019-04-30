package gruppe83.testfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.InputMethodEvent;

public class FXMLController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLesFil;

    @FXML
    private ToolBar toolbar;

    @FXML
    private TextField textfieldSearch;

    @FXML
    private MenuButton btnFilter;

    @FXML
    private MenuItem btnSortDate;

    @FXML
    private TableView<?> table;

    @FXML
    void btnLsIFlActon(ActionEvent event) {

    }

    @FXML
    void btnSortAction(ActionEvent event) {

    }

    @FXML
    void textFieldSearchAction(InputMethodEvent event) {

    }


}
