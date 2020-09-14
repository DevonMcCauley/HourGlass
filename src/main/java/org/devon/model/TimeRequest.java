package org.devon.model;

import javafx.beans.value.ObservableValue;

public class TimeRequest {
    private ObservableValue<String> time_request_id;
    private ObservableValue<String> start_date;
    private ObservableValue<String> end_date;
    private ObservableValue<String> reason;
    private ObservableValue<String> date_requested;
    private ObservableValue<String> employeeID;

    public TimeRequest(ObservableValue<String> time_request_id, ObservableValue<String> start_date, ObservableValue<String> end_date, ObservableValue<String> reason, ObservableValue<String> date_requested, ObservableValue<String> employeeID) {
        this.time_request_id = time_request_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.reason = reason;
        this.date_requested = date_requested;
        this.employeeID = employeeID;
    }

    //Getters
    public ObservableValue<String> getTime_request_id() {
        return time_request_id;
    }

    public ObservableValue<String> getStart_date() {
        return start_date;
    }

    public ObservableValue<String> getEnd_date() {
        return end_date;
    }

    public ObservableValue<String> getReason() {
        return reason;
    }

    public ObservableValue<String> getDate_requested() {
        return date_requested;
    }

    public ObservableValue<String> getEmployeeID() {
        return employeeID;

    }
}
