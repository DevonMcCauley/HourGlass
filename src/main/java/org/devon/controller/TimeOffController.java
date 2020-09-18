package org.devon.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
<<<<<<< HEAD
import org.devon.model.About;
import org.devon.model.Employee;
import org.devon.model.Screen_Type;
import org.devon.model.TimeRequest;
import org.devon.utilities.ScreenManager;
=======
import org.devon.application.App;
import org.devon.model.Employee;
import org.devon.model.TimeRequest;
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b

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

<<<<<<< HEAD
    ScreenManager screenManager = new ScreenManager();
=======
    //Variables to change scene
    String title;
    String screen;
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b


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
<<<<<<< HEAD
        screenManager.screenChanger(Screen_Type.TIME_OFF_REQUEST);
=======
        screen = "/view/ViewTimeOff.fxml";
        title = "Time Off Requests";

        App.changeScene(screen, title);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    //<editor-fold desc="Navigation Methods">
    @FXML
    void BenefitsClicked(MouseEvent event) {
<<<<<<< HEAD
        screenManager.screenChanger(Screen_Type.BENEFIT);
=======
        screen = "/view/Benefits.fxml";
        title = "Benefits";
        App.changeScene(screen, title);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void LandingClicked(MouseEvent event) {
<<<<<<< HEAD
        screenManager.screenChanger(Screen_Type.LANDING_PAGE);
=======
        screen = "/view/LandingPage.fxml";
        title = "LandingPage";
        App.changeScene(screen, title);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void AboutClicked(MouseEvent event) {
<<<<<<< HEAD
        About about = new About();
        about.showAbout();
    }

    @FXML
    void TimeSheetClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.TIME_SHEET);
=======
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "HourGlass was designed and developed by Devon McCauley. You are using version 1.0", ButtonType.OK);
        alert.setTitle("Information");
        alert.showAndWait();
    }

    @FXML
    void SandSheetClicked(MouseEvent event) {
        screen = "/view/SandSheet.fxml";
        title = "SandSheet";
        App.changeScene(screen, title);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }


    //</editor-fold>

    //<editor-fold desc="Styling Methods for the ImageView/Button Links">
    @FXML
    void changeAboutIcon(MouseEvent event) {
<<<<<<< HEAD
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/aboutActive.png");
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/about2.png");
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
        Image about = new Image(inStream);
        btnAbout.setImage(about);
    }

    @FXML
    void changeBenefitsIcon(MouseEvent event) {
<<<<<<< HEAD
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/benefitsActive.png");
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/benefits2.png");
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
    }

    @FXML
    void changeLandingIcon(MouseEvent event) {
<<<<<<< HEAD
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/landingpageActive.png");
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/landingpage2.png");
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
        Image landingpage2 = new Image(inStream);
        btnLanding.setImage(landingpage2);
    }

    @FXML
<<<<<<< HEAD
    void changeTimeSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/timesheetActive.png");
        Image TimeSheet = new Image(inStream);
        btnTimeSheet.setImage(TimeSheet);
=======
    void changeSandSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/timesheet2.png");
        Image sandsheet = new Image(inStream);
        btnSandSheet.setImage(sandsheet);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void changeTimeOffIcon(MouseEvent event) {
<<<<<<< HEAD
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/timeoffActive.png");
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/timeoff2.png");
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
        Image timeoff = new Image(inStream);
        btnTimeOff.setImage(timeoff);
    }

    @FXML
    void returnLandingIcon(MouseEvent event) {
<<<<<<< HEAD
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/landingpageInactive.png");
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/landingpage.png");
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
        Image landingpage = new Image(inStream);
        btnLanding.setImage(landingpage);
    }

    @FXML
    void returnAboutIcon(MouseEvent event) {
<<<<<<< HEAD
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/aboutInactive.png");
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/about.png");
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
        Image about = new Image(inStream);
        btnAbout.setImage(about);
    }

    @FXML
    void returnBenefitsIcon(MouseEvent event) {
<<<<<<< HEAD
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/benefitsInactive.png");
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/benefits.png");
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
    }

    @FXML
<<<<<<< HEAD
    void returnTimeSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/timesheetInactive.png");
        Image TimeSheet = new Image(inStream);
        btnTimeSheet.setImage(TimeSheet);
=======
    void returnSandSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/timesheet.png");
        Image sandsheet = new Image(inStream);
        btnSandSheet.setImage(sandsheet);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    }

    @FXML
    void returnTimeOffIcon(MouseEvent event) {
<<<<<<< HEAD
        InputStream inStream = getClass().getResourceAsStream("/icons/navigation/timeoffInactive.png");
=======
        InputStream inStream = getClass().getResourceAsStream("/icons/timeoff.png");
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
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

