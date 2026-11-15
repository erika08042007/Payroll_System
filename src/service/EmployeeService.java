package service;

import java.util.List;
import model.Employee;
import repository.EmployeeRepository;

public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public boolean addEmployee(Employee employee) {
        if (employee.getId() <= 0 || employee.getName().trim().isEmpty()
                || employee.getHourlyRate() < 0 || employee.getHoursWorked() < 0) {
            return false;
        }
        return repository.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee findEmployee(int id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deleteEmployee(int id) {
        return repository.remove(id);
    }
}
