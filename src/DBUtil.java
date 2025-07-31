import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASS");

    public static Connection getConnection() throws SQLException {
        try {
            if (URL == null|| USERNAME == null || PASSWORD == null) {
                throw new SQLException("Missing DB credentials");
            }
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } 
        catch (SQLException e) {
            throw e;
        }
        catch (Exception e) {
            throw new SQLException("Unexpected error");
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public static boolean testConnection() {
        try (Connection connection = getConnection()) {
            System.out.println("Database connected successfully");
            return true;
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return false;
        }
    }
}
