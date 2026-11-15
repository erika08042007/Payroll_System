package service;

import java.time.LocalDate;
import model.Employee;
import model.Payroll;
import repository.PayrollRepository;

public class PayrollService {
    private final PayrollRepository repository;

    public PayrollService(PayrollRepository repository) {
        this.repository = repository;
    }

    public Payroll generatePayroll(Employee employee, double allowance, double deduction) {
        if (employee == null || allowance < 0 || deduction < 0) return null;

        double grossPay = employee.getHourlyRate() * employee.getHoursWorked();
        Payroll payroll = new Payroll(employee.getId(), employee.getName(),
                LocalDate.now(), grossPay, allowance, deduction);
        repository.save(payroll);
        return payroll;
    }

    public java.util.List<Payroll> getPayrollRecords() {
        return repository.findAll();
    }
}
