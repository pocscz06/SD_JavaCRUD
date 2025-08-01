import java.util.*;

public class Main {
    public static void main(String[] args) {
        DBUtil.testConnection();

        System.out.println("Enter a command to continue");
        System.out.println("--Options--");
        System.out.println("ADD_EMP firstName lastName socialSecurity salary jobTitle division");
        System.out.println("SEARCH_EMP firstName lastName");
        // Probably gonna rethink how UPDATE_EMP works
        // System.out.println("UPDATE_EMP firstName lastName socialSecurity salary jobTitle division")
        // System.out.println("// For the update command, every parameter should be passed. If you do not want to update a particular parameter, just input an 'X' for that argument.");
        System.out.println("UPDATE_SAL salaryRange percentageIncrease");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("> ");
            String userInput = scanner.nextLine();

            if (userInput == null || userInput.isBlank()) {
                continue;
            }

            List<String> arguments = Arrays.asList(userInput.trim().split("\\s+")); // Takes each spaced user-input and throws it into a list of "arguments"
            String command = arguments.get(0).toUpperCase(Locale.ROOT);

            switch (command) {
                // TODO: Add try-catch blocks for exception handling
                // TODO: Complete UPDATE_EMP
                // TODO: Complete UPDATE_SAL
                case "ADD_EMP":
                    if (arguments.size() != 7) {
                        System.out.println("Usage: ADD_EMP firstName lastName socialSecurity salary jobTitle division");
                        break;
                    }

                    String firstName = arguments.get(1);
                    String lastName = arguments.get(2);
                    String ssn = arguments.get(3);
                    double salary = Double.parseDouble(arguments.get(4));
                    String jobTitle = arguments.get(5);
                    String division = arguments.get(6);

                    // Employee newEmp = new Employee(firstName, lastName, ssn, salary, jobTitle, division);
                    // EmployeeDAO method for adding employee to database

                    break;
                case "SEARCH_EMP":
                    if (arguments.size() != 3) {
                        System.out.println("Usage: SEARCH_EMP firstName lastName");
                        break;
                    }

                    String firstName = arguments.get(1);
                    String lastName = arguments.get(2);

                    // EmployeeDAO method to search database
                    // Employee found = method(firstName, lastName);

                    if (found != null) {
                        // Print employee details
                    } else {
                        System.out.printf("\nEmployee %s %s not found: ", firstName, lastName);
                    }

                    break;
                case "UPDATE_EMP":
                    // DO STUFF
                    break;
                case "UPDATE_SAL":
                    // DO STUFF
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }
    }
}
