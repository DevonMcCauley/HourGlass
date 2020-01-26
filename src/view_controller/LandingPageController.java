package view_controller;

import HourGlass.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Employee;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import static view_controller.LoginScreenController.employeeList;

public class LandingPageController implements Initializable {
    private String screen;
    private String title;

    @FXML
    private ImageView btnLanding;

    @FXML
    private ImageView btnSandSheet;

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
    private ImageView imgDivider;

    @FXML
    void BenefitsClicked(MouseEvent event) {
        screen = "/view_controller/Benefits.fxml";
        title = "Benefits";
        Main.changeScene(screen,title);
    }

    @FXML
    void SandSheetClicked(MouseEvent event) {
        screen = "/view_controller/SandSheet.fxml";
        title = "SandSheet";
        Main.changeScene(screen, title);
    }

    @FXML
    void AboutClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "HourGlass was designed and developed by Devon McCauley. You are using version 1.0", ButtonType.OK);
        alert.setTitle("Information");
        alert.showAndWait();
    }

    @FXML
    void TimeOffClicked(MouseEvent event) {
        screen = "/view_controller/TimeOff.fxml";
        title = "Time Off";
        Main.changeScene(screen, title);
    }


    //<editor-fold desc="Methods to style buttons">
    @FXML
    void changeAboutIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/about2.png");
        Image about = new Image(inStream);
        btnAbout.setImage(about);
    }

    @FXML
    void changeBenefitsIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/benefits2.png");
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
    }

    @FXML
    void changeLandingIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/landingpage2.png");
        Image landingpage2 = new Image(inStream);
        btnLanding.setImage(landingpage2);
    }



    @FXML
    void changeSandSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/timesheet2.png");
        Image sandsheet = new Image(inStream);
        btnSandSheet.setImage(sandsheet);
    }

    @FXML
    void changeTimeOffIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/timeoff2.png");
        Image timeoff = new Image(inStream);
        btnTimeOff.setImage(timeoff);
    }

    @FXML
    void returnLandingIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/landingpage.png");
        Image landingpage = new Image(inStream);
        btnLanding.setImage(landingpage);
    }

    @FXML
    void returnAboutIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/about.png");
        Image about = new Image(inStream);
        btnAbout.setImage(about);
    }

    @FXML
    void returnBenefitsIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/benefits.png");
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
    }

    @FXML
    void returnSandSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/timesheet.png");
        Image sandsheet = new Image(inStream);
        btnSandSheet.setImage(sandsheet);
    }

    @FXML
    void returnTimeOffIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/resources/icons/timeoff.png");
        Image timeoff = new Image(inStream);
        btnTimeOff.setImage(timeoff);
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
