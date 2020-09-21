package org.devon.utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.devon.application.App;
import org.devon.model.Screen_Type;

import java.io.IOException;
import java.io.InputStream;

/**
 * ScreenManager is a class used to manage the changing of JavaFX scenes. It also holds the icons
 * used by the GUI navigation bar.
 *
 * @author Devon McCauley
 * @see Screen_Type
 */


public class ScreenManager {


    /**
     * @param screen_type is an enum. This parameter is used to determine which
     *                    FXML screen should be shown to the user.
     *                    Options include:
     *                    <p>
     *                    BENEFIT,
     *                    TIME_SHEET,
     *                    TIME_OFF,
     *                    LANDING_PAGE,
     *                    TIME_OFF_REQUEST
     */
    public void screenChanger(Screen_Type screen_type) {
        String screen = null;
        String title = null;
        switch (screen_type) {
            case BENEFIT -> {
                screen = "/view/Benefits.fxml";
                title = "Benefits";
            }
            case TIME_SHEET -> {
                screen = "/view/TimeSheet.fxml";
                title = "Time Sheet";
            }
            case TIME_OFF -> {
                screen = "/view/TimeOff.fxml";
                title = "Time Off";
            }
            case LANDING_PAGE -> {
                screen = "/view/LandingPage.fxml";
                title = "Landing Page";
            }
            case TIME_OFF_REQUEST -> {
                screen = "/view/TimeOffRequest.fxml";
                title = "TIme Off Requests";
            }
        }
        changeScene(screen, title);
    }

    /**
     * Used to change the current FXML & controller files to another.
     *
     * @param screen the FXML file to be shown
     * @param title  the text to be displayed in the title bar of the new screen
     */
    private void changeScene(String screen, String title) {
        Parent main;
        try {
            main = FXMLLoader.load(App.class.getResource(screen));
            Scene scene = new Scene(main);
            Stage stage = App.getStage();
            stage.setScene(scene);
            stage.show();
            stage.setTitle(title);
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Active icons
    private final InputStream activeAboutIconStream = getClass().getResourceAsStream("/icons/navigation/aboutActive.png");
    private final InputStream activeBenefitIconStream = getClass().getResourceAsStream("/icons/navigation/benefitsActive.png");
    private final InputStream activeLandingIconStream = getClass().getResourceAsStream("/icons/navigation/landingpageActive.png");
    private final InputStream activeTimeSheetIconStream = getClass().getResourceAsStream("/icons/navigation/timesheetActive.png");
    private final InputStream activeTimeOffIconStream = getClass().getResourceAsStream("/icons/navigation/timeoffActive.png");

    //Inactive icons
    private final InputStream inactiveAboutIconStream = getClass().getResourceAsStream("/icons/navigation/aboutInactive.png");
    private final InputStream inactiveBenefitsIconStream = getClass().getResourceAsStream("/icons/navigation/benefitsInactive.png");
    private final InputStream inactiveLandingPageIconSteam = getClass().getResourceAsStream("/icons/navigation/landingpageInactive.png");
    private final InputStream inactiveTimeSheetIconStream = getClass().getResourceAsStream("/icons/navigation/timesheetInactive.png");
    private final InputStream inactiveTimeOffIconStream = getClass().getResourceAsStream("/icons/navigation/timeoffInactive.png");


    //Active Images created from their respective InputStream
    private final Image activeAboutIcon = new Image(activeAboutIconStream);
    private final Image activeBenefitsIcon = new Image(activeBenefitIconStream);
    private final Image activeLandingIcon = new Image(activeLandingIconStream);
    private final Image activeTimeSheetIcon = new Image(activeTimeSheetIconStream);
    private final Image activeTimeOffIcon = new Image(activeTimeOffIconStream);

    //Inactive Images created from their respective InputStream
    private final Image inactiveAboutIcon = new Image(inactiveAboutIconStream);
    private final Image inactiveBenefitsIcon = new Image(inactiveBenefitsIconStream);
    private final Image inactiveLandingIcon = new Image(inactiveLandingPageIconSteam);
    private final Image inactiveTimeSheetIcon = new Image(inactiveTimeSheetIconStream);
    private final Image inactiveTimeOffIcon = new Image(inactiveTimeOffIconStream);


    /**
     * @return icon for the (active) About navigation link
     */
    public Image getActiveAboutIcon() {
        return activeAboutIcon;
    }
    /**
     * @return icon for the (active) Benefit navigation link
     */
    public Image getActiveBenefitsIcon() {
        return activeBenefitsIcon;
    }
    /**
     * @return icon for the (active) Landing Page navigation link
     */
    public Image getActiveLandingIcon() {
        return activeLandingIcon;
    }
    /**
     * @return icon for the (active) TimeSheet navigation link
     */
    public Image getActiveTimeSheetIcon() {
        return activeTimeSheetIcon;
    }
    /**
     * @return icon for the (active) Time Off navigation link
     */
    public Image getActiveTimeOffIcon() {
        return activeTimeOffIcon;
    }
    /**
     * @return icon for the (inactive) About navigation link
     */
    public Image getInactiveAboutIcon() {
        return inactiveAboutIcon;
    }
    /**
     * @return icon for the (inactive) Benefit navigation link
     */
    public Image getInactiveBenefitsIcon() {
        return inactiveBenefitsIcon;
    }
    /**
     * @return icon for the (inactive) Landing Page navigation link
     */
    public Image getInactiveLandingIcon() {
        return inactiveLandingIcon;
    }
    /**
     * @return icon for the (inactive) TimeSheet navigation link
     */
    public Image getInactiveTimeSheetIcon() {
        return inactiveTimeSheetIcon;
    }
    /**
     * @return icon for the (inactive) Time Off navigation link
     */
    public Image getInactiveTimeOffIcon() {
        return inactiveTimeOffIcon;
    }
}
