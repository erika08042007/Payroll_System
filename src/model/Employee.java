package model;

public class Employee {
    private int id;
    private String name;
    private double hourlyRate;
    private double hoursWorked;
    private Department department;
    private Position position;

    public Employee(int id, String name, double hourlyRate, double hoursWorked,
                    Department department, Position position) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.department = department;
        this.position = position;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public Department getDepartment() { return department; }
    public Position getPosition() { return position; }

    public void setName(String name) { this.name = name; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public void setDepartment(Department department) { this.department = department; }
    public void setPosition(Position position) { this.position = position; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Department: " + department
                + " | Position: " + position + " | Rate/hour: " + hourlyRate
                + " | Hours: " + hoursWorked;
    }
}
