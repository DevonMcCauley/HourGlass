package org.devon.model;

import javafx.beans.value.ObservableValue;

public class Employee {
    private ObservableValue<String> employeeId;
    private ObservableValue<String> firstname;
    private ObservableValue<String> lastname;
    private ObservableValue<String> username;
    private ObservableValue<String> password;
    private ObservableValue<String> department;
    private ObservableValue<String> role;
    private ObservableValue<String> payrate;
    private ObservableValue<String> exempt;
    private ObservableValue<String> timesheetID;
    private ObservableValue<String> benefitsID;


    public Employee(ObservableValue<String> employeeId, ObservableValue<String> firstname, ObservableValue<String> lastname, ObservableValue<String> username, ObservableValue<String> password, ObservableValue<String> department, ObservableValue<String> role, ObservableValue<String> payrate, ObservableValue<String> exempt, ObservableValue<String> timesheetID, ObservableValue<String> benefitsID) {
        this.employeeId = employeeId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.department = department;
        this.role = role;
        this.payrate = payrate;
        this.exempt = exempt;
        this.timesheetID = timesheetID;
        this.benefitsID = benefitsID;
    }

    //Getters
    public ObservableValue<String> getEmployeeId() {
        return employeeId;
    }

    public ObservableValue<String> getFirstname() {
        return firstname;
    }

    public ObservableValue<String> getLastname() {
        return lastname;
    }

    public ObservableValue<String> getUsername() {
        return username;
    }

    public ObservableValue<String> getPassword() {
        return password;

    }

    public ObservableValue<String> getDepartment() {
        return department;
    }

    public ObservableValue<String> getRole() {
        return role;
    }

    public ObservableValue<String> getPayrate() {
        return payrate;
    }

    public ObservableValue<String> getExempt() {
        return exempt;
    }

    public ObservableValue<String> getTimesheetID() {
        return timesheetID;
    }

    public ObservableValue<String> getBenefitsID() {
        return benefitsID;
    }

}


