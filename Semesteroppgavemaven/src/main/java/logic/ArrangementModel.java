/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Andrea
 */
public class ArrangementModel {
    private Arrangement arr;
    private SimpleStringProperty arrNavn;
    private SimpleStringProperty arrKontakt;
    private SimpleStringProperty arrLokale;
    private SimpleStringProperty arrPlasser;
    private SimpleStringProperty arrProgram;
    private SimpleStringProperty arrBillett;
    private SimpleStringProperty arrDato;
    private SimpleStringProperty arrPris;
    
    public ArrangementModel(Arrangement arr){
        this.arr = arr;
        String kontakt = arr.getKontakt().toString();
        this.arrKontakt = new SimpleStringProperty(kontakt);
        String lokale = arr.getLokale().toString();
        this.arrLokale = new SimpleStringProperty(lokale);
        String plasser = Integer.toString(arr.getLokale().getAntPlasser());
        this.arrPlasser = new SimpleStringProperty(plasser);
        String program = arr.programToString();
        this.arrProgram = new SimpleStringProperty(program);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dato = arr.getDato().format(dateFormat);
        this.arrDato = new SimpleStringProperty(dato);
        String pris = Integer.toString(arr.getPris());
        this.arrPris = new SimpleStringProperty(pris);
        this.arrNavn = new SimpleStringProperty(arr.getNavn());
    }
    public StringProperty navnProperty() { return arrNavn; }
    public StringProperty kontaktProperty() { return arrKontakt; }
    public StringProperty lokaleProperty() { return arrLokale; }
    public StringProperty plasserProperty() { return arrPlasser; }
    public StringProperty programProperty() { return arrProgram; }
    public StringProperty datoProperty() { return arrDato; }
    public StringProperty prisProperty() { return arrPris; }
    
    public SimpleStringProperty getNavn(){
        return arrNavn;
    }
    
    public void setNavn(String navn){
        arrNavn = new SimpleStringProperty(navn);
    }
    
    public SimpleStringProperty getKontakt(){
        return arrKontakt;
    }
    
    public void setKontakt(String kontakt){
        arrKontakt = new SimpleStringProperty(kontakt);
    }
    
    public SimpleStringProperty getLokale(){
        return arrLokale;
    }
         
    public void setLokale(String lokale){
        arrLokale = new SimpleStringProperty(lokale);
    }
    
    public SimpleStringProperty getPlasser(){
        return arrPlasser;
    }
    
    public void setPlasser(String plasser){
        arrPlasser = new SimpleStringProperty(plasser);
    }
    
    public SimpleStringProperty getProgram(){
        return arrProgram;
    }
    
    public void setProgram(String program){
        arrProgram = new SimpleStringProperty(program);
    }
    
    public SimpleStringProperty getDato(String dato){
        return arrDato;
    }
    
    public void setDato(String dato){
        arrDato = new SimpleStringProperty(dato);
    }
    
    public SimpleStringProperty getPris(){;
        return arrPris;
    }
    
    public void getPris(String pris){
        arrPris = new SimpleStringProperty(pris);
    }
}
