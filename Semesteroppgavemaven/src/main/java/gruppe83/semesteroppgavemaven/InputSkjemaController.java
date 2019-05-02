/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe83.semesteroppgavemaven;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
        import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import logic.ProgramModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import javafx.scene.control.Accordion;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import logic.Arrangement;

import java.io.IOException;
import javafx.scene.Parent;
import logic.Kontaktperson;
import logic.Lokale;

public class InputSkjemaController {

    // Holds this controller's Stage
    private Stage thisStage;

    // Will hold a reference to the first controller, allowing us to access the methods found there.
    private final FXMLController controller1;

    // Add references to the controls in Layout2.fxml
    @FXML
    private Label lblFromController1;
    @FXML
    private TextField txtToFirstController;
    @FXML
    private Button btnSetLayout1Text;
        @FXML
    private TitledPane accordionProgram;
    
    @FXML
    private TitledPane accordionDeltaker;
    
    @FXML
    private Accordion accoTemplate;

    @FXML
    private TitledPane accordionInfo;

    @FXML
    private Label lblLokale;

    @FXML
    private Label lblDato;

    @FXML
    private Label lblPris;

    @FXML
    private Label lblBilletter;

    @FXML
    private TextField txtNavn;

    @FXML
    private ChoiceBox<String> velgLokale;

    @FXML
    private Label lblNavn;

    @FXML
    private TextField txtPris;

    @FXML
    private DatePicker velgDato;

    @FXML
    private TextField txtBilletter;

    @FXML
    private TextField txtLeggTilArtist;

    @FXML
    private Button btnLeggTilArtist;

    @FXML
    private ListView<String> listeArtist;

    @FXML
    private Label lblKontakt;

    @FXML
    private TextField txtKontaktNavn;

    @FXML
    private TextField txtTelefonr;

    @FXML
    private TextField txtEpost;

    @FXML
    private TextField txtNettside;

    @FXML
    private TextField txtFirma;

    @FXML
    private TextField txtOpplysninger;

    @FXML
    private Button btnLeggTilKontakt;

    @FXML
    private ListView<String> listKontaktperson;

    @FXML
    private TextField txtProgram;

    @FXML
    private Button btnLeggTilProgram;

    @FXML
    private TextField txtKlokkeStart;

    @FXML
    private TextField txtKlokkeSlutt;

    @FXML
    private ListView<String> listProgram;

    @FXML
    private Button btnLagre;

    @FXML
    private Button btnAvbryt;
    
    @FXML
    private TableView<ProgramModel> tblProgram;

    @FXML
    private TableColumn<ProgramModel, String> colKlokkeFra;

    @FXML
    private TableColumn<ProgramModel, String> colKlokkeTil;

    @FXML
    private TableColumn<ProgramModel, String> colElement;

    public InputSkjemaController(FXMLController controller1) {
        // We received the first controller, now let's make it usable throughout this controller.
        this.controller1 = controller1;

        // Create the new stage
        thisStage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InputSkjema.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene((Parent) loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Passing Controllers Example - Layout2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // TODO
        
        //ChoiceBox for å velge lokale og lagre verdien
        ObservableList<String> lokaler = FXCollections.observableArrayList(logic.Lokale.lokalListe());
        velgLokale.setItems(lokaler);
        ChangeListener<String> changeListener = new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null){
                    /*---------------Lagre verdien*/
                }
            }
            
        };
        
        txtKlokkeStart.setText("00:00");
        txtKlokkeSlutt.setText("00:00");
        txtProgram.setText("");
        
        colKlokkeFra.setCellValueFactory(new PropertyValueFactory<ProgramModel, String>("startTid"));
        colKlokkeTil.setCellValueFactory(new PropertyValueFactory<ProgramModel, String>("sluttTid"));
        colElement.setCellValueFactory(new PropertyValueFactory<ProgramModel, String>("programElement"));
        //tblProgram.setItems(ProgramModel);
        
        btnLeggTilProgram.setOnAction(new EventHandler<ActionEvent>(){
        ObservableList<ProgramModel> programModels = FXCollections.observableArrayList();
            @Override
            public void handle(ActionEvent event) {
                //ObservableList<ProgramModel> programModels = FXCollections.observableArrayList(
                //new ProgramModel(txtKlokkeStart.getText(),txtKlokkeSlutt.getText(), txtProgram.getText()));
                programModels.add(new ProgramModel(txtKlokkeStart.getText(),txtKlokkeSlutt.getText(), txtProgram.getText()));
                tblProgram.setItems(programModels);
                txtKlokkeStart.setText("00:00");
                txtKlokkeSlutt.setText("00:00");
                txtProgram.setText("");
            }
        });
        
        //FORANDRE DETTE DISKUTERE IDEEN MIN MED SARAH
        //ActionEvent for å legge til artist i listen når btbLeggTilArtist blir trykket
        btnLeggTilArtist.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            
            public void handle(ActionEvent event) {
                ObservableList<String> artistList = FXCollections.<String>observableArrayList();
                //Sjekke om feltet er tomt
                if(txtLeggTilArtist.getText().isEmpty()){
                    /*Snakk med Sarah*/
                }else {
                    //Hente verdien fra txrLeggTilArtist og legge det i en liste
                    artistList.add(txtLeggTilArtist.getText());
                    listeArtist.getItems().addAll(artistList);
                    //Tømme txtLeggTilArtist
                    txtLeggTilArtist.setText("");
                }
            }
        });
        
        //ActionEvent for å legge til en kontaktperson
            //SKAL FORANDRE LITT HER TRENGER IKKE Å LEGGE DET I EN TABELL!!!!!!!!!!!
            //_______-----------!!!!!!!!!!!!!!!!!!!_______________
        btnLeggTilKontakt.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //Sjekker om txtKontaktNavn eller txtTelefonr er tomme og gir en advarsel hvis de er
                if(txtKontaktNavn.getText().isEmpty() || txtTelefonr.getText().isEmpty()){
                    //legg til en advarsel at disse to er nødvendige
                }else{
                    //Legger informasjonen om kontaktpersonen i en liste
                    ArrayList<String> kontakt = new ArrayList<>();
                    kontakt.add(txtKontaktNavn.getText());
                    kontakt.add(txtTelefonr.getText());
                    if(!txtEpost.getText().isEmpty()){kontakt.add(txtEpost.getText());}
                    if(!txtNettside.getText().isEmpty()){kontakt.add(txtNettside.getText());}
                    if(!txtFirma.getText().isEmpty()){kontakt.add(txtFirma.getText());}
                    if(!txtOpplysninger.getText().isEmpty()){kontakt.add(txtOpplysninger.getText());}
                    ObservableList<String> kontakO = FXCollections.observableArrayList(kontakt);
                    listKontaktperson.getItems().addAll(kontakO);
                }
                txtKontaktNavn.setText("Navn");
                txtTelefonr.setText("Telefonr");
                txtEpost.setText("E-post");
                txtNettside.setText("Nettside");
                txtFirma.setText("Firma");
                txtOpplysninger.setText("Opplysninger");
               
                }
            });
        

        
        btnLagre.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String message = "";
                if (txtNavn.getText().isEmpty()){
                    //Legg til advarsel
                    return;
                }
                else {
                    message += ("Navn: " +txtNavn.getText()+"\n");
                    System.out.println("Navn "+txtNavn.getText());
                }

                if (velgLokale.getValue()==null){
                    //Legg til advarsel
                    return;
                }
                else {
                    message += "Lokale: " +velgLokale.getValue()+"\n";
                    System.out.println("Lokale: " +velgLokale.getValue());
                }
                
                
                if (velgDato.getValue() == null){
                    //Legg til advarsel
                    return;
                }
                else {
                    LocalDate arrDato = velgDato.getValue();
                    System.out.println(velgDato.getValue());
                }   
                
                if (txtPris.getText().isEmpty()){
                    //Legg til advarsel
                }
                else {
                    message += "Pris: "+txtPris.getText()+"\n";
                    System.out.println("Pris: "+txtPris.getText());
                }
                
                //DEENNNE SKAL JEG FORANDRE
                if (txtBilletter.getText().isEmpty()){
                    //legg til advarsel
                } 
                else {
                    message += "plasser: "+txtBilletter.getText()+"\n";
                    System.out.println("plasser: "+txtBilletter.getText());
                }
                
                ArrayList<String> arrArtist = new ArrayList<>();
                arrArtist.addAll(listeArtist.getItems());
                message += "Artister: ";
                for (String elem : listeArtist.getItems()){
                    message += elem+ " ";
                }
                                message += "\n Kontaktperson:\n";
                System.out.println(listKontaktperson);
                if(txtKontaktNavn.getText().isEmpty() || txtTelefonr.getText().isEmpty()){
                    //legg til en advarsel at disse to er nødvendige
                }else{
                    //Legger informasjonen om kontaktpersonen i en liste
                    //finne en måte å finne lengden på listwiev
                    //kontaktTemp = listview.getSelectionModel().getSelectedItems();
                    //for (String elem:listKontaktperson){
                    //message += "Navn: "+ kontakt.get(0)+"\n";
                    if(!txtEpost.getText().isEmpty()){

                        //message += "E-post: "+kontakt.get(2)+"\n";
                    }
                    if(!txtOpplysninger.getText().isEmpty()){

                        //message += "Andre opplysninger: " +kontakt.get(5)+"\n";
                    }
                    //message += "Telefonnr: "+kontakt.get(1)+"\n";
                    
                    if(!txtNettside.getText().isEmpty()){

                        //message += "Nettside: " +kontakt.get(3)+"\n";
                    }
                    if(!txtFirma.getText().isEmpty()){

                        //message += "Firma: " + kontakt.get(4)+"\n";
                    }
                    
                    //System.out.println("Andre opplysninger: "+kontakt);
                    }
                
            }
    });
                ObservableList<ProgramModel> program = FXCollections.observableArrayList(tblProgram.getItems());
                ObservableList<String> kontakt;
                kontakt = listKontaktperson.getItems();
                
                Kontaktperson kontaktperson = new Kontaktperson(kontakt.get(0), Integer.parseInt(kontakt.get(1)),
                    kontakt.get(2), kontakt.get(5), kontakt.get(3), kontakt.get(4));
                
                Lokale lok = new Lokale("Sal1", Integer.parseInt(txtBilletter.getText()),velgLokale.getValue());
                Arrangement arr = new Arrangement(txtNavn.getText(),lok,kontaktperson,velgDato.getValue(),Integer.parseInt(txtPris.getText()));
    }

    /**
     * Show the stage that was loaded in the constructor
     */
    public void showStage() {
        thisStage.showAndWait();
    }

    @FXML
    private void initialize() {

        // Set the label to whatever the text entered on Layout1 is
        //lblFromController1.setText(controller1.getEnteredText());

        // Set the action for the button
        //btnSetLayout1Text.setOnAction(event -> setTextOnLayout1());
        
    }

    /**
     * Calls the "setTextFromController2()" method on the first controller to update its Label
     */
    /*
    private void setArr(Arrangement arr) {
        controller1.setTableFromController2(arr);
    }
*/

}