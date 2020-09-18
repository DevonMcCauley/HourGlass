package org.devon.controller;


import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import org.devon.model.Employee;
import org.devon.model.Screen_Type;
import org.devon.model.TimeRequest;
import org.devon.utilities.DBConnection;
import org.devon.utilities.ScreenManager;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static org.devon.controller.LoginScreenController.employeeList;
import static org.devon.utilities.DBConnection.submitQuery;


public class TimeOffRequestController implements Initializable {

    ScreenManager screenManager = new ScreenManager();

    @FXML
    private TableView<TimeRequest> tblTimes;
    @FXML
    private TableColumn<TimeRequest, String> colStartDate;

    @FXML
    private TableColumn<TimeRequest, String> colEndDate;

    @FXML
    private TableColumn<TimeRequest, String> colReason;

    @FXML
    private TableColumn<TimeRequest, String> colDateRequested;

    @FXML
    private ImageView imgDivider;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDeleteRequest;

    @FXML
    void Back(ActionEvent event) {
        screenManager.screenChanger(Screen_Type.TIME_OFF);
    }

    @FXML
    void DeleteRequest(ActionEvent event) {
    //Deletes an appointment record from the database
        String sqlStatement;

        TimeRequest timeRequest = tblTimes.getSelectionModel().getSelectedItem();

        //Ensure that user selects an appointment record
        if (timeRequest == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Time selection blank");
            alert.showAndWait();
        } else {
            try {
                sqlStatement = "DELETE FROM time_request WHERE time_request_id = " + timeRequest.getTime_request_id().getValue() + ";";
                submitQuery(sqlStatement);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Time request deleted", ButtonType.CLOSE);
                alert.showAndWait();
                callDatabase();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    private void callDatabase() {
        ObservableList<TimeRequest> requestList = FXCollections.observableArrayList();
        Employee employee = employeeList.get(0);
        String employeeID = employee.getEmployeeId().getValue();

        ResultSet result = DBConnection.findTimeRequests(employeeID);

        colStartDate.setCellValueFactory(cellData -> {
            return cellData.getValue().getStart_date();
        });

        colEndDate.setCellValueFactory(cellData -> {
            return cellData.getValue().getEnd_date();
        });
        colReason.setCellValueFactory(cellData -> {
            return cellData.getValue().getReason();
        });
        colDateRequested.setCellValueFactory(cellData -> {
            return cellData.getValue().getDate_requested();
        });


        try {

            while (result.next()) {
                String time_request_id = result.getString("time_request_id");
                String start_date = result.getString("start_date");
                String end_date = result.getString("end_date");
                String reason = result.getString("reason");
                String date_requested = result.getString("date_requested");
                String emp = result.getString("employee_id");

                TimeRequest time = new TimeRequest(new ReadOnlyStringWrapper(time_request_id),
                        new ReadOnlyStringWrapper(start_date),
                        new ReadOnlyStringWrapper(end_date),
                        new ReadOnlyStringWrapper(reason),
                        new ReadOnlyStringWrapper(date_requested),
                        new ReadOnlyStringWrapper(emp));
                requestList.add(time);

            }

            tblTimes.setItems(requestList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        callDatabase();
    }

}


