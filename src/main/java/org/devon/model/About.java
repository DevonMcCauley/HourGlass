package org.devon.model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.devon.utilities.SoundManager;

/**
 * Used to hold the information about the application
 * @author Devon
 *
 */
public class About {

    double version = 1.6;


    /**
     * Shows an alert to the user; describes the current version of HourGlass.
     */
    public void showAbout(){
        SoundManager soundManager = new SoundManager();
        soundManager.playAlertSound();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "HourGlass was designed and developed by Devon McCauley. You are using version " + version + ".", ButtonType.OK);
        alert.setTitle("Information");
        alert.showAndWait();
    }

}
