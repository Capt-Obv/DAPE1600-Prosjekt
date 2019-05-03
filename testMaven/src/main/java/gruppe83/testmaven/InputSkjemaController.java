/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe83.testmaven;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import logic.Arrangement;
import logic.Kontaktperson;
import logic.Lokale;
import logic.ProgramModel;

/**
 *
 * @author Andrea
 */
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
    private TitledPane accordionDeltaker;

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
    private TitledPane accordionProgram;

    @FXML
    private TextField txtProgram;

    @FXML
    private Button btnLeggTilProgram;

    @FXML
    private TextField txtKlokkeStart;

    @FXML
    private TextField txtKlokkeSlutt;

    @FXML
    private TableView<ProgramModel> tblProgram;

    @FXML
    private TableColumn<ProgramModel, String> colKlokkeFra;

    @FXML
    private TableColumn<ProgramModel, String> colKlokkeTil;

    @FXML
    private TableColumn<ProgramModel, String> colElement;

    @FXML
    private Button btnLagre;

    @FXML
    private Button btnAvbryt;
    
    @FXML
    private Label lagreLokal;
    @FXML
    private Label lblTempLokale;
    
    @FXML
    private Label lagreDato;

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
    }

    /**
     * Show the stage that was loaded in the constructor
     */
    public void showStage() {
        thisStage.showAndWait();
    }

    @FXML
    private void initialize() throws ParseException {

        // Set the label to whatever the text entered on Layout1 is
        //lblFromController1.setText(controller1.getEnteredText());

        // Set the action for the button
        //btnSetLayout1Text.setOnAction(new EventHandler<ActionEvent>(){
                

        //    @Override
        //    public void handle(ActionEvent event) {
        //        setTextOnLayout1();
        //    }
    //});
    
        //ChoiceBox for å velge lokale og lagre verdien
        final ObservableList<String> lokaler = FXCollections.observableArrayList(logic.Lokale.lokalListe());
        velgLokale.setItems(lokaler);
        velgLokale.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() { 

            // if the item of the list is changed 
            public void changed(ObservableValue ov, Number value, Number new_value) 
            { 

                lagreLokal.setText(lokaler.get((int) new_value));
                //lblTempLokale.setText(""+new_value);
                //lblTempLokale.setText(( lokaler.get((int) new_value)));
                // set the text for the label to the selected item 
                //lblTempLokale.setText((String) velgLokale.getValue());
                
            } 
        }); 

        velgDato.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                 LocalDate dato = velgDato.getValue();
             
                 lagreDato.setText(""+dato);
            }
        });

        Button button = new Button("Read Date");


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
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try{
                    Date start = sdf.parse(txtKlokkeStart.getText());
                    Date slutt = sdf.parse(txtKlokkeSlutt.getText());
                } catch (ParseException ex) {
                Logger.getLogger(InputSkjemaController.class.getName()).log(Level.SEVERE, null, ex);
                //Legg til advarsel
                }
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
                    ObservableList<String> kontakO = FXCollections.observableArrayList();
                    listKontaktperson.getItems().addAll(kontakt);
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
                /*
                ObservableList<String> kontakt;
                kontakt = listKontaktperson.getItems();
                
                Kontaktperson kontaktperson = new Kontaktperson(kontakt.get(0), Integer.parseInt(kontakt.get(1)),
                    kontakt.get(2));
                if(kontakt.size()>= 4){kontaktperson.setNettside(kontakt.get(3));}
                if(kontakt.size()>= 5) {kontaktperson.setFirma(kontakt.get(4));}
                if(kontakt.size()>=6 ){kontaktperson.setOpplysninger(kontakt.get(5));}
                

                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                CharSequence temp = lagreDato.getText();

                LocalDate date = LocalDate.parse(temp, format);

 
                Lokale lok = new Lokale("Sal1", Integer.parseInt(txtBilletter.getText()),lagreLokal.getText());
                Arrangement arr = new Arrangement(txtNavn.getText(),lok,kontaktperson,date,Integer.parseInt(txtPris.getText()));
                ObservableList<ProgramModel> program = FXCollections.observableArrayList(tblProgram.getItems());
                LocalTime start;
                LocalTime slutt;
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm");
                ProgramModel tempProg = program.get(0);
                System.out.println(tempProg.getStartTid());
                
                for (ProgramModel elem : program){
                    
                    start = LocalTime.parse(elem.getStartTid(), dataFormat);
                    slutt = LocalTime.parse(elem.getSluttTid());
                    arr.leggTilIProgram(start, elem.getProgramElement(), slutt);
                    
                }
                */
                Lokale lok2 = new Lokale("Sal1", 100,"Kino");
                Kontaktperson kont = new Kontaktperson("sila",928345, "epost");
                LocalDate date2 = LocalDate.now();
                Arrangement arr2 = new Arrangement("Fest",lok2,kont,date2,10000);
                arr2.leggTilIProgram(LocalTime.parse("00:10"), "start", LocalTime.parse("01:00"));
                //ObservableList<logic.Arrangement> arrList = FXCollections.observableArrayList(arr2);               
                thisStage.close();
                           controller1.setListViewFromSecondController(arr2);

            }
        });
        
        btnAvbryt.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                thisStage.close();
            }
            
        });
        
    }

    /**
     * Calls the "setTextFromController2()" method on the first controller to update its Label
     */
    private void setTextOnLayout1() {
        controller1.setTextFromController2(txtToFirstController.getText());
    }

}
