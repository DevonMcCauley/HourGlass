package org.devon.controller;


import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
<<<<<<< HEAD
import org.devon.model.Employee;
import org.devon.model.Screen_Type;
import org.devon.utilities.DBConnection;
import org.devon.utilities.ScreenManager;
=======
import org.devon.application.App;
import org.devon.model.Employee;
import org.devon.utilities.DBConnection;
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {
    public static ArrayList<Employee> employeeList = new ArrayList();

    @FXML
<<<<<<< HEAD
=======
    private Button btnLogin;

    @FXML
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void login(ActionEvent event) {

        String userAttempt = txtUsername.getText();
        String passAttempt = txtPassword.getText();

        if (userAttempt.isEmpty() || passAttempt.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You left a blank field", ButtonType.CLOSE);
            alert.showAndWait();
        } else {
            ResultSet result = DBConnection.findUser(userAttempt);
            try {
                if (result.next()) {
                    employeeList.clear();
                    String employeeId = result.getString("employee_id");
                    String firstname = result.getString("first_name");
                    String lastname = result.getString("last_name");
                    String username = result.getString("username");
                    String password = result.getString("password");
                    String department = result.getString("department");
                    String role = result.getString("role");
                    String payrate = result.getString("payrate");
                    String exempt = result.getString("overtime_exempt");
                    String timesheetId = result.getString("timesheet_id");
                    String benefitsId = result.getString("benefits_id");

                    Employee employee = new Employee(new ReadOnlyStringWrapper(employeeId),
                            new ReadOnlyStringWrapper(firstname),
                            new ReadOnlyStringWrapper(lastname),
                            new ReadOnlyStringWrapper(username),
                            new ReadOnlyStringWrapper(password),
                            new ReadOnlyStringWrapper(department),
                            new ReadOnlyStringWrapper(role),
                            new ReadOnlyStringWrapper(payrate),
                            new ReadOnlyStringWrapper(exempt),
                            new ReadOnlyStringWrapper(timesheetId),
                            new ReadOnlyStringWrapper(benefitsId));
                    employeeList.add(employee);


<<<<<<< HEAD
                    if (userAttempt.equals(employee.getUsername().getValue()) && passAttempt.equals(employee.getPassword().getValue())) {
                        ScreenManager screenManager = new ScreenManager();
                        screenManager.screenChanger(Screen_Type.LANDING_PAGE);
=======

                    if (userAttempt.equals(employee.getUsername().getValue()) && passAttempt.equals(employee.getPassword().getValue())) {

                        String screen = "/view/LandingPage.fxml";
                        String title = "Landing Page";
                        App.changeScene(screen, title);
>>>>>>> cc9f661fc72cc91d3798951eb3268bf2a8ac683b
                    } else if (!userAttempt.equals(employee.getUsername().getValue()) || !passAttempt.equals(employee.getPassword().getValue())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Username and/or password is/are not correct!", ButtonType.CLOSE);
                        alert.showAndWait();
                    }
                } else if (!result.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "User not found!", ButtonType.CLOSE);
                    alert.showAndWait();
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
