package model;

import java.time.LocalDate;

public class Payroll {
    private int employeeId;
    private String employeeName;
    private LocalDate payDate;
    private double grossPay;
    private double totalAllowances;
    private double totalDeductions;
    private double netPay;

    public Payroll(int employeeId, String employeeName, LocalDate payDate,
                   double grossPay, double totalAllowances, double totalDeductions) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.payDate = payDate;
        this.grossPay = grossPay;
        this.totalAllowances = totalAllowances;
        this.totalDeductions = totalDeductions;
        this.netPay = grossPay + totalAllowances - totalDeductions;
    }

    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public LocalDate getPayDate() { return payDate; }
    public double getGrossPay() { return grossPay; }
    public double getTotalAllowances() { return totalAllowances; }
    public double getTotalDeductions() { return totalDeductions; }
    public double getNetPay() { return netPay; }
}
