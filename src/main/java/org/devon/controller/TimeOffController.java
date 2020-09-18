package org.devon.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.devon.model.About;
import org.devon.model.Employee;
import org.devon.model.Screen_Type;
import org.devon.model.TimeRequest;
import org.devon.utilities.ScreenManager;

import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.devon.controller.LoginScreenController.employeeList;
import static org.devon.utilities.DBConnection.submitQuery;


public class TimeOffController implements Initializable {
    @FXML
    private Button btnViewRequests;

    //Array list to hold TimeRequest objects
    public static ArrayList<TimeRequest> requestList = new ArrayList();

    ScreenManager screenManager = new ScreenManager();


    //<editor-fold desc="FXML Declarations">
    @FXML
    private TextField txtReason;

    @FXML
    private DatePicker calStartDate;

    @FXML
    private DatePicker calEndDate;

    @FXML
    private Label lblReason;

    @FXML
    private ImageView imgDivider;

    @FXML
    private Button btnRequest;
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
    private Button btnTotalHours;
    //</editor-fold>


    //Submits requested time off to database
    @FXML
    void RequestTime(ActionEvent event) {
        try {
            Employee employee = employeeList.get(0);
            String employeeID = employee.getEmployeeId().getValue();
            LocalDate startDate = calStartDate.getValue();
            LocalDate endDate = calEndDate.getValue();
            LocalDate dateRequested = LocalDate.now();
            String reason = txtReason.getText();
            if (startDate == null || endDate == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Dates cannot be null", ButtonType.OK);
                alert.setTitle("Null Dates");
                alert.setHeaderText("Null Dates");
                alert.showAndWait();
            } else {

                String sqlStatement = "INSERT INTO time_request (start_date, end_date, reason, date_requested, employee_id) VALUES ('" + startDate + "', '" + endDate + "', '" + reason + "', '" + dateRequested + "', '" + employeeID + "');";
                submitQuery(sqlStatement);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Request Successful", ButtonType.OK);
                alert.setTitle("Successful");
                alert.setHeaderText("Successful");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ViewRequests(ActionEvent event) {
        screenManager.screenChanger(Screen_Type.TIME_OFF_REQUEST);
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
    void TimeSheetClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.TIME_SHEET);
    }


    //</editor-fold>

    //<editor-fold desc="Styling Methods for the ImageView/Button Links">
    @FXML
    void changeAboutIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/aboutActive.png");
        Image about = new Image(inStream);
        btnAbout.setImage(about);
    }

    @FXML
    void changeBenefitsIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/benefitsActive.png");
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
    }

    @FXML
    void changeLandingIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/landingpageActive.png");
        Image landingpage2 = new Image(inStream);
        btnLanding.setImage(landingpage2);
    }

    @FXML
    void changeTimeSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/timesheetActive.png");
        Image TimeSheet = new Image(inStream);
        btnTimeSheet.setImage(TimeSheet);
    }

    @FXML
    void changeTimeOffIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/timeoffActive.png");
        Image timeoff = new Image(inStream);
        btnTimeOff.setImage(timeoff);
    }

    @FXML
    void returnLandingIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/landingpageInactive.png");
        Image landingpage = new Image(inStream);
        btnLanding.setImage(landingpage);
    }

    @FXML
    void returnAboutIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/aboutInactive.png");
        Image about = new Image(inStream);
        btnAbout.setImage(about);
    }

    @FXML
    void returnBenefitsIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/benefitsInactive.png");
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
    }

    @FXML
    void returnTimeSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/timesheetInactive.png");
        Image TimeSheet = new Image(inStream);
        btnTimeSheet.setImage(TimeSheet);
    }

    @FXML
    void returnTimeOffIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/timeoffInactive.png");
        Image timeoff = new Image(inStream);
        btnTimeOff.setImage(timeoff);
    }


    //</editor-fold>

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calEndDate.setDisable(true);

        //Prevents days before the selected date from being selected
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);
                                LocalDate today = LocalDate.now();
                                setDisable(empty || item.compareTo(today) < 0);
                                if (item.isBefore(calStartDate.getValue().plusDays(1))) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        calEndDate.setDayCellFactory(dayCellFactory);


        //Prevents days before the current date from being selected
        Callback<DatePicker, DateCell> callB = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        LocalDate today = LocalDate.now();
                        setDisable(empty || item.compareTo(today) < 0);
                        calEndDate.setDisable(false);
                    }

                };
            }

        };
        calStartDate.setDayCellFactory(callB);


    }
}

