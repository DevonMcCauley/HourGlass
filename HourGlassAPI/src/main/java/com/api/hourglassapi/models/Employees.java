package com.api.hourglassapi.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

// Class for the Users
// This is returned by the API
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employees")
public class Employees {

    @XmlElement(name = "employee", type = Employee.class)
    private List<Employee> employees = new ArrayList<>();

    public Employees() { }

    public Employees(List<Employee> users) {
        this.employees = users;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> users) {
        this.employees = users;
    }

}