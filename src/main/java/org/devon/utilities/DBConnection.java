/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.devon.utilities;

import java.sql.*;

/**
 * @author Devon
 */
public class DBConnection {
    public static int appointmentReminderCounter;

    //<editor-fold desc="Database Connection Variables & Methods">
    // JDBC URL Parts
    private static final String PROTOCOL = System.getenv("PROTOCOL"); //Enter database protocol here
    private static final String VENDOR_NAME = System.getenv("VENDOR"); //Enter database vendor name here
    private static final String IP_ADDRESS = System.getenv("IP_ADDRESS"); //Enter your database IP address here

    // JDBC URL
    private static final String JDBC_URL = PROTOCOL + VENDOR_NAME + IP_ADDRESS;

    //private static Connection conn;
    private static Connection conn;

    // Database credentials
    private static final String USERNAME = System.getenv("USERNAME"); //Enter your database username
    private static final String PASSWORD = System.getenv("PASSWORD"); //Enter your database password
    //</editor-fold>

    // Starts the database connection
    public static void startConnection() {
        try{
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException ex){
            ex.printStackTrace();
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
            result = stmt.executeQuery("SELECT employee_id, first_name, last_name, username, password, department, role, payrate, overtime_exempt "
                    + "FROM employee "
                    + "ORDER BY last_name");
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
            result = stmt.executeQuery("SELECT employee_id, first_name, last_name, username, password, department, role, payrate, overtime_exempt, timesheet_id, benefits_id FROM employee WHERE username = '" + userAttempt + "';");

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
            result = stmt.executeQuery("SELECT * FROM timesheet WHERE timesheet_id = '" + timesheetID + "';");

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
            result = stmt.executeQuery("SELECT * from timesheet where (timesheet_id = " + timesheetID + " && (date_submitted between date_sub(curdate(), interval 7 day) and curdate()));");
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
            result = stmt.executeQuery("SELECT * FROM benefit WHERE benefit_id = '" + benefitID + "';");
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
            result = stmt.executeQuery("SELECT * FROM time_request WHERE employee_id = '" + employeeID + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
