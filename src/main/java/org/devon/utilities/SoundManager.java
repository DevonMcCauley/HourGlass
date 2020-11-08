package org.devon.utilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * SoundManager is a class that supplies that audio for the HourGlass application. SoundManager uses the JavaFX Media library
 * to play sounds.
 * @author Devon McCauley
 *
 */
public class SoundManager {
    String loginSound = getClass().getResource("/sounds/login.wav").toExternalForm();
    String alertSound = getClass().getResource("/sounds/alert.wav").toExternalForm();
    String errorSound = getClass().getResource("/sounds/error.wav").toExternalForm();

    Media login = new Media(loginSound);
    MediaPlayer loginClicked = new MediaPlayer(login);

    Media alert = new Media(alertSound);
    MediaPlayer showAlert = new MediaPlayer(alert);

    Media error = new Media(errorSound);
    MediaPlayer showError = new MediaPlayer(error);


    /**
     * Plays a sound when the user (successfully) logs into the HourGlass application
     */
    public void playLoginSound() {
        loginClicked.seek(Duration.ZERO);
        loginClicked.play();
    }
    /**
     * Plays a sound when the user triggers an alert
     */
    public void playAlertSound() {
        showAlert.seek(Duration.ZERO);
        showAlert.play();
    }
    /**
     * Plays a sound when the user causes an error
     */
    public void playErrorSound() {
        showError.seek(Duration.ZERO);
        showError.play();
    }

}
