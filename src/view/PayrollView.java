package view;

import java.util.List;
import model.Payroll;

public class PayrollView {
    public void displayPayroll(Payroll payroll) {
        System.out.println("\\n===== PAYROLL DETAILS =====");
        System.out.println("Employee ID: " + payroll.getEmployeeId());
        System.out.println("Employee Name: " + payroll.getEmployeeName());
        System.out.println("Pay Date: " + payroll.getPayDate());
        System.out.printf("Gross Pay:       PHP %.2f%n", payroll.getGrossPay());
        System.out.printf("Allowances:      PHP %.2f%n", payroll.getTotalAllowances());
        System.out.printf("Deductions:      PHP %.2f%n", payroll.getTotalDeductions());
        System.out.printf("NET PAY:         PHP %.2f%n", payroll.getNetPay());
        System.out.println("===========================\\n");
    }

    public void displayPayrollHistory(List<Payroll> records) {
        System.out.println("\\n===== PAYROLL HISTORY =====");
        if (records.isEmpty()) {
            System.out.println("No payroll records found.");
            return;
        }
        for (Payroll p : records) {
            System.out.printf("%s | ID: %d | %s | Net: PHP %.2f%n",
                    p.getPayDate(), p.getEmployeeId(), p.getEmployeeName(), p.getNetPay());
        }
    }
}
