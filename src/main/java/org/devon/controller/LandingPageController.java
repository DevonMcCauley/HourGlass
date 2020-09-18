package org.devon.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.devon.model.About;
import org.devon.model.Employee;
import org.devon.model.Screen_Type;
import org.devon.utilities.ScreenManager;

=======
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.devon.application.App;
import org.devon.model.Employee;

import java.io.InputStream;
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
import java.net.URL;
import java.util.ResourceBundle;

import static org.devon.controller.LoginScreenController.employeeList;


public class LandingPageController implements Initializable {
<<<<<<< HEAD

    ScreenManager screenManager = new ScreenManager();
=======
    private String screen;
    private String title;
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b

    @FXML
    private ImageView btnLanding;

    @FXML
<<<<<<< HEAD
    private ImageView btnTimeSheet;
=======
    private ImageView btnSandSheet;
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b

    @FXML
    private ImageView btnBenefits;

    @FXML
    private ImageView btnTimeOff;

    @FXML
    private ImageView btnAbout;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;
    @FXML
    private Label lblDepartment;
    @FXML
    private Label lblRole;
    @FXML
    private Label lblEmployeeName;

<<<<<<< HEAD

    @FXML
    void BenefitsClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.BENEFIT);
    }

    @FXML
    void TimeSheetClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.TIME_SHEET);
    }

    @FXML
    void TimeOffClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.TIME_OFF);
    }

    @FXML
    void AboutClicked(MouseEvent event) {
        About about = new About();
        about.showAbout();
=======
    @FXML
    private ImageView imgDivider;

    @FXML
    void BenefitsClicked(MouseEvent event) {
        screen = "/view/Benefits.fxml";
        title = "Benefits";
        App.changeScene(screen,title);
    }

    @FXML
    void SandSheetClicked(MouseEvent event) {
        screen = "/view/SandSheet.fxml";
        title = "SandSheet";
        App.changeScene(screen, title);
    }

    @FXML
    void AboutClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "HourGlass was designed and developed by Devon McCauley. You are using version 1.0", ButtonType.OK);
        alert.setTitle("Information");
        alert.showAndWait();
    }

    @FXML
    void TimeOffClicked(MouseEvent event) {
        screen = "/view/TimeOff.fxml";
        title = "Time Off";
        App.changeScene(screen, title);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }


    //<editor-fold desc="Methods to style buttons">
    @FXML
    void changeAboutIcon(MouseEvent event) {
<<<<<<< HEAD
        btnAbout.setImage(screenManager.getActiveAboutIcon());
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/about2.png");
        Image about = new Image(inStream);
        btnAbout.setImage(about);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void changeBenefitsIcon(MouseEvent event) {
<<<<<<< HEAD
        btnBenefits.setImage(screenManager.getActiveBenefitsIcon());
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/benefits2.png");
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void changeLandingIcon(MouseEvent event) {
<<<<<<< HEAD
        btnLanding.setImage(screenManager.getActiveLandingIcon());
    }

    @FXML
    void changeTimeSheetIcon(MouseEvent event) {
        btnTimeSheet.setImage(screenManager.getActiveTimeSheetIcon());
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/landingpage2.png");
        Image landingpage2 = new Image(inStream);
        btnLanding.setImage(landingpage2);
    }



    @FXML
    void changeSandSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/timesheet2.png");
        Image sandsheet = new Image(inStream);
        btnSandSheet.setImage(sandsheet);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void changeTimeOffIcon(MouseEvent event) {
<<<<<<< HEAD
        btnTimeOff.setImage(screenManager.getActiveTimeOffIcon());
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/timeoff2.png");
        Image timeoff = new Image(inStream);
        btnTimeOff.setImage(timeoff);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void returnLandingIcon(MouseEvent event) {
<<<<<<< HEAD
        btnLanding.setImage(screenManager.getInactiveLandingIcon());
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/landingpage.png");
        Image landingpage = new Image(inStream);
        btnLanding.setImage(landingpage);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void returnAboutIcon(MouseEvent event) {
<<<<<<< HEAD
        btnAbout.setImage(screenManager.getInactiveAboutIcon());
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/about.png");
        Image about = new Image(inStream);
        btnAbout.setImage(about);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void returnBenefitsIcon(MouseEvent event) {
<<<<<<< HEAD
        btnBenefits.setImage(screenManager.getInactiveBenefitsIcon());
    }

    @FXML
    void returnTimeSheetIcon(MouseEvent event) {
        btnTimeSheet.setImage(screenManager.getInactiveTimeSheetIcon());
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/benefits.png");
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
    }

    @FXML
    void returnSandSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/timesheet.png");
        Image sandsheet = new Image(inStream);
        btnSandSheet.setImage(sandsheet);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void returnTimeOffIcon(MouseEvent event) {
<<<<<<< HEAD
        btnTimeOff.setImage(screenManager.getInactiveTimeOffIcon());
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/timeoff.png");
        Image timeoff = new Image(inStream);
        btnTimeOff.setImage(timeoff);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }
    //</editor-fold>

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Employee employee = employeeList.get(0);
        String employeeFirstName = employee.getFirstname().getValue();
        String employeeLastName = employee.getLastname().getValue();
        String employeeName = employeeFirstName + " " + employeeLastName;
        String employeeRole = employee.getRole().getValue();
        String employeeDepartment = employee.getDepartment().getValue();


        lblEmployeeName.setText(employeeName);
        lblFirstName.setText(employeeFirstName);
        lblLastName.setText(employeeLastName);
        lblRole.setText(employeeRole);
        lblDepartment.setText(employeeDepartment);

    }
}
