import java.util.Scanner;
import controller.EmployeeController;
import controller.PayrollController;
import model.Department;
import model.Employee;
import model.Position;
import repository.EmployeeRepository;
import repository.PayrollRepository;
import service.AttendanceService;
import service.EmployeeService;
import service.PayrollService;
import utility.InputValidator;
import view.EmployeeView;
import view.MenuView;
import view.PayrollView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator input = new InputValidator(scanner);

        EmployeeRepository employeeRepository = new EmployeeRepository();
        PayrollRepository payrollRepository = new PayrollRepository();

        EmployeeService employeeService = new EmployeeService(employeeRepository);
        PayrollService payrollService = new PayrollService(payrollRepository);
        AttendanceService attendanceService = new AttendanceService();

        EmployeeController employeeController =
                new EmployeeController(employeeService, new EmployeeView());
        PayrollController payrollController =
                new PayrollController(payrollService, new PayrollView());
        MenuView menu = new MenuView();

        boolean running = true;
        while (running) {
            menu.displayMenu();
            int choice = input.readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    int id = input.readInt("Employee ID: ");
                    String name = input.readText("Employee name: ");
                    double rate = input.readDouble("Hourly rate (PHP): ");
                    double hours = input.readDouble("Hours worked: ");
                    String department = input.readText("Department: ");
                    String position = input.readText("Position: ");

                    Employee employee = new Employee(id, name, rate, hours,
                            new Department(department), new Position(position));
                    employeeController.addEmployee(employee);
                    break;

                case 2:
                    employeeController.showEmployees();
                    break;

                case 3:
                    int employeeId = input.readInt("Employee ID: ");
                    Employee selected = employeeController.findEmployee(employeeId);
                    if (selected == null) {
                        System.out.println("Employee not found.");
                        break;
                    }
                    double allowance = input.readDouble("Total allowances (PHP): ");
                    double deduction = input.readDouble("Total deductions (PHP): ");
                    payrollController.generate(selected, allowance, deduction);
                    break;

                case 4:
                    payrollController.showHistory();
                    break;

                case 5:
                    int attendanceId = input.readInt("Employee ID: ");
                    double attendanceHours = input.readDouble("Hours for today: ");
                    boolean saved = attendanceService.recordAttendance(attendanceId, attendanceHours);
                    System.out.println(saved ? "Attendance recorded."
                            : "Invalid attendance details.");
                    break;

                case 6:
                    int deleteId = input.readInt("Employee ID to delete: ");
                    employeeController.deleteEmployee(deleteId);
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using Payroll System!");
                    break;

                default:
                    System.out.println("Invalid menu option.");
            }
        }
        scanner.close();
    }
}
