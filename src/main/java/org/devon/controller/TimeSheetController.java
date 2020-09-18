package org.devon.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.devon.model.About;
import org.devon.model.Employee;
import org.devon.model.Screen_Type;
import org.devon.utilities.DBConnection;
import org.devon.utilities.ScreenManager;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.devon.controller.LoginScreenController.employeeList;
import static org.devon.utilities.DBConnection.submitQuery;


public class TimeSheetController implements Initializable {
    //<editor-fold desc="FXML Declarations">
    @FXML
    private Button btnTotalHours;
    @FXML
    private Label lblGrossPay;

    @FXML
    private TextField txtMonday;

    @FXML
    private TextField txtTuesday;

    @FXML
    private TextField txtWednesday;

    @FXML
    private TextField txtThursday;

    @FXML
    private TextField txtFriday;

    @FXML
    private TextField txtSaturday;

    @FXML
    private TextField txtSunday;

    @FXML
    private Label lblTotal;

    @FXML
    private Button btnSubmit;

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
    //</editor-fold>



    ScreenManager screenManager = new ScreenManager();

    //Calculates the total hours for this week
    @FXML
    void TotalHours(ActionEvent event) {
        try {
            //Gets text form text boxes
            String monday = txtMonday.getText();
            String tuesday = txtTuesday.getText();
            String wednesday = txtWednesday.getText();
            String thursday = txtThursday.getText();
            String friday = txtFriday.getText();
            String saturday = txtSaturday.getText();
            String sunday = txtSunday.getText();

            if (monday.isEmpty() || tuesday.isEmpty() || wednesday.isEmpty() || thursday.isEmpty() || friday.isEmpty() || saturday.isEmpty() || sunday.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "You left an empty field!", ButtonType.OK);
                alert.showAndWait();
                btnSubmit.setDisable(true);
            } else {
                if (!checkNumbers(monday) && !checkNumbers(tuesday) && !checkNumbers(wednesday) && !checkNumbers(thursday) && !checkNumbers(friday) && !checkNumbers(saturday) && !checkNumbers(sunday)) {
                    Double monHours = Double.parseDouble(monday);
                    Double tuesHours = Double.parseDouble(tuesday);
                    Double wedHours = Double.parseDouble(wednesday);
                    Double thursHours = Double.parseDouble(thursday);
                    Double friHours = Double.parseDouble(friday);
                    Double satHours = Double.parseDouble(saturday);
                    Double sunHours = Double.parseDouble(sunday);

                    double hoursWorked = monHours + tuesHours + wedHours + thursHours + friHours + satHours + sunHours;
                    lblTotal.setText(Double.toString(hoursWorked));
                    btnSubmit.setDisable(false);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "A field contains illegal characters!", ButtonType.OK);
                    alert.showAndWait();
                    btnSubmit.setDisable(true);
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    //Submits employee timesheet into the database
    @FXML
    void submit(ActionEvent event) {

        Employee employee = employeeList.get(0);
        String timesheetID = employee.getTimesheetID().getValue();
        double payRate = Double.parseDouble(employee.getPayrate().getValue());

        double hours = Double.parseDouble(lblTotal.getText());
        double grossPay = hours * payRate;


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "By submitting your timesheet, you understand and affirm that you have carefully reviewed the accuracy of the form.", ButtonType.YES, ButtonType.CANCEL);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        Optional<ButtonType> alertResult = alert.showAndWait();

        if (alertResult.get() == ButtonType.YES) {
            lblGrossPay.setText("$" + Double.toString(grossPay));
            String sqlStatement = "UPDATE timesheet SET hours = "+ hours + ", date_submitted = curdate(), gross_pay = "+ grossPay+" WHERE timesheet_id = "+timesheetID +" ;";
            submitQuery(sqlStatement);
            btnSubmit.setDisable(true);
        }
    }

    //Checks if number fields contain letters
    private boolean checkNumbers(String number) {
        boolean containsLetters;
        if (number.matches("[0-9]+")) {
            containsLetters = false;
        } else {
            containsLetters = true;
        }
        return containsLetters;
    }

    //<editor-fold desc="Navigation Methods">
    @FXML
    void BenefitsClicked(MouseEvent event) {

        screenManager.screenChanger(Screen_Type.BENEFIT);
    }

    @FXML
    void LandingClicked(MouseEvent event) {

        screenManager.screenChanger(Screen_Type.LANDING_PAGE);
    }

    @FXML
    void AboutClicked(MouseEvent event) {
        About about = new About();
        about.showAbout();
    }

    @FXML
    void TimeOffClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.TIME_OFF);
    }
    //</editor-fold>

    //<editor-fold desc="Styling Methods for the ImageView/Button Links">
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
        String timesheetID = employee.getTimesheetID().getValue();
        Double estimate_pay = 0.0;

        //Checks database to ensure only one timesheet is submitted each week
        try {
            ResultSet result = DBConnection.checkTimeSheet(timesheetID);

            if (result.next()) {
                btnTotalHours.setDisable(true);
                txtMonday.setDisable(true);
                txtTuesday.setDisable(true);
                txtWednesday.setDisable(true);
                txtThursday.setDisable(true);
                txtFriday.setDisable(true);
                txtSaturday.setDisable(true);
                txtSunday.setDisable(true);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You've already submitted a timesheet for this week. However, You may still view your information.", ButtonType.OK);
                alert.setTitle("Notice");
                alert.setHeaderText("Notice");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

//        //Queries database to calculate the estimated pay for this week
//        try {
//            ResultSet result = checkPay(timesheetID);
//
//            if (result.next()) {
//                estimate_pay = result.getDouble("gross_pay");
//            }
//
//            lblGrossPay.setText("$" + estimate_pay.toString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
