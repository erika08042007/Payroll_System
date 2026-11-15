package controller;

import model.Employee;
import service.EmployeeService;
import view.EmployeeView;

public class EmployeeController {
    private final EmployeeService service;
    private final EmployeeView view;

    public EmployeeController(EmployeeService service, EmployeeView view) {
        this.service = service;
        this.view = view;
    }

    public void addEmployee(Employee employee) {
        boolean added = service.addEmployee(employee);
        view.showMessage(added ? "Employee added successfully."
                : "Could not add employee. Check the details or duplicate ID.");
    }

    public void showEmployees() {
        view.displayEmployees(service.getAllEmployees());
    }

    public Employee findEmployee(int id) {
        return service.findEmployee(id);
    }

    public void deleteEmployee(int id) {
        view.showMessage(service.deleteEmployee(id)
                ? "Employee deleted." : "Employee ID not found.");
    }
}
