package model;

import java.time.LocalDate;

public class Attendance {
    private int employeeId;
    private LocalDate date;
    private double hoursWorked;

    public Attendance(int employeeId, LocalDate date, double hoursWorked) {
        this.employeeId = employeeId;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }

    public int getEmployeeId() { return employeeId; }
    public LocalDate getDate() { return date; }
    public double getHoursWorked() { return hoursWorked; }
}
