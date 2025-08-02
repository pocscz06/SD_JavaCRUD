import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeService {

    public static void addEmployee(List<String> arguments, Scanner scanner) {
        if (arguments.size() != 7) {
            System.out.println("Usage: ADD_EMP firstName lastName socialSecurity salary jobTitle division");
            return;
        }

        try {
            String firstName = arguments.get(1);
            String lastName = arguments.get(2);
            String ssn = arguments.get(3);
            if (ssn.length() != 9 || !ssn.matches("\\d{9}")) {
                System.out.println("SSN must be exactly 9 digits.");
                return;
            }
            double salary = Double.parseDouble(arguments.get(4));
            String jobTitle = arguments.get(5);
            String division = arguments.get(6);

            System.out.println("Is this employee part-time or full-time? Enter 'PT' or 'FT'.");
            String empStatus = scanner.nextLine().toUpperCase(Locale.ROOT);

            IEmployee newEmp;
            if (empStatus.equals("PT")) {
                newEmp = new PartEmployee(firstName, lastName, ssn, salary, jobTitle, division);
            } else if (empStatus.equals("FT")) {
                newEmp = new FullEmployee(firstName, lastName, ssn, salary, jobTitle, division);
            } else {
                System.out.println("Invalid input! Please try again.");
                return;
            }

            try {
                EmployeeDAO.addEmployee(newEmp);
                System.out.printf("\nEmployee added: %s %s", firstName, lastName);
            } catch (SQLException e) {
                System.out.println("Failed to add employee: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Salary must be a valid number.");
        }
    }

    public static void searchEmployee(List<String> arguments) {
        if (arguments.size() != 3) {
            System.out.println("Usage: SEARCH_EMP firstName lastName");
            return;
        }

        String firstName = arguments.get(1);
        String lastName = arguments.get(2);

        try {
            IEmployee foundEmp = EmployeeDAO.searchByName(firstName, lastName);
            if (foundEmp != null) {
                System.out.println("Employee found:");
                foundEmp.getFullInfo();
            } else {
                System.out.printf("\nEmployee %s %s not found.", firstName, lastName);
            }
        } catch (SQLException e) {
            System.out.println("Search failed: " + e.getMessage());
        }
    }

    public static void updateEmployee(List<String> arguments) {
        if (arguments.size() != 7) {
            System.out.println("Usage: UPDATE_EMP employeeID firstName lastName salary jobTitle division (use 'X' to skip fields)");
            return;
        }
        int empID;
        try {
            empID = Integer.parseInt(arguments.get(1));
        } catch (NumberFormatException e) {
            System.out.println("Invalid employeeID. MUST be of type integer.");
            return;
        }

        String firstName = arguments.get(2);
        String lastName = arguments.get(3);
        String salary = arguments.get(4);
        String jobTitle = arguments.get(5);
        String division = arguments.get(6);

        try {
            EmployeeDAO.updateEmployeePartial(empID, firstName, lastName, salary, jobTitle, division);
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    public static void updateSalary(List<String> arguments) {
        if (arguments.size() != 3) {
            System.out.println("Usage: UPDATE_SAL salaryRange percentageIncrease");
            return;
        }

        String range = arguments.get(1);
        String percentageIncrease = arguments.get(2);

        try {
            String[] parts = range.split("-");
            if (parts.length != 2) {
                System.out.println("salaryRange must be in format min-max (i.e., 58000-105000)");
                return;
            }
            double min = Double.parseDouble(parts[0]);
            double max = Double.parseDouble(parts[1]);
            double percent = Double.parseDouble(percentageIncrease);
            try {
                EmployeeDAO.updateSalaryByPercentageRange(min, max, percent);
            } catch (SQLException e) {
                System.out.println("Salary update failed: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in range or percentage. Proper example: UPDATE_SAL 58000-105000 3.2");
        }
    }
}
