public class EmployeeDAO {
    // get employee info, ACTION REQUIRED: set default values to specify how to get data
    public void getEmployee(String fName, String lName, int id) {
        // SELECT * FROM employees WHERE firstName = fName;
        // SELECT * FROM employees WHERE lastName = lName;
        // SELECT * FROM employees WHERE employeeID = id;
    }

    // ACTION REQUIRED: use switch... case to specify how to update employee data
    public void updateEmployeeData(String column, String value, int id) {        // column is the column users want to update
        switch (column) {
            case "first name":
                column = "firstName";
                break;
            case "last name":
                column = "lastName";
                break;
            case "salary":
                // call updateEmployeeSalary() to update salary
                break;
            case "job":
                column = "jobTitle";
                break;
            case "division":
                column = "division";
                break;
        }
        // either this or multiple switch commands
        // UPDATE employees SET { column } = value WHERE employeeID = id;
        // return updated employee column: SELECT * FROM employees WHERE employeeID = id;
    }

    // update employee salary
    public void updateEmployeeSalary(int id, double newSalary) {
        // UPDATE employees SET salary = newSalary WHERE employeeID = id;
        // return updated employee column: SELECT * FROM employees WHERE employeeID = id;
    }

}
