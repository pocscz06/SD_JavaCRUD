import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployeeDAO {

    public static void addEmployee(IEmployee emp) throws SQLException {
        String sql = "INSERT INTO employees (firstName, lastName, socialSecurity, salary, jobTitle, division) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);) {
                ps.setString(1, emp.getFirstName());
                ps.setString(2, emp.getLastName());
                ps.setString(3, emp.getSSN());
                ps.setDouble(4, emp.getSalary());
                ps.setString(5, emp.getJobTitle());
                ps.setString(6, emp.getDivision());
                ps.executeUpdate();

                try (ResultSet generated = ps.getGeneratedKeys()) {
                    if (generated.next()) {
                        int newID = generated.getInt(1);
                        if (emp instanceof FullEmployee fe) {
                            fe.setEmployeeID(newID);
                        } else if (emp instanceof PartEmployee pe) {
                            pe.setEmployeeID(newID);
                        }
                    }
                }
            }
    }

    public static IEmployee searchByName(String firstName, String lastName) throws SQLException {
        String sql = "SELECT * FROM employees WHERE firstName = ? AND lastName = ?";
        try (Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return mapResultSetToEmployee(rs);
                    }
                }
            }
        return null;
    }

    public static IEmployee searchByEmployeeID(int employeeID) throws SQLException {
        String sql = "SELECT * FROM employees WHERE employeeID = ?";
        try (Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, employeeID);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return mapResultSetToEmployee(rs);
                    }
                }
            }
        return null;
    }

    public static IEmployee searchBySSN(String ssn) throws SQLException {
        String sql = "SELECT * FROM employees WHERE socialSecurity = ?";
        try (Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, ssn);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return mapResultSetToEmployee(rs);
                    }
                }
            }
        return null;
    }

    public static void updateEmployeePartial(int employeeID, String firstName, String lastName, String salaryStr, String jobTitle, String division) throws SQLException {
        Map<String, Object> updates = new LinkedHashMap<>();

        if (!"X".equalsIgnoreCase(firstName)) updates.put("firstName", firstName);
        if (!"X".equalsIgnoreCase(lastName)) updates.put("lastName", lastName);
        if (!"X".equalsIgnoreCase(salaryStr)) {
            try {
                double salary = Double.parseDouble(salaryStr);
                updates.put("salary", salary);
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary format.");
                return;
            }
        }
        if (!"X".equalsIgnoreCase(jobTitle)) updates.put("jobTitle", jobTitle);
        if (!"X".equalsIgnoreCase(division)) updates.put("division", division);

        if (updates.isEmpty()) {
            System.out.println("No fields to update.");
            return;
        }

        StringBuilder sql = new StringBuilder("UPDATE employees SET ");
        List<String> setClauses = new ArrayList<>();
        for (String col : updates.keySet()) {
            setClauses.add(col + " = ?");
        }
        sql.append(String.join(", ", setClauses));
        sql.append(" WHERE employeeID = ?");

        try (Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql.toString())) {
                int index = 1;
                for (Object value : updates.values()) {
                    if (value instanceof String) {
                        ps.setString(index++, (String) value);
                    } else if (value instanceof Double) {
                        ps.setDouble(index++, (Double) value);
                    }
                }
                ps.setInt(index, employeeID);

                int affectedRows = ps.executeUpdate();
                if (affectedRows == 0) {
                    System.out.printf("\nNo employee found with ID: %d; nothing was updated.", employeeID);
                } else {
                    System.out.println("Employee updated successfully.");
                }
            }
    }

    public static void updateSalaryByPercentageRange(double minSalary, double maxSalary, double percentIncrease) throws SQLException {
        String sql = "UPDATE employees SET salary = salary * (1 + ? / 100) WHERE salary >= ? AND salary < ?";
        try (Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setDouble(1, percentIncrease);
                ps.setDouble(2, minSalary);
                ps.setDouble(3, maxSalary);
                ps.executeUpdate();
            }
    }

    // HELPER FUNCTION(S)
    // Takes data from database (ResultSet) and converts it into a FullEmployee object
    // The method itself returns an IEmployee, so it could be converted between a PT or FT employee easily
    private static IEmployee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        return new FullEmployee(
            rs.getInt("employeeID"),
            rs.getString("firstName"),
            rs.getString("lastName"),
            rs.getString("socialSecurity"),
            rs.getDouble("salary"),
            rs.getString("jobTitle"),
            rs.getString("division")
        );
    }
}
