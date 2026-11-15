package view;

import java.util.List;
import model.Employee;

public class EmployeeView {
    public void displayEmployees(List<Employee> employees) {
        System.out.println("\\n===== EMPLOYEE LIST =====");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee employee : employees) System.out.println(employee);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
