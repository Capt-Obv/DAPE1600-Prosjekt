/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppe83.semesteroppgavemaven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
//import logic.FilereaderCSV;
//import logic.FilereaderJOBJ;
import logic.InvalidFormatException;
import logic.InvalidObjectTypeException;
import logic.InvalidTimeOverlapException;

/**
 *
 * @author sarah
 */
/*
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
    
    public void chooseFile(Stage stage) throws Exception {
        selected = chooser.showOpenDialog(stage);
        if(selected!=null) {
            String filename = selected.getName();
            String[] parts = filename.split(".");
            if(parts[1].equals("csv")) {
                try {
                    FilereaderCSV csvReader = new FilereaderCSV();
                    csvReader.initializeImport(selected, parts[0]);
                } catch (InvalidTimeOverlapException | InvalidObjectTypeException
                        | InvalidFormatException | ClassNotFoundException e) {
                    
                } catch (FileNotFoundException e) {
                    
                } catch (IOException e) {
                    
                }
            } else if(parts[1].equals("jobj")) {
                FilereaderJOBJ jobjReader = new FilereaderJOBJ();
                jobjReader.initializeImport(selected, parts[0]);
                try {
                    FilereaderCSV csvReader = new FilereaderCSV();
                    csvReader.initializeImport(selected, parts[0]);
                } catch (InvalidTimeOverlapException | InvalidObjectTypeException
                        | InvalidFormatException | ClassNotFoundException e) {
                    
                } catch (FileNotFoundException e) {
                    
                } catch (IOException e) {
                    
                }
            }
        }
    }
}
*/