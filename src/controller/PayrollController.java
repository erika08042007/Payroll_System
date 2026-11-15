package controller;

import model.Employee;
import model.Payroll;
import service.PayrollService;
import view.PayrollView;

public class PayrollController {
    private final PayrollService service;
    private final PayrollView view;

    public PayrollController(PayrollService service, PayrollView view) {
        this.service = service;
        this.view = view;
    }

    public void generate(Employee employee, double allowance, double deduction) {
        Payroll payroll = service.generatePayroll(employee, allowance, deduction);
        if (payroll == null) {
            System.out.println("Unable to generate payroll. Check the entered amounts.");
        } else {
            view.displayPayroll(payroll);
        }
    }

    public void showHistory() {
        view.displayPayrollHistory(service.getPayrollRecords());
    }
}
