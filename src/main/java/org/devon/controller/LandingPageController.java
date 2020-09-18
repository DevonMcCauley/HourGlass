package org.devon.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.devon.model.About;
import org.devon.model.Employee;
import org.devon.model.Screen_Type;
import org.devon.utilities.ScreenManager;

import java.net.URL;
import java.util.ResourceBundle;

import static org.devon.controller.LoginScreenController.employeeList;


public class LandingPageController implements Initializable {

    ScreenManager screenManager = new ScreenManager();

    @FXML
    private ImageView btnLanding;

    @FXML
    private ImageView btnTimeSheet;

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
    }


    //<editor-fold desc="Methods to style buttons">
    @FXML
    void changeAboutIcon(MouseEvent event) {
        btnAbout.setImage(screenManager.getActiveAboutIcon());
    }

    @FXML
    void changeBenefitsIcon(MouseEvent event) {
        btnBenefits.setImage(screenManager.getActiveBenefitsIcon());
    }

    @FXML
    void changeLandingIcon(MouseEvent event) {
        btnLanding.setImage(screenManager.getActiveLandingIcon());
    }

    @FXML
    void changeTimeSheetIcon(MouseEvent event) {
        btnTimeSheet.setImage(screenManager.getActiveTimeSheetIcon());
    }

    @FXML
    void changeTimeOffIcon(MouseEvent event) {
        btnTimeOff.setImage(screenManager.getActiveTimeOffIcon());
    }

    @FXML
    void returnLandingIcon(MouseEvent event) {
        btnLanding.setImage(screenManager.getInactiveLandingIcon());
    }

    @FXML
    void returnAboutIcon(MouseEvent event) {
        btnAbout.setImage(screenManager.getInactiveAboutIcon());
    }

    @FXML
    void returnBenefitsIcon(MouseEvent event) {
        btnBenefits.setImage(screenManager.getInactiveBenefitsIcon());
    }

    @FXML
    void returnTimeSheetIcon(MouseEvent event) {
        btnTimeSheet.setImage(screenManager.getInactiveTimeSheetIcon());
    }

    @FXML
    void returnTimeOffIcon(MouseEvent event) {
        btnTimeOff.setImage(screenManager.getInactiveTimeOffIcon());
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
