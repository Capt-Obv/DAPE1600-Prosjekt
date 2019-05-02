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

class TableToString {
    private ArrayList<ProgramModel> table;
    
    public TableToString(ArrayList<ProgramModel> table){
        this.table = table;
    }
    
    @Override
    public String toString(){
        String message = "";
        for(int i=0; i<table.size();i=i+3){
            message += table.get(i)+"-"+table.get(i+1)+" "+table.get(i+2);
            }
        return message; 
        }
    }

/*
class TimeFormat{
    private String time;
    
    public TimeFormat(String time){
        this.time = time;
    }
    //Legg til try catch
    public Date getTimeFormat(String time) throws ParseException{
        Date timeFormatted = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        
        timeFormatted = simpleDateFormat.parse(time);
        
        return timeFormatted;
    }}
*/