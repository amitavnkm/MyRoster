package anakar01.packag.com.myroster.Database;

import java.util.ArrayList;

public class Employee {

    private String employeeName, employeeEmail, employeeMobile;

    public Employee(String employeeName, String employeeEmail, String employeeMobile) {
        setEmployeeName(employeeName);
        setEmployeeEmail(employeeEmail);
        setEmployeeMobile(employeeMobile);
            }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(String employeeMobile) {
        this.employeeMobile = employeeMobile;
    }
}

