public class EmployeeDAO {
    // get employee info, ACTION REQUIRED: add default parameters for more complex searching
    public void getEmployee(String fName, String lName, int id) {
        // SELECT * FROM employees WHERE firstName = fName;
        // SELECT * FROM employees WHERE firstName = lName;
        // SELECT * FROM employees WHERE employeeID = id;
    }

    // update employee data by entering the column to update and the value
    public void updateEmployeeData(String column, String value, int id) {
        // either this or multiple switch commands
        // UPDATE employees SET { column } = value WHERE employeeID = id;
        // return updated employee column: SELECT * FROM employees WHERE employeeID = id;
    }

    // update employee salary
    public void updateEmployeeSalary(int id, double newSalary) {
        // UPDATE employees SET salary = newSalary WHERE employeeID = id;
    }

}
