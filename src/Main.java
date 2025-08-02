import java.util.*;

public class Main {
    public static void main(String[] args) {
        DBUtil.testConnection();

        System.out.println("Enter a command to continue");
        System.out.println("--Options--");
        System.out.println("ADD_EMP firstName lastName socialSecurity salary jobTitle division");
        System.out.println("SEARCH_EMP firstName lastName");
        System.out.println("UPDATE_EMP employeeID firstName lastName salary jobTitle division (Use 'X' to skip fields)");
        System.out.println("UPDATE_SAL salaryRange percentageIncrease");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.print("> ");
            String userInput = scanner.nextLine();

            if (userInput == null || userInput.isBlank()) {
                continue;
            }

            List<String> arguments = Arrays.asList(userInput.trim().split("\\s+")); // Takes each spaced user-input and throws it into a list of "arguments"
            String command = arguments.get(0).toUpperCase(Locale.ROOT);

            switch (command) {
                case "ADD_EMP":
                    EmployeeService.addEmployee(arguments, scanner);
                    break;
                case "SEARCH_EMP":
                    EmployeeService.searchEmployee(arguments);
                    break;
                case "UPDATE_EMP":
                    EmployeeService.updateEmployee(arguments);
                    break;
                case "UPDATE_SAL":
                    EmployeeService.updateSalary(arguments);
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }
    }
}
