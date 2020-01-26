package view_controller;

import HourGlass.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import model.Employee;
import model.TimeRequest;

import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static utilities.DBConnection.submitQuery;
import static view_controller.LoginScreenController.employeeList;

public class TimeOffController implements Initializable {
    @FXML
    private Button btnViewRequests;

    //Array list to hold TimeRequest objects
    public static ArrayList<TimeRequest> requestList = new ArrayList();

    //Variables to change scene
    String title;
    String screen;


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
    private ImageView btnSandSheet;

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
            }
            else {

                String sqlStatement = "INSERT INTO time_requests (start_date, end_date, reason, date_requested, employeeID) VALUES ('" + startDate + "', '" + endDate + "', '" + reason + "', '" + dateRequested + "', '" + employeeID + "');";
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
        screen =  "/view_controller/ViewTimeOff.fxml";
        title = "Time Off Requests";

        Main.changeScene(screen, title);
    }

    //<editor-fold desc="Navigation Methods">
    @FXML
    void BenefitsClicked(MouseEvent event) {
        screen = "/view_controller/Benefits.fxml";
        title = "Benefits";
        Main.changeScene(screen, title);
    }

    @FXML
    void LandingClicked(MouseEvent event) {
        screen = "/view_controller/LandingPage.fxml";
        title = "LandingPage";
        Main.changeScene(screen, title);
    }

    @FXML
    void AboutClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "HourGlass was designed and developed by Devon McCauley. You are using version 1.0", ButtonType.OK);
        alert.setTitle("Information");
        alert.showAndWait();
    }

    @FXML
    void SandSheetClicked(MouseEvent event) {
        screen = "/view_controller/SandSheet.fxml";
        title = "SandSheet";
        Main.changeScene(screen, title);
    }


    //</editor-fold>

    //<editor-fold desc="Styling Methods for the ImageView/Button Links">
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

