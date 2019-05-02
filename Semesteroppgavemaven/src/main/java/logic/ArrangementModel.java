/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Andrea
 */
public class ArrangementModel {
    private SimpleStringProperty arrangementsNavn;
    private SimpleStringProperty kontakt;
    private SimpleString lokale;
    private ArrayList<Deltaker> deltakere;
    private ArrayList<Programelement> program;
    private Billett[] solgteBilletter;
    private LocalDate dato;
    private int pris;
    private static int antSolgte = 0;
    
        private SimpleStringProperty startTid;
    private SimpleStringProperty sluttTid;
    private SimpleStringProperty programElement;
    
    public ProgramModel(String start, String slutt, String element) {
        this.startTid = new SimpleStringProperty(start);
        this.sluttTid = new SimpleStringProperty(slutt);
        this.programElement = new SimpleStringProperty(element);
    }
}
