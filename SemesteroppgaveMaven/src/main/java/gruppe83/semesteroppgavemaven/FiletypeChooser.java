/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe83.semesteroppgavemaven;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import logic.FilereaderCSV;
import logic.FilereaderJOBJ;
import logic.InvalidFormatException;

/**
 *
 * @author sarah
 */
public class FiletypeChooser {
    private FileChooser chooser;
    private File selected;
    
    public FiletypeChooser() {
        chooser = new FileChooser();
        chooser.setTitle("Chose file to read");
        chooser.getExtensionFilters().add(new 
            ExtensionFilter("CSV files", "*.csv"));
        chooser.getExtensionFilters().add(new 
            ExtensionFilter("JOBJ files", "'jobj"));
    }
    
    public void chooseFile() throws InvalidFormatException{
        selected = chooser.showOpenDialog(mainStage);
        if(selected!=null) {
            mainStage.display(selected);
            String filename = selected.getName();
            String[] parts = filename.split(".");
            try {
                if(parts[1].equals("csv")) {
                    FilereaderCSV csvReader = new FilereaderCSV();
                    csvReader.initializeImport(selected, parts[0]);
                } else if(parts[1].equals("jobj")) {
                    FilereaderJOBJ jobjReader = new FilereaderCSV();
                    jobjReader.initializeImport(selected, parts[0]);
                }
            } catch (FileNotFoundException e) {
                
            }
        }
    }
}
