package view_controller;

import HourGlass.Main;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Employee;
import utilities.DBConnection;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {
    public static ArrayList<Employee> employeeList = new ArrayList();

    @FXML
    private Button btnLogin;

    @FXML
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
                    String employeeId = result.getString("employeeID");
                    String firstname = result.getString("firstname");
                    String lastname = result.getString("lastname");
                    String username = result.getString("username");
                    String password = result.getString("password");
                    String department = result.getString("department");
                    String role = result.getString("role");
                    String payrate = result.getString("payrate");
                    String exempt = result.getString("exempt");
                    String timesheetID = result.getString("timesheetID");
                    String benefitsID = result.getString("benefitsID");
                    String beneficiaryID = result.getString("beneficiaryID");

                    Employee employee = new Employee(new ReadOnlyStringWrapper(employeeId),
                            new ReadOnlyStringWrapper(firstname),
                            new ReadOnlyStringWrapper(lastname),
                            new ReadOnlyStringWrapper(username),
                            new ReadOnlyStringWrapper(password),
                            new ReadOnlyStringWrapper(department),
                            new ReadOnlyStringWrapper(role),
                            new ReadOnlyStringWrapper(payrate),
                            new ReadOnlyStringWrapper(exempt),
                            new ReadOnlyStringWrapper(timesheetID),
                            new ReadOnlyStringWrapper(benefitsID),
                            new ReadOnlyStringWrapper(beneficiaryID));
                    employeeList.add(employee);


                    if (userAttempt.equals(employee.getUsername().getValue()) && passAttempt.equals(employee.getPassword().getValue())) {

                        String screen = "/view_controller/LandingPage.fxml";
                        String title = "Landing Page";
                        Main.changeScene(screen, title);
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
