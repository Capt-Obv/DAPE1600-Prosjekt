/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe83.semesteroppgavemaven;


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
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author Andrea
 */
public class InputSkjermController implements Initializable {
 

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
    private ListView<?> listKontaktperson;

    @FXML
    private TextField txtProgram;

    @FXML
    private Button lblKlokkeslett;

    @FXML
    private TableColumn<?, ?> colKl;

    @FXML
    private TableColumn<?, ?> colProgram;

    @FXML
    private ComboBox<String> boxKlokkeTime;

    @FXML
    private ComboBox<String> boxKlokkeMin;

    @FXML
    private Button btnLagre;

    @FXML
    private Button btnAvbryt;

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
                    kontakt.add(txtNavn.getText());
                    kontakt.add(txtTelefonr.getText());
                    if(!txtEpost.getText().isEmpty()){kontakt.add(txtEpost.getText());}
                    if(!txtNettside.getText().isEmpty()){kontakt.add(txtNettside.getText());}
                    if(!txtFirma.getText().isEmpty()){kontakt.add(txtFirma.getText());}
                    if(!txtOpplysninger.getText().isEmpty()){kontakt.add(txtOpplysninger.getText());}
                    }
                }
            });
        //________________Finne ett annet sted
        //Putte inn klokkeslettene i klokkeboksen
        ArrayList<String> klokkeTimerTemp = new ArrayList<>();
        for(int i = 0; i <=24; i++){
            if (i<10){klokkeTimerTemp.add("0"+i);}
            else {klokkeTimerTemp.add(Integer.toString(i));}
        }
        
        ArrayList<String> klokkeMinTemp = new ArrayList<>();
        for(int i=0; i< 60; i=i+5){
            klokkeMinTemp.add(Integer.toString(i));
        }

        ObservableList<String> klokkeTimer = FXCollections.observableArrayList(klokkeTimerTemp);   
        ObservableList<String> klokkeMin = FXCollections.observableArrayList(klokkeMinTemp);
        boxKlokkeTime.setItems(klokkeTimer);
        boxKlokkeMin.setItems(klokkeMin);
        
    };
    //Putte inn klokkeslettene i klokkeboksen
    
        
    }    
    /*
    LocalDate value = datePicker.getValue();
    txtNavn.getText()
    txtPris.getText()
    
    
    
    
    
    
    */
  

