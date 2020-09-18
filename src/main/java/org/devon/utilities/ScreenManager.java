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

public class ScreenManager {




    public void screenChanger(Screen_Type screen_type){
        String screen = null;
        String title = null;
        switch(screen_type){
            case BENEFIT:
                screen = "/view/Benefits.fxml";
                title = "Benefits";
                break;
            case TIME_SHEET:
                screen = "/view/TimeSheet.fxml";
                title = "Time Sheet";
                break;
            case TIME_OFF:
                 screen = "/view/TimeOff.fxml";
                 title = "Time Off";
                break;
            case LANDING_PAGE:
                screen = "/view/LandingPage.fxml";
                title = "Landing Page";
                break;
            case TIME_OFF_REQUEST:
                screen = "/view/TimeOffRequest.fxml";
                title = "TIme Off Requests";
                break;
        }
        changeScene(screen, title);
    }

    //Method to change the scene
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
    InputStream activeAboutIconStream = getClass().getResourceAsStream("/icons/navigation/aboutActive.png");
    InputStream activeBenefitIconStream = getClass().getResourceAsStream("/icons/navigation/benefitsActive.png");
    InputStream activeLandingIconStream = getClass().getResourceAsStream("/icons/navigation/landingpageActive.png");
    InputStream activeTimeSheetIconStream = getClass().getResourceAsStream("/icons/navigation/timesheetActive.png");
    InputStream activeTimeOffIconStream = getClass().getResourceAsStream("/icons/navigation/timeoffActive.png");

    //Inactive icons
    InputStream inactiveAboutIconStream = getClass().getResourceAsStream("/icons/navigation/aboutInactive.png");
    InputStream inactiveBenefitsIconStream = getClass().getResourceAsStream("/icons/navigation/benefitsInactive.png");
    InputStream inactiveLandingPageIconSteam = getClass().getResourceAsStream("/icons/navigation/landingpageInactive.png");
    InputStream inactiveTimeSheetIconStream = getClass().getResourceAsStream("/icons/navigation/timesheetInactive.png");
    InputStream inactiveTimeOffIconStream = getClass().getResourceAsStream("/icons/navigation/timeoffInactive.png");



    private final Image activeAboutIcon = new Image(activeAboutIconStream);
    private final Image activeBenefitsIcon = new Image(activeBenefitIconStream);
    private final Image activeLandingIcon = new Image(activeLandingIconStream);
    private final Image activeTimeSheetIcon = new Image(activeTimeSheetIconStream);
    private final Image activeTimeOffIcon = new Image(activeTimeOffIconStream);

    private final Image inactiveAboutIcon = new Image(inactiveAboutIconStream);
    private final Image inactiveBenefitsIcon = new Image(inactiveBenefitsIconStream);
    private final Image inactiveLandingIcon = new Image(inactiveLandingPageIconSteam);
    private final Image inactiveTimeSheetIcon = new Image(inactiveTimeSheetIconStream);
    private final Image inactiveTimeOffIcon = new Image(inactiveTimeOffIconStream);


    public Image getActiveAboutIcon() {
        return activeAboutIcon;
    }

    public Image getActiveBenefitsIcon() {
        return activeBenefitsIcon;
    }

    public Image getActiveLandingIcon() {
        return activeLandingIcon;
    }

    public Image getActiveTimeSheetIcon() {
        return activeTimeSheetIcon;
    }

    public Image getActiveTimeOffIcon() {
        return activeTimeOffIcon;
    }

    public Image getInactiveAboutIcon() {
        return inactiveAboutIcon;
    }

    public Image getInactiveBenefitsIcon() {
        return inactiveBenefitsIcon;
    }

    public Image getInactiveLandingIcon() {
        return inactiveLandingIcon;
    }

    public Image getInactiveTimeSheetIcon() {
        return inactiveTimeSheetIcon;
    }

    public Image getInactiveTimeOffIcon() {
        return inactiveTimeOffIcon;
    }
}
