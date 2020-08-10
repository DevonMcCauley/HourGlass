/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.*;

/**
 * @author Devon
 */
public class DBConnection {
    public static int appointmentReminderCounter;

    //<editor-fold desc="Database Connection Variables & Methods">
    // JDBC URL Parts
    private static final String PROTOCOL = "jdbc";
    private static final String VENDOR_NAME = ":mysql:";
    private static final String IP_ADDRESS = ""; //Enter your database IP address here

    // JDBC URL
    private static final String JDBC_URL = PROTOCOL + VENDOR_NAME + IP_ADDRESS;

    // Driver Interface & Connection Reference
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static Connection conn;

    // Database credentials
    private static final String USERNAME = ""; //Enter your database username 
    private static final String PASSWORD = ""; //Enter your database password
    //</editor-fold>

    // Starts the database connection
    public static void startConnection() {
        try {
            Class.forName(MYSQL_DRIVER);
            conn = (Connection) DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Closes the database connection
    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Method to submit query to MySQL database
    public static void submitQuery(String query) {
        Statement stmt;
        ResultSet result;
        try {
            stmt = conn.createStatement();

            if (query.toLowerCase().startsWith("select")) {
                result = stmt.executeQuery(query);
            } else if (query.toLowerCase().startsWith("delete") || query.toLowerCase().startsWith("insert") || query.toLowerCase().startsWith("update")) {
                stmt.executeUpdate(query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet selectEmployeeQuery() {
        Statement stmt;
        ResultSet result = null;

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT employeeID, firstname, lastname, username, password, department, role, payrate, exempt "
                    + "FROM employee "
                    + "ORDER BY lastname");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet findUser(String userAttempt) {
        Statement stmt;
        ResultSet result = null;

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT employeeID, firstname, lastname, username, password, department, role, payrate, exempt, timesheetID, benefitsID, beneficiaryID FROM employee WHERE username = '" + userAttempt + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet checkPay(String timesheetID) {
        Statement stmt;
        ResultSet result = null;

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT * FROM timesheet WHERE timesheetID = '" + timesheetID + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet checkTimeSheet(String timesheetID) {
        Statement stmt;
        ResultSet result = null;

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT * from timesheet where (timesheetID = " + timesheetID + " && (date_submitted between date_sub(curdate(), interval 7 day) and curdate()));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet findBeneficiary(String beneficiaryID) {
        Statement stmt;
        ResultSet result = null;

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT * FROM beneficiary WHERE beneficiaryID = '" + beneficiaryID + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet findBenefits(String benefitID) {
        Statement stmt;
        ResultSet result = null;

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT * FROM benefits WHERE benefitsID = '" + benefitID + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet findTimeRequests(String employeeID) {
        Statement stmt;
        ResultSet result = null;

        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT * FROM time_requests WHERE employeeID = '" + employeeID + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
