package com.api.hourglassapi.repositories;

import com.api.hourglassapi.models.Employee;
import com.api.hourglassapi.models.Employees;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeUtil {

    /* Method to read all the users from the employees.xml file */

    public static List<Employee> readEmployee() {

        Employees employees = new Employees();

        try {
            File employeesFile = new File(System.getProperty("java.io.tmpdir") + "users.xml");
            System.out.println("The users.xml file can be found here: " + System.getProperty("java.io.tmpdir"));
            if (employeesFile.exists() && !employeesFile.isDirectory()) {

                JAXBContext context = JAXBContext.newInstance(Employees.class);
                Unmarshaller um = context.createUnmarshaller();
                employees = (Employees) um.unmarshal(employeesFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees.getEmployees();
    }

    /*
     * Method to write a new user to the users.xml file.
     */
    public static void registerEmployee(Employee employee) throws IOException {

        try {
            List<Employee> employees = readEmployee();
            employees.add(employee);

            System.out.println(employee.toString());

            JAXBContext context;
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter(new File(System.getProperty("java.io.tmpdir") + "users.xml")));
            context = JAXBContext.newInstance(Employees.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(new Employees(employees), writer);
            writer.close();
            System.out.println(System.getProperty("java.io.tmpdir"));


        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
