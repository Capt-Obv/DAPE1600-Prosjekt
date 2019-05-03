/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableArray;
import javafx.scene.control.TableView;
/**
 *
 * @author Andrea
 */
public class ProgramModel {
    private SimpleStringProperty startTid;
    private SimpleStringProperty sluttTid;
    private SimpleStringProperty programElement;
    
    public ProgramModel(String start, String slutt, String element) {
        this.startTid = new SimpleStringProperty(start);
        this.sluttTid = new SimpleStringProperty(slutt);
        this.programElement = new SimpleStringProperty(element);
    }
    
    public String getStartTid(){
        return startTid.get();
    }
    
    public void setStartTid(String start){
        this.startTid = new SimpleStringProperty(start);
    }
    
    public String getSluttTid(){
        return sluttTid.get();
    }
    
    public void setSluttTid(String slutt){
        this.sluttTid = new SimpleStringProperty(slutt);
    }
    
    public String getProgramElement(){
        return programElement.get();
    }
    
    public void setProgramElement(String element){
        this.programElement = new SimpleStringProperty(element);
    }
    
    public StringProperty startTidProperty(){
        return startTid;
    }
    
    public StringProperty sluttTidProperty(){
        return sluttTid;
    }
    
    public StringProperty programElementProperty(){
        return programElement;
    }
}

class TableToProgramArray {
    private TableView<ProgramModel> table;
    
    public TableToProgramArray(TableView<ProgramModel> table){
        this.table = table;
    }
}