package repository;

import java.util.ArrayList;
import java.util.List;
import model.Payroll;

public class PayrollRepository {
    private final List<Payroll> payrollRecords = new ArrayList<>();

    public void save(Payroll payroll) {
        payrollRecords.add(payroll);
    }

    public List<Payroll> findAll() {
        return new ArrayList<>(payrollRecords);
    }
}
