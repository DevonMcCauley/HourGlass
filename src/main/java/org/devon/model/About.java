package org.devon.model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class About {

    double version = 1.5;


    public void showAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "HourGlass was designed and developed by Devon McCauley. You are using version " + version + ".", ButtonType.OK);
        alert.setTitle("Information");
        alert.showAndWait();
    }

}
