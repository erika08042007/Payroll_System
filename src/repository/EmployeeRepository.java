package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Employee;

public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    public boolean add(Employee employee) {
        if (findById(employee.getId()).isPresent()) return false;
        employees.add(employee);
        return true;
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    public Optional<Employee> findById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    public boolean remove(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }
}
